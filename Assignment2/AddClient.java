import java.rmi.*;

public class AddClient
        implements Runnable {

    double num1, num2;

    AddClient(double num1,
              double num2) {

        this.num1 = num1;
        this.num2 = num2;
    }

    public void run() {

        try {

            AddServerIntf addObj =
                (AddServerIntf)
                Naming.lookup(
                    "rmi://localhost/AddServer"
                );

            double result =
                    addObj.add(num1, num2);

            System.out.println(
                num1 + " + "
                + num2 + " = "
                + result
            );

        } catch (Exception e) {

            System.out.println(
                "Client Error: " + e
            );
        }
    }

    public static void main(String args[]) {

        Thread t1 =
            new Thread(
                new AddClient(10, 20)
            );

        Thread t2 =
            new Thread(
                new AddClient(5, 7)
            );

        Thread t3 =
            new Thread(
                new AddClient(100, 50)
            );

        t1.start();
        t2.start();
        t3.start();
    }
}