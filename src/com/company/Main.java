package com.company;

import java.io.*;
import java.util.*;

// THIS IS FOR YOU JACOB

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new File("Imports.txt"));
        String importedTxt[] = new String[1000];
        int maxIndex = -1;

        while (sc.hasNext()) {
            maxIndex++;
            importedTxt[maxIndex] = sc.nextLine();
        }

        String firstNames[] = new String[1000];
        String lastNames[] = new String[1000];
        double averages[] = new double[1000];
        int absences[] = new int[1000];

        // Copying lines into array

        for (int index = 0; index <= maxIndex; index++) {
            String segments[] = new String[4];

            String temp = String.valueOf(importedTxt[index].split("\\t"));
            segments[0] = temp;
            firstNames[index] = segments[0];

            temp = String.valueOf(temp.split("\\t"));
            segments[1] = temp;
            lastNames[index] = segments[1];

            temp = String.valueOf(temp.split("\\t"));
            segments[2] = temp;
            averages[index] = Double.parseDouble(segments[2]);

            temp = String.valueOf(temp.split("\\t"));
            segments[3] = temp;
            absences[index] = Integer.parseInt(segments[3]);
        }

        // Print out class average

        double sum = 0;

        for (int index = 0; index < averages.length; index++) {
            sum += averages[index];
        }
        sum /= averages.length;
        System.out.println(sum);

        // Amount of A's, B's, C's, D's, and F's

        int A = 0, B = 0, C = 0, D = 0, F = 0;

        for (int index = 0; index < averages.length; index++) {
            if (averages[index] >= 90) {
                A += 1;
            } else if (averages[index] >= 80 && averages[index] < 90) {
                B += 1;
            } else if (averages[index] >= 70 && averages[index] < 80) {
                C += 1;
            } else if (averages[index] >= 60 && averages[index] < 70) {
                D += 1;
            } else {
                F += 1;
            }
        }
        System.out.println("Amount of A's: " + A);
        System.out.println("Amount of B's: " + B);
        System.out.println("Amount of C's: " + C);
        System.out.println("Amount of D's: " + D);
        System.out.println("Amount of F's: " + F);

        // Search Feature

        boolean action = true;
        Scanner sc2 = new Scanner(System.in);

        while (action) {
            boolean prompt = true;
            String input = "";
            while (prompt) {
                System.out.println("Type in the student's first and last name.");
                if (sc2.hasNext()) {
                    input = sc2.nextLine();
                    prompt = false;
                }
            }
            String portions[] = input.split("\\s");
            String fn = portions[0];
            String ln = portions[1];

            int i = -1;
            for (int index = 0; index < firstNames.length; index++) {
                if (fn.equalsIgnoreCase(firstNames[index]) && ln.equalsIgnoreCase(lastNames[index])) {
                    i = index;
                    break;
                }
            }
            if (i != -1) {
                System.out.println("Student Name: " + firstNames[i] + " " + lastNames[i]);
                System.out.println("Average: " + averages[i]);
                System.out.println("Number of Absences: " + absences[i]);
                double ranks[] = new double[averages.length];
                for (int index = 0; index < ranks.length; index++) {
                    ranks[index] = averages[index];
                }
                Arrays.sort(ranks);
                int rank = 0;
                for (int index = 0; index < ranks.length; index++) {
                    if (averages[i] == ranks[index]) {
                        rank = index + 1;
                    }
                }
                System.out.println("Class Rank: " + rank);

                if (absences[i] > 10 && averages[i] < 75) {
                    System.out.println("The amount of absences is hurting this student's grade.");
                }
            }
        }
    }
}
