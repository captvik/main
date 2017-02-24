import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        String s = in.readLine();
            s = s.trim();
            BigInteger a = BigInteger.valueOf(Integer.parseInt(s.substring(0, s.lastIndexOf(" "))));
            BigInteger b = BigInteger.valueOf(Integer.parseInt(s.substring(s.lastIndexOf(" ") + 1, s.length())));
            String text = (a.add(b.multiply(b))).toString();
            PrintWriter out = new PrintWriter("output.txt");
            out.println(text);
            out.close();
    }
}
