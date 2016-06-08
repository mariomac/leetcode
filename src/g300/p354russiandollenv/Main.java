package g300.p354russiandollenv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
		Solution s = new Solution();
        LinkedList<int[]> data = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("data.txt")));
        String read = null;
        do {
            read = br.readLine();
            if (read != null) {
                sb.append(read);
            }
        } while(read != null);
        String[] numbers = sb.toString().split("[^\\d]");
        int pairs = 0;
        while(pairs < numbers.length) {
            String num1 = numbers[pairs++];
            while(pairs < numbers.length && num1.trim().equals("")) {
                num1 = numbers[pairs++];
            }
            String num2 = numbers[pairs++];
            while(pairs < numbers.length && num2.trim().equals("")) {
                num2 = numbers[pairs++];
            }
            if(pairs < numbers.length) {
                data.add(new int[]{new Integer(num1), new Integer(num2)});
                pairs++;
            }
        }
        System.out.println(pairs + " read numbers");
        System.out.println(s.maxEnvelopes(data.toArray(new int[0][])));
    }
}
