import Test.Sorting;

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = 0;

        Sorting s = new Sorting();

        bw.write(Arrays.toString(s.people));
        bw.close();
    }
}