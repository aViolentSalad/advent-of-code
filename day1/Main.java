package day1;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        String filename = "day1/input.txt";
        ArrayList<Integer> inputs = Reader.read(filename);
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
        System.out.println(count);
    }    
}
