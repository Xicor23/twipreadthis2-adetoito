package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws java.io.FileNotFoundException {

        Scanner file = new Scanner(new File("C:\\User\\ad100\\IdeaProjects\\twipreadthis2-adetoito\\Imports.txt"));

        int maxIndex = 0;
        String everything[] = new String[1000];

        while (file.hasNext()) {
            maxIndex++;
            everything[maxIndex] = file.nextLine();
        }

        String firstNames[] = new String[1000];
        String lastNames[] = new String[1000];
        double averages[] = new double[1000];
        int absences[] = new int[1000];

        for (int index = 0; index <= maxIndex; index++) {
            Scanner sc = new Scanner(everything[index]);
            // Insert delimiter stuff here.
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String cut [] = new String [2];

                cut[0] = line.split("\\t");
                firstNames[index] = line.split(cut[0]);
            }
        }

    }
}
