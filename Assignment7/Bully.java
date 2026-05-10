import java.util.*;

public class Bully {

    static int[] process;
    static boolean[] active;
    static int n;
    static int coordinator;

    // Election Function
    static void election(int initiator) {

        coordinator = initiator;

        for (int i = 0; i < n; i++) {

            if (process[i] > initiator && active[i]) {

                System.out.println("Process " + initiator +
                        " sends ELECTION to " + process[i]);

                election(process[i]);
                break;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        n = sc.nextInt();

        process = new int[n];
        active = new boolean[n];

        System.out.println("Enter process IDs:");

        for (int i = 0; i < n; i++) {
            process[i] = sc.nextInt();
            active[i] = true;
        }

        // Simulate highest process failure
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            if (process[i] > process[maxIndex]) {
                maxIndex = i;
            }
        }

        active[maxIndex] = false;

        System.out.println("Process " +
                process[maxIndex] + " failed.");

        System.out.print("Enter initiator process ID: ");
        int initiator = sc.nextInt();

        System.out.println("\n--- Bully Election Started ---");

        election(initiator);

        System.out.println("\nProcess " + coordinator +
                " becomes COORDINATOR");

        sc.close();
    }
}