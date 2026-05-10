import java.util.*;

public class Berkeley {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        int[] time = new int[n];

        // Input clock times
        System.out.println("Enter time for each node:");

        for (int i = 0; i < n; i++) {
            System.out.print("Node " + (i + 1) + ": ");
            time[i] = sc.nextInt();
        }

        // Calculate average time
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += time[i];
        }

        int avg = sum / n;

        System.out.println("\nAverage time: " + avg);

        // Calculate adjustments
        System.out.println("\nAdjustments:");

        for (int i = 0; i < n; i++) {

            int diff = avg - time[i];

            System.out.println(
                    "Node " + (i + 1) +
                    " adjustment: " + diff
            );

            // Synchronize clock
            time[i] += diff;
        }

        // Display synchronized clocks
        System.out.println("\nSynchronized Time:");

        for (int i = 0; i < n; i++) {
            System.out.println(
                    "Node " + (i + 1) +
                    ": " + time[i]
            );
        }

        sc.close();
    }
}