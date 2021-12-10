package day1;
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        String fileName = "day1/input.txt";
        FileInputStream file = new FileInputStream(fileName);
        Kattio io = new Kattio(file,System.out);
        ArrayList<Integer> inputs = new ArrayList<>();
        while (io.hasMoreTokens()){
            inputs.add(io.getInt());
        }
        int n = inputs.get(0)+inputs.get(1)+inputs.get(2);
        int sum ;
        int count = 0;
        for(int i=1;i<inputs.size()-2; i++) {
            sum = inputs.get(i)+inputs.get(i+1)+inputs.get(i+2);
            if (n<sum) {
                count++;
            }
            n=sum;
        }
        io.println(count);
        io.close();
    }    
}
