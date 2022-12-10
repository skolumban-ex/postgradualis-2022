package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;

public class Main {

    static int[][] tableToFill = new int[9][9];

    static int[] emptyRowIndeces, getEmptyColumnIndeces;

    public static void main(String[] args) throws IOException {

        readInitialTable();

        int[] alap = new int[emptyRowIndeces.length];

        backtrack(alap);
    }

    private static void backtrack(int[] partialSolution) {
        if (shouldReject(partialSolution))
            return;
        if (isCompleteSolution(partialSolution))
            displayTable(partialSolution);

        int[] extended = extend(partialSolution);
        while (extended != null) {
            backtrack(extended);
            int[] nextExtended = getNextPartialOnSameLevel(extended);
            extended = nextExtended;
        }
    }

    private static int[] getNextPartialOnSameLevel(int[] extended) {
        // melyik szinten vagyunk
        int currentLevel = extended.length-1;
        while (extended[currentLevel] == 0)
            --currentLevel;

        if (extended[currentLevel] == 9)
            // ezen a szinten van-e meg hova probalgatni
            return  null;
        else{
            // a szinten belul a k0vetkezot osszerakjuk
            int[] ret= new int[extended.length];
            for (int i = 0; i < currentLevel; i++) {
                ret[i] = extended[i];
            }
            ret[currentLevel] = extended[currentLevel]+1;
            return ret;
        }
    }

    private static int[] extend(int[] partialSolution) {

        if (partialSolution[partialSolution.length - 1] != 0)
            return null;

        int[] extended = new int[partialSolution.length];
        int copyPosition = 0;
        while (copyPosition < partialSolution.length
                && partialSolution[copyPosition] != 0) {
            extended[copyPosition] = partialSolution[copyPosition];
            copyPosition++;
        }

        // szintfuggo elso ertelmes megoldasjavaslat
        extended[copyPosition] = 1;

        return extended;
    }

    private static boolean isCompleteSolution(int[] partialSolution) {
        return partialSolution[partialSolution.length - 1] != 0;
    }

    private static boolean shouldReject(int[] alap) {
        int[][] mergedSolution = mergeSolution(alap);

        int[] toCheck = new int[9];
        // sorban minden egyedi
        for (int sorId = 0; sorId < 9; sorId++) {
            for (int oszlopId = 0; oszlopId < 9; oszlopId++) {
                toCheck[oszlopId] = mergedSolution[sorId][oszlopId];
            }
            // toCheck az i.sor
            if (somethingIsDouble(toCheck))
                return true;
        }

        // oszlopban is minden egyedi
        for (int oszlopId = 0; oszlopId < 9; ++oszlopId) {
            for (int sorId = 0; sorId < 9; sorId++) {
                toCheck[sorId] = mergedSolution[sorId][oszlopId];
            }
            // toCheck az i.sor
            if (somethingIsDouble(toCheck))
                return true;
        }

        // 3x3-as blokkokban minden egyedi
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // i,j-dik 3x3-as blokkot keressük ki
                int toCheckIdx = 0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        toCheck[toCheckIdx] = mergedSolution[i * 3 + k][j * 3 + l];
                        ++toCheckIdx;
                    }
                }
                if (somethingIsDouble(toCheck))
                    return true;
            }
        }

        return false;
    }

    private static boolean somethingIsDouble(int[] toCheck) {
        boolean[] seen = new boolean[9];
        for (int i : toCheck) {
            if (i == 0)
                // a reszleges megoldas ide nem mond semmit
                continue;

            if (seen[i - 1])
                return true;
            else
                seen[i - 1] = true;
        }

        return false;
    }

    private static int[][] mergeSolution(int[] alap) {
        int[][] ret = new int[9][9];
        for (int i = 0; i < tableToFill.length; i++) {
            for (int j = 0; j < tableToFill[i].length; j++) {
                ret[i][j] = tableToFill[i][j];
            }
        }

        for (int i = 0; i < alap.length; i++) {
            ret[emptyRowIndeces[i]][getEmptyColumnIndeces[i]] = alap[i];
        }

        return ret;
    }

    private static void readInitialTable() throws IOException {
        int emptyPositionCount = 0;

        File f = new File("sudoku.txt");
        FileReader fr = new FileReader(f);
        Scanner sc = new Scanner(fr);
        for (int i = 0; i < 9; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < 9; j++) {
                if (line.charAt(j) == '*') {
                    tableToFill[i][j] = 0;
                    ++emptyPositionCount;
                } else
                    tableToFill[i][j] = line.charAt(j) - '0';
            }
        }
        fr.close();

        emptyRowIndeces = new int[emptyPositionCount];
        getEmptyColumnIndeces = new int[emptyPositionCount];
        int emptyPosCounter = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (tableToFill[i][j] == 0) {
                    emptyRowIndeces[emptyPosCounter] = i;
                    getEmptyColumnIndeces[emptyPosCounter] = j;
                    ++emptyPosCounter;
                }
            }
        }
    }

    private static void displayTable(int[] solution) {

        int[][] merged = mergeSolution(solution);

        for (int i = 0; i < merged.length; i++) {
            for (int j = 0; j < merged[i].length; j++) {
                System.out.print(merged[i][j]);
            }
            System.out.println();
        }
    }
}
