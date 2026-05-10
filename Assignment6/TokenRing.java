import java.util.Scanner;

public class TokenRing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int token = 0; // Initially token with process 0

        int choice;

        do {

            System.out.print("\nEnter process requesting Critical Section: ");
            int request = sc.nextInt();

            // Pass token until requested process gets it
            while (token != request) {

                System.out.println("Token passed from P" + token +
                        " to P" + ((token + 1) % n));

                token = (token + 1) % n;
            }

            // Critical Section
            System.out.println("Process P" + request +
                    " is EXECUTING Critical Section");

            System.out.println("Process P" + request +
                    " has EXITED Critical Section");

            // Pass token to next process
            token = (token + 1) % n;

            System.out.println("Token passed to P" + token);

            System.out.print("\nDo you want another request? (1/0): ");
            choice = sc.nextInt();

        } while (choice == 1);

        sc.close();
    }
}