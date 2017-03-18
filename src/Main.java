import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        int n = Integer.parseInt(in.readLine().trim());
        String s = in.readLine().trim();
        int [] mass = new int[n];
        int index_1 = 0;
        int index_2;


        for (int k = 0; k < n; k++) {  //заполнение массива из файла
            if (k == n - 1) {
                index_2 = s.length();
            }
            else {
                index_2 = s.indexOf(" ", index_1 + 1);
            }
            mass[k] = Integer.parseInt(s.substring(index_1, index_2));
            index_1 = index_2 + 1;
        }
        int L = 1;
        int R = mass.length;
        PrintWriter out = new PrintWriter("output.txt");
        mass = merge_sort(mass, L, R, out);
        String text = "";
        for (int i = 0; i < n; i++)
            text = text + mass[i] + " ";
        out.println(text);
        out.close();
    }

    public static int [] merge_sort(int [] mass, int L, int R, PrintWriter out) {
        int s = R - L + 1;
        if (s == 1)
            return mass;
        int n = s/2;
        int m = s - s/2;
        int Lr = L + n - 1;
        int Rl = L + n;
        merge_sort(mass, L, Lr, out);
        merge_sort(mass, Rl, R, out);
        int i = L - 1;
        int j = Rl - 1;
        int k = 0;
        int [] mass_merge = new int [n + m];
        while ((i < Lr) || (j < R)) {
            if ((j == R) || ((i < Lr) && (mass [i] <= mass [j]))) {
                mass_merge [k] = mass [i];
                i++;
            }
            else {
                mass_merge [k] = mass [j];
                j++;
            }
            k++;
        }

        i = L - 1;
        for (int f = 0; f < (n + m); f++) {
            mass[i] = mass_merge[f];
            i++;
        }
        out.println(L + " " + R + " " + mass [0] + " " + mass [mass.length - 1] );
        return mass;
    }

}
