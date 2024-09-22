File Information


•	Program Filename: FermatLastTheoremNearMisses.java


•	External Files: None required to run the program.


•	Output Files: None are created by the program.


Programmer Information

•	Programmers:

o	Hemanthsai Chittiboina

o	Varun Raj Chanda

•	Email Address:

o	HemanthsaiChittibo@lewisu.edu

o	Varunrajchandausaa2023@gmail.com

•	Course Number: FA24-CPSC-60500 - Software Engineering, Section-001 

•	Submission Date4:  09/22/2024

Program Explanation

This Java program searches for "near-misses" related to Fermat's Last Theorem. Specifically, it computes near-solutions to the equation:

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

                System.out.println(n + " " + k + " X= " + smallestMissX + ", y= " + smallestMissY + ", relative diff= " + String.format("%.7f", relativeMiss));
    }
    }




x^n + y^n = z^n

For any values of x, y, and z where n is an integer between 3 and 11, the program attempts to minimize the difference between x^n + y^n and the closest integer power of z^n. The user will input the power n and the upper limit k for the values of x and y, and the program will print the pair of numbers (x, y) that provide the closest approximation to a solution.


The program will prompt you to enter:

•	A power n where 2 < n < 12.

•	An upper limit k for the numbers x and y, where k > 10.

Example Run

Enter the power to use in the equation (2 < n < 12): 3

Enter the upper limit for x and y (k > 10): 30

Output: n=3 k=30 X= 18, Y= 20, relative diff= 0. 0005784


Resources Used

•	https://en.wikipedia.org/wiki/Fermat's_Last_Theorem

•	https://www.geeksforgeeks.org/fermats-last_theorem/
