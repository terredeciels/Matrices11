package r;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.BiFunction;

class Matrices {

    static int N = 32;
    static String chemin = "C:\\Users\\gille\\IdeaProjects\\Matrices11" +
            "\\src\\main\\java\\r\\";
    static String chemindiv = "C:\\Users\\gille\\IdeaProjects\\Matrices11" +
            "\\src\\main\\java\\r\\ndiv\\";
    static BiFunction<Integer, Integer, Integer> g = (k, l) -> k * l;

    static int[][] f(int N) {
        int[][] mat = new int[N + 1][N + 1];

        for (int k = 0; k < N + 1; k++) {
            for (int l = 0; l < N + 1; l++) {
                int C = 0;

                for (int i = 0; i < g.apply(N + 1, 1); i++) {
                    for (int j = 0; j < g.apply(N + 1, 1); j++) {

                        if (i * j == k * l) {
                            C++;
                        }

                    }
                }
                mat[k][l] = C;

            }
        }
        return mat;
    }

    static int[][] fdiv(int N) {
        int[][] mat = new int[N + 1][N + 1];

        for (int k = 0; k < N + 1; k++) {
            for (int l = 0; l < N + 1; l++) {
                int C = 0;

                for (int i = 1; i <= g.apply(k, l); i++) {
                    for (int j = 1; j <= g.apply(k, l); j++) {

                        if (i * j == k * l) {
                            C++;
                        }

                    }
                }
                mat[k][l] = C;

            }
        }
        return mat;
    }

    public static void main(String[] args) {
        writeTextToFile(fdiv(N), chemindiv, N);
        writeTextToFile(f(N), chemin, N);
    }

    public static void writeTextToFile(int[][] tab, String fileaddr, int n) {
        StringBuilder ret = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                ret.append(tab[i][j]).append(",");
            }
            ret.append("\n");
        }

        try {
            FileWriter fw = new FileWriter(fileaddr + n + ".txt", false);
            BufferedWriter output = new BufferedWriter(fw);
            output.write(ret.toString());
            output.flush();
            output.close();
        } catch (IOException ioe) {
            System.out.println("error " + ioe);
        }
    }

    private static class A {
    }
}
