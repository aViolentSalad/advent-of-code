package day4;

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main2 {
    public static void printSheets(ArrayList<ArrayList<ArrayList<Integer>>> bingoList) {
        for (ArrayList<ArrayList<Integer>> n : bingoList) {
            for (ArrayList<Integer> i : n) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String fileName = "day4/input.txt";
        FileInputStream file = new FileInputStream(fileName);
        Kattio io = new Kattio(file, System.out);
        String[] inputBingo = io.getWord().split(",", -1);
        ArrayList<ArrayList<Integer>> sheet = new ArrayList<>();
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<ArrayList<ArrayList<Integer>>> bingoSheets = new ArrayList<>();
        int n;
        int ans = 0;
        while (io.hasMoreTokens()) {
            n = io.getInt();
            if (rows.size() < 5) {
                rows.add(n);
            } else if (sheet.size() < 5) {
                sheet.add(rows);
                rows = new ArrayList<>();
                rows.add(n);
            } else {
                bingoSheets.add(sheet);
                sheet = new ArrayList<>();
                sheet.add(rows);
                rows = new ArrayList<>();
                rows.add(n);
            }
        }
        sheet.add(rows);
        bingoSheets.add(sheet);
        int ansIdx = 0;
        for (String num : inputBingo) {
            int input = Integer.valueOf(num);
            Mark.marking(input, bingoSheets);
            while ((int) Array.get(Mark.check(bingoSheets), 0) == 1) {
                ansIdx = (int) Array.get(Mark.check(bingoSheets), 1);
                if (bingoSheets.size() > 1) {
                    bingoSheets.remove(ansIdx);
                }else{
                    break;
                }
            }
            if (bingoSheets.size() == 1 & (int) Array.get(Mark.check(bingoSheets), 0) == 1) {
                ArrayList<ArrayList<Integer>> ansSheet = bingoSheets.get(0);
                for (ArrayList<Integer> row : ansSheet) {
                    for (int ansNum : row) {
                        if (ansNum != 111) {
                            ans += ansNum;
                        }
                    }
                }
                ans = ans * input;
                break;
            }
            io.println(bingoSheets.size());
        }
        printSheets(bingoSheets);
        io.println(ans);
        io.close();
    }
}