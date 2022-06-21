package r;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static java.util.stream.IntStream.range;

class Matrices3 {
    int N = 32;
    String chemin = "C:\\Users\\gille\\IdeaProjects\\Matrices11" +
            "\\src\\main\\java\\r\\";
    String chemindiv = "C:\\Users\\gille\\IdeaProjects\\Matrices11" +
            "\\src\\main\\java\\r\\ndiv\\";
    int[][] mat = new int[N + 1][N + 1];
    int C;

    public Matrices3() {
        f(N, true);
        writeTextToFile(mat, chemindiv, N);
        f(N, false);
        writeTextToFile(mat, chemin, N);
    }

    public static void main(String[] args) {
        new Matrices3();
    }

    void f(int N, boolean div) {
        range(0, N + 1).forEach(k -> range(0, N + 1).forEach(l ->
        {

            int n = div ? k * l : N + 1;

            range(0, n).forEach(i -> range(0, n).forEach(j ->
            {
                if (i * j == k * l) C++;
            }));

            mat[k][l] = C;
            C = 0;
        }));
    }

    void writeTextToFile(int[][] tab, String fileaddr, int n) {
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

}
