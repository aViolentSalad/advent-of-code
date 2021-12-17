package day2;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String fileName = "day2/input.txt";
        FileInputStream file = new FileInputStream(fileName);
        Kattio io = new Kattio(file,System.out);
        ArrayList<Integer> cord = new ArrayList<>(3);
        int n;
        cord.add(0);
        cord.add(0); 
        cord.add(0);
        while(io.hasMoreTokens()) {
            String direc = io.getWord();
            String amt = io.getWord();
            //System.out.println(direc);
            if (direc.contains("forward")) {
                n = cord.get(0) + Integer.valueOf(amt);
                //System.out.println(1);
                cord.set(0,n);
                int depth = cord.get(1) + cord.get(2) * Integer.valueOf(amt);
                cord.set(1,depth);
            }else if(direc.contains("down")) {
                n =cord.get(2) + Integer.valueOf(amt);
                //System.out.println(2);
                cord.set(2,n);
            }else {
                n = cord.get(2) - Integer.valueOf(amt);
                cord.set(2,n);
                //System.out.println(3);
            }
            //System.out.println("cord" + cord);
        }   
        int ans = cord.get(0) * cord.get(1);
        io.println(ans);
        io.close();
    }
}