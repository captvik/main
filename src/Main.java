import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        int n = Integer.parseInt(in.readLine().trim());
        String s = in.readLine().trim();
        float [] mass = new float[n];
        int [] mass_i = new int[n];
        int index_1 = 0;
        int index_2;

        for (int k = 0; k < n; k++) {  //заполнение массива из файла
            if (k == n - 1) {
                index_2 = s.length();
            }
            else {
                index_2 = s.indexOf(" ", index_1 + 1);
            }
            mass[k] = Float.parseFloat(s.substring(index_1, index_2));
            mass_i[k] = k + 1;
            index_1 = index_2 + 1;
        }

        for (int j = 1; j < n; j++) {  //алгоритм
            int i = j - 1;

            while (i >= 0 && mass[i] > mass[i + 1]) {
                float temp = mass[i];
                int temp_i = mass_i[i];
                mass[i] = mass[i + 1];
                mass_i[i] = mass_i[i + 1];
                mass[i + 1] = temp;
                mass_i[i + 1] = temp_i;
                i--;
            }
        }

        int sr = (mass_i.length - 1) / 2;
        String text_i = mass_i[0] + " " + mass_i[sr] + " " + mass_i[mass_i.length - 1];

        PrintWriter out = new PrintWriter("output.txt");
        out.println(text_i);
        out.close();
    }
}
