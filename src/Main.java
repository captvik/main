import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        int n = Integer.parseInt(in.readLine().trim());
        String s = in.readLine().trim();
        int [] mass = new int[n];
        //int [] mass_i = new int[n];
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
            //mass_i[k] = k + 1;
            index_1 = index_2 + 1;
        }
        PrintWriter out = new PrintWriter("output.txt");
        for (int j = 1; j < n; j++) {  //алгоритм
            int i = j - 1;
            String text_i = "";
            while (i >= 0 && mass[i] > mass[i + 1]) {
                int temp = mass[i];
                //int temp_i = mass_i[i];
                mass[i] = mass[i + 1];
                //mass_i[i] = mass_i[i + 1];
                mass[i + 1] = temp;
                //mass_i[i + 1] = temp_i;
                text_i = "Swap elements at indices " + (i + 1) + " and " + (j + 1) + ".";
                i--;
            }
            if (i != j - 1)
                out.println(text_i);
        }
        out.println("No more swaps needed.");
        String text = "";
        for (int i = 0; i < n; i++)
            text = text + mass[i] + " ";
        out.println(text);
        out.close();
    }
}
