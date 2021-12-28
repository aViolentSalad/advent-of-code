package day4;
import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {
    public static void printSheets( ArrayList<ArrayList<ArrayList<Integer>>> bingoList){
        for(ArrayList<ArrayList<Integer>> n : bingoList){
            System.out.println(n);
        }
    }
    public static void main(String[] args) throws Exception {
        String fileName = "day4/input.txt";
        FileInputStream file = new FileInputStream(fileName);
        Kattio io = new Kattio(file, System.out);
        String[] inputBingo = io.getWord().split(",", -1);
        ArrayList<ArrayList<Integer>> sheet = new ArrayList<>();
        ArrayList<Integer>  rows= new ArrayList<>();
        ArrayList<ArrayList<ArrayList<Integer>>> bingoSheets = new ArrayList<>();
        int n;
        int ans = 0;
        while(io.hasMoreTokens()){
            n = io.getInt();
            if(rows.size()<5){
                rows.add(n);
            }else if (sheet.size() < 5) {
                sheet.add(rows);
                rows = new ArrayList<>();
                rows.add(n);
            }else{
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
        for(String num : inputBingo){
            int input = Integer.valueOf(num);
            Mark.marking(input,bingoSheets);
            int [] checkout = Mark.check(bingoSheets);
           // System.out.println((int)Array.get(checkout, 0));
            if ((int)Array.get(checkout, 0) == 1){
                ansIdx = (int)Array.get(checkout, 1);
                ArrayList<ArrayList<Integer>> ansSheet = bingoSheets.get(ansIdx);
                for(ArrayList<Integer> row : ansSheet){
                    for (int ansNum :row){
                        if (ansNum !=111){
                            ans+=ansNum;
                        }
                    }
                }
                ans = ans * input;
                break;
            }
        }
        
        
       // printSheets(bingoSheets);
       // io.println(ansIdx);
        io.println(ans);
        io.close();
    }
}