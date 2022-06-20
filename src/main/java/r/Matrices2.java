package r;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static java.util.stream.IntStream.range;

class Matrices2 {
    int N = 32;
    String chemin = "C:\\Users\\gille\\IdeaProjects\\Matrices11" +
            "\\src\\main\\java\\r\\";
    String chemindiv = "C:\\Users\\gille\\IdeaProjects\\Matrices11" +
            "\\src\\main\\java\\r\\ndiv\\";
    int[][] mat = new int[N + 1][N + 1];
    int C;

    public Matrices2() {
        fdiv(N);
        writeTextToFile(mat, chemindiv, N);
        f(N);
        writeTextToFile(mat, chemin, N);
    }

    public static void main(String[] args) {
        new Matrices2();
    }

    void f(int N) {
        range(0, N + 1).forEach(k -> range(0, N + 1).forEach(l ->
        {

            range(0, N + 1).forEach(i -> range(0, N + 1).forEach(j ->
            {
                if (i * j == k * l) C++;
            }));

            mat[k][l] = C;
            C = 0;
        }));
    }

    void fdiv(int N) {
        range(0, N + 1).forEach(k -> range(0, N + 1).forEach(l ->
        {

            range(0, k * l).forEach(i -> range(0, k * l).forEach(j ->
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
