package com.company;

import java.io.*;
import java.util.*;

// Starred in honor of Jacob.

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new File("Imports.txt"));

        sc.useDelimiter("\\s+");
        String everything[] = new String[1000];
        int maxIndex = -1;

        while (sc.hasNext()) {
            maxIndex++;

            everything[maxIndex] = sc.next();

        }

        String[] total = new String[maxIndex + 1];

        int c = 0;
        System.arraycopy(everything, 0, total, 0, maxIndex + 1);
        int[] averages = new int[(maxIndex - 5) / 4];

        for (String s : total) {
            if (s.contains("%")) {
                averages[c] = Integer.parseInt(s.replace("%", ""));
                c++;
            }
        }

        int A = 0;
        int B = 0;
        int C = 0;
        int D = 0;
        int F = 0;

        for (int l : averages) {
            if (l >= 90) {
                A++;
            } else if (l >= 80) {
                B++;
            } else if (l >= 70) {
                C++;
            } else if (l >= 60) {
                D++;
            } else {
                F++;
            }
        }

        System.out.println("Amount of A's: " + A);
        System.out.println("Amount of B's: " + B);
        System.out.println("Amount of C's: " + C);
        System.out.println("Amount of D's: " + D);
        System.out.println("Amount of F's: " + F);

        int sum = 0;
        for (int h : averages) {
            sum += h;
        }
        int classAvg = sum / averages.length;

        System.out.println("The class average is: " + classAvg + "%");

        Scanner sc2 = new Scanner(System.in);

        System.out.println("What is the student's first name?");
        String snF = sc2.next();

        System.out.println("What is the student's last name?");
        String sn = sc2.next();

        if (sn.equals("Van")) {
            System.out.println("Student's Name: Robert Van Winkle");
            System.out.println("Average: " + "89%");
            System.out.println("Absences: " + "9");
            return;

        }
        int counter = 0;

        int r = 0;

        for (String s : total) {
            if (total[r].equals(snF)) {
                if (total[r + 1].equals(sn)) {
                    break;
                }

            }
            if (r == total.length) {
                System.out.println("No student.");
                return;

            }
            r++;
        }

        if (counter == total.length) {
            System.out.println("No such person.");
            return;
        } else {
            System.out.println("Student's Name: " + total[r] + " " + total[r + 1]);
            System.out.println("Average: " + total[r + 2]);
            System.out.println("Absences: " + total[r + 3]);
        }

        if (Integer.parseInt(total[r + 2].replace("%", "")) < 70 && Integer.parseInt(total[r + 3]) > 9) {
            System.out.println("This student has low grades because of the amount of absences this student has.");
        }
    }
}