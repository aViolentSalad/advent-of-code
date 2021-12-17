package day3;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String fileName = "day3/input.txt";
        FileInputStream file = new FileInputStream(fileName);
        Kattio io = new Kattio(file, System.out);
        ArrayList<Integer> ones = new ArrayList<>();
        ArrayList<Integer> zeros = new ArrayList<>();
        while (io.hasMoreTokens()) {
            String n = io.getWord();
            for (int i = 0; i < n.length(); i++) {
                if (zeros.size() <= i ) zeros.add(0);
                if (ones.size() <= i) ones.add(0); 
                if (n.charAt(i) == '1') {
                    ones.set(i, ones.get(i) + 1);
                } else if (n.charAt(i) == '0') {
                    zeros.set(i, zeros.get(i) + 1);
                }
            }
        }
        //System.out.println(zeros);
        //System.out.println(ones);
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();
        for (int i = 0; i < ones.size(); i++) {
            int a = ones.get(i);
            int b = zeros.get(i);
            if (a > b) {
                gamma.append(1);
                epsilon.append(0);

            } else if (b > a) {
                gamma.append(0);
                epsilon.append(1);
            }

        }
        //System.out.println(gamma.toString());
        int gamma_rate = Integer.parseInt(gamma.toString(),2);
        int epsilon_rate = Integer.parseInt(epsilon.toString(),2);
        int ans = gamma_rate*epsilon_rate;
        System.out.println(ans);
        io.close();
    }
}