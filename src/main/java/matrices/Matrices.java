package matrices;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.IntStream.range;
import static matrices.WriteTextToFile.writeTextToFile;

class Matrices {
    int N = 32;
    String chemin = "C:\\Users\\gille\\IdeaProjects\\Matrices11" +
            "\\src\\main\\java\\matrices\\";
    String chemindiv = "C:\\Users\\gille\\IdeaProjects\\Matrices11" +
            "\\src\\main\\java\\matrices\\ndiv\\";
    int[][] mat = new int[N + 1][N + 1];
    int C;
    int n;

    public Matrices() {
        f2(N, true);
        writeTextToFile(mat, chemindiv, N);
        f2(N, false);
        writeTextToFile(mat, chemin, N);
    }

    public static void main(String[] args) {
        new Matrices();
    }

    void f(int N, boolean div) {
        range(0, N + 1).forEach(k -> range(0, N + 1).forEach(l ->
        {

            n = div ? k * l : N + 1;

            range(0, n).forEach(i -> range(0, n).forEach(j ->
            {
                if (i * j == k * l) C++;
            }));

            mat[k][l] = C;
            C = 0;
        }));
    }

    List<A> P = new ArrayList<>();
    List<A> Q = new ArrayList<>();

    {

        range(0, N + 1).forEach(k -> range(0, N + 1).forEach(l -> P.add(new A(k, l, k * l, 0))));
//
//        P.forEach((A a) ->
//                range(0, a.p).forEach(i -> range(0, a.p).forEach(j -> Q.add(new A(a.k, a.l, a.p, i * j)))));

    }

    void f2(int N, boolean div) {

        P.forEach(a -> {
                    n = div ? a.p : N + 1;

                        range(0, n).forEach(i -> range(0, n).forEach(j ->
                        {
                            if (i*j == a.p) C++;
                        }));

            mat[a.k][a.l] = C;
            C = 0;
        });

    }

    record A(int k, int l, int p, int q) {
    }
}
