import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        int n = Integer.parseInt(in.readLine().trim());
        String s = in.readLine().trim();
        int [] mass = new int[n];
        int [] mass_i = new int[n];
        int index_1 = 0;
        int index_2;

        for (int k = 0; k < n; k++) {
            if (k == n - 1) {
                index_2 = s.length();
            }
            else {
                index_2 = s.indexOf(" ", index_1 + 1);
            }
            mass[k] = Integer.parseInt(s.substring(index_1, index_2));
            index_1 = index_2 + 1;
        }

        mass_i[0] = 1;

        for (int j = 1; j < n; j++) {
            int i = j - 1;

            while (i >= 0 && mass[i] > mass[i + 1]) {
                int temp = mass[i];
                mass[i] = mass[i + 1];
                mass[i + 1] = temp;
                i--;
            }
            mass_i[j] = i + 2;
        }

        for (int i = 0; i < n; i++)
            System.out.print(mass[i] + " ");
        System.out.println();

        System.out.println(n);
        System.out.println(s);

        String text_i = "";
        String text_mass = "";
        for (int i = 0; i < n; i++) {
            text_i = text_i + mass_i[i] + " ";
            text_mass = text_mass + mass[i] + " ";
        }
        PrintWriter out = new PrintWriter("output.txt");
        out.println(text_i);
        out.println(text_mass);
        out.close();
    }
}
