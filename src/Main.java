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
        PrintWriter out = new PrintWriter("output.txt");
        for (int i = 0; i < n; i++) {  //алгоритм
            int min = i;
            String text_i = "";
            for (int j = min + 1; j < n; j++) {
                if (mass[j] < mass[min])
                    min = j;
            }
            if (min != i) {
                int temp = mass[i];
                mass[i] = mass[min];
                mass[min] = temp;
                text_i = "Swap elements at indices " + (i + 1) + " and " + (min + 1) + ".";
                out.println(text_i);
            }
        }
        out.println("No more swaps needed.");
        String text = "";
        for (int i = 0; i < n; i++)
            text = text + mass[i] + " ";
        out.println(text);
        out.close();
    }
}
