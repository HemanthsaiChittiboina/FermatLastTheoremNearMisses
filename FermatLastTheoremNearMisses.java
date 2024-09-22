import java.util.Scanner;

public class FermatLastTheoremNearMisses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the power to use in the equation (2 < n < 12): ");
        int n = scanner.nextInt();

        System.out.print("Enter the upper limit for x and y (k > 10): ");
        int k = scanner.nextInt();

        double smallestMiss = Double.POSITIVE_INFINITY;
        int smallestMissX = 0;
        int smallestMissY = 0;
        int smallestMissZ = 0;

        for (int x = 10; x <= k; x++) {
            for (int y = x; y <= k; y++) {
                double sumXY = Math.pow(x, n) + Math.pow(y, n);
                int z = (int) Math.round(Math.pow(sumXY, 1.0 / n));
                double miss = Math.min(Math.abs(sumXY - Math.pow(z, n)), Math.abs(Math.pow(z + 1, n) - sumXY));
                double relativeMiss = miss / sumXY;

                if (relativeMiss < smallestMiss) {
                    smallestMiss = relativeMiss;
                    smallestMissX = x;
                    smallestMissY = y;
                    smallestMissZ = z;
                }
            }
        }

        double sumXY = Math.pow(smallestMissX, n) + Math.pow(smallestMissY, n);
        double miss = Math.min(Math.abs(sumXY - Math.pow(smallestMissZ, n)), Math.abs(Math.pow(smallestMissZ + 1, n) - sumXY));
        double relativeMiss = miss / sumXY;

        System.out.println("\nSmallest possible miss:");
        System.out.println("x: " + smallestMissX + ", y: " + smallestMissY + ", z: " + smallestMissZ);
        System.out.println("Actual miss: " + miss);
        System.out.println("Relative miss: " + relativeMiss * 100 + "%");

        System.out.println("Press Enter to exit...");
        scanner.nextLine();
    }
}