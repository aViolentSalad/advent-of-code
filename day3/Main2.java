package day3;

import java.util.*;
import java.io.*;

public class Main2 {
    public static void main(String[] args) throws Exception {
        String fileName = "day3/input.txt";
        FileInputStream file = new FileInputStream(fileName);
        Kattio io = new Kattio(file, System.out);
        ArrayList<String> ones = new ArrayList<>();
        ArrayList<String> zeros = new ArrayList<>();
        while (io.hasMoreTokens()) {
            String n = io.getWord();
            if (n.charAt(0) == '1') {
                ones.add(n);
            } else {
                zeros.add(n);
            }
        }
        ArrayList<String> oxy = new ArrayList<>();
        ArrayList<String> co2 = new ArrayList<>();

        if (ones.size() >= zeros.size()) {
            oxy.addAll(ones);
            co2.addAll(zeros);
        } else {
            oxy.addAll(zeros);
            co2.addAll(ones);
        }
        ones.clear();
        zeros.clear();
        ArrayList<String> ones1 = new ArrayList<>();
        ArrayList<String> zeros1 = new ArrayList<>();
        int idx = 1;

        while ((oxy.size() > 1) | (co2.size() > 1)) {
            if (oxy.size()>1) {
                for (String ele : oxy) {
                    if (ele.charAt(idx) == '1') {
                        ones.add(ele);
                    } else {
                        zeros.add(ele);
                    }
                }
                oxy.clear();
                if (ones.size() >= zeros.size()) {
                    oxy.addAll(ones);
                } else {
                    oxy.addAll(zeros);
                }
                System.out.println(oxy);
            }
            if (co2.size()>1) {
                for (String ele1 : co2) {
                    if (ele1.charAt(idx) == '1') {
                        ones1.add(ele1);
                    } else {
                        zeros1.add(ele1);
                    }
                }
                co2.clear();
                if (ones1.size() >= zeros1.size()) {
                    co2.addAll(zeros1);
                } else {
                    co2.addAll(ones1);
                }
                System.out.println(co2);
            }
            ones.clear();
            zeros.clear();
            ones1.clear();
            zeros1.clear();
            idx++;
        }
        System.out.print(oxy);
        System.out.print(co2);
        int ans = Integer.parseInt(co2.get(0),2) * Integer.parseInt(oxy.get(0),2);

        System.out.println(ans);
        io.close();
    }

}
