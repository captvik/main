import java.io.*;
import java.math.BigInteger;

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
        int s = mass.length;
        if (s == 1)
            return mass;
        int n = s/2;
        int m = s - s/2;
        int [] mass_l = new int [n];
        int [] mass_r = new int [m];
        for (int i = 0; i < s; i++) {
            if (i < n)
                mass_l [i] = mass [i];
            else
                mass_r [i - n] = mass [i];
        }
        mass_l = merge_sort(mass_l, L, L + n - 1, out);
        mass_r = merge_sort(mass_r, L + n, R, out);
        int i = 0;
        int j = 0;
        int k = 0;

        int [] mass_merge = new int [n + m];
        while ((i < n) || (j < m)) {
            if ((j == m) || ((i < n) && (mass_l [i] <= mass_r [j]))) {
                mass_merge [k] = mass_l [i];
                i++;
            }
            else {
                mass_merge [k] = mass_r [j];
                j++;
            }
            k++;
        }
        out.println(L + " " + R + " " + mass_merge [0] + " " + mass_merge [mass_merge.length - 1] );
        return mass_merge;
    }

}
