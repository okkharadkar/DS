import java.util.*;

class Process {
    int id;
    boolean active;

    Process(int id) {
        this.id = id;
        this.active = true;
    }
}

public class Ring {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        Process[] p = new Process[n];

        System.out.println("Enter process IDs:");

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            p[i] = new Process(id);
        }

        Arrays.sort(p, Comparator.comparingInt(a -> a.id));

        // Highest process failure
        p[n - 1].active = false;

        System.out.println("Process " +
                p[n - 1].id + " failed.");

        System.out.print("Enter initiator process ID: ");
        int initiatorId = sc.nextInt();

        int initiator = -1;

        for (int i = 0; i < n; i++) {
            if (p[i].id == initiatorId) {
                initiator = i;
                break;
            }
        }

        System.out.println("\n--- Ring Election Started ---");

        int i = initiator;
        int maxId = -1;

        do {

            if (p[i].active) {

                System.out.println("Process " +
                        p[i].id +
                        " passes ELECTION message");

                maxId = Math.max(maxId, p[i].id);
            }

            i = (i + 1) % n;

        } while (i != initiator);

        System.out.println("\nProcess " +
                maxId +
                " becomes COORDINATOR");

        sc.close();
    }
}