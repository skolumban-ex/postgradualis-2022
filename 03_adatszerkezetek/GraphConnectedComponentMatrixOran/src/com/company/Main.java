package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Graf g = new Graf("D:\\Koli\\Munka\\Atkepzesi program\\03 Programozas es adatszerkezetek\\bbte-it-03-programozas-es-adatszerkezetek\\bemenet_18_05.txt");

        if (g.IsConnected())
            System.out.println("A graf osszefuggo.");
        else
            System.out.println("A graf nem osszefuggo.");
    }
}

class Graf {
    boolean[][] szomszedsag;

    public Graf(String path) throws IOException {
        Path p = Paths.get(path);
        File f = p.toFile();
        FileReader reader = new FileReader(f);
        Scanner sc = new Scanner(reader);

        int nodeCount = Integer.parseInt(sc.nextLine());

        szomszedsag = new boolean[nodeCount][nodeCount];

        for (int i = 0; i < nodeCount; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < nodeCount; j++) {
                if (line.charAt(j) == '1')
                    szomszedsag[i][j] = true;
                else
                    szomszedsag[i][j] = false;
            }
        }

        reader.close();
    }

    public boolean IsConnected() {

        if (szomszedsag.length == 0)
            return true;

        HashSet<Integer> reachedVertices = new HashSet<>();

        LinkedList<Integer> nodesToDiscoverFurther = new LinkedList<>();

        nodesToDiscoverFurther.addLast(0);

        while (!nodesToDiscoverFurther.isEmpty()) {
            int nodeToDiscover = nodesToDiscoverFurther.pollFirst();

            if (!reachedVertices.contains(nodeToDiscover)) {
                for (int i = 0; i < szomszedsag.length; i++) {
                    if (szomszedsag[nodeToDiscover][i] &&
                            !nodesToDiscoverFurther.contains(i)
                            &&
                            !reachedVertices.contains(i))
                        nodesToDiscoverFurther.addLast(i);
                }
            }

            reachedVertices.add(nodeToDiscover);
        }

        return reachedVertices.size() == szomszedsag.length;
    }
}
