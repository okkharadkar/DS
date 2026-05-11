import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class SimpleWebservice {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        server.createContext("/", exchange -> {
            if (!"GET".equalsIgnoreCase(exchange.getRequestMethod())) {
                send(exchange, 405, "Method Not Allowed", "text/plain");
                return;
            }

            Path htmlPath = Path.of("C:\\Users\\OM\\eclipse-workspace\\Test\\src\\index.html");
            if (!Files.exists(htmlPath)) {
                send(exchange, 404, "index.html not found", "text/plain");
                return;
            }

            String html = Files.readString(htmlPath, StandardCharsets.UTF_8);
            send(exchange, 200, html, "text/html; charset=UTF-8");
        });

        server.createContext("/add", exchange -> handleMath(exchange, "add"));
        server.createContext("/subtract", exchange -> handleMath(exchange, "subtract"));
        server.createContext("/multiply", exchange -> handleMath(exchange, "multiply"));
        server.createContext("/multipl", exchange -> handleMath(exchange, "multiply"));
        server.createContext("/divide", exchange -> handleMath(exchange, "divide"));

        server.start();
        System.out.println("Server running at http://localhost:8000");
        System.out.println("Open UI at http://localhost:8000/");
    }

    private static void handleMath(HttpExchange exchange, String operation) throws IOException {
        if (!"GET".equalsIgnoreCase(exchange.getRequestMethod())) {
            send(exchange, 405, "Method Not Allowed", "text/plain");
            return;
        }

        String query = exchange.getRequestURI().getQuery();
        if (query == null) {
            send(exchange, 400, "Use query params like ?a=10&b=20", "text/plain");
            return;
        }

        String aText = getQueryValue(query, "a");
        String bText = getQueryValue(query, "b");

        if (aText == null || bText == null) {
            send(exchange, 400, "Missing query params. Use ?a=10&b=20", "text/plain");
            return;
        }

        try {
            int a = Integer.parseInt(aText);
            int b = Integer.parseInt(bText);
            String result;

            if ("add".equals(operation)) {
                result = String.valueOf(a + b);
            } else if ("subtract".equals(operation)) {
                result = String.valueOf(a - b);
            } else if ("multiply".equals(operation)) {
                result = String.valueOf(a * b);
            } else {
                if (b == 0) {
                    send(exchange, 400, "Cannot divide by zero", "text/plain");
                    return;
                }
                result = String.valueOf((double) a / b);
            }

            send(exchange, 200, "Result = " + result, "text/plain");
        } catch (NumberFormatException e) {
            send(exchange, 400, "a and b must be integers", "text/plain");
        }
    }

    private static String getQueryValue(String query, String key) {
        String[] parts = query.split("&");

        for (String part : parts) {
            String[] pair = part.split("=", 2);
            if (pair.length == 2 && key.equals(pair[0])) {
                return URLDecoder.decode(pair[1], StandardCharsets.UTF_8);
            }
        }

        return null;
    }

    private static void send(HttpExchange exchange, int status, String body, String contentType) throws IOException {
        exchange.getResponseHeaders().set("Content-Type", contentType);
        byte[] data = body.getBytes(StandardCharsets.UTF_8);
        exchange.sendResponseHeaders(status, data.length);

        try (OutputStream os = exchange.getResponseBody()) {
            os.write(data);
        }
    }
}