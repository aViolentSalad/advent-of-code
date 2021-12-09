package day1; 

import java.io.*;
import java.util.ArrayList;

class Reader{
    public static ArrayList<Integer> read(String fileName)throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String inputline;
        ArrayList<Integer> input = new ArrayList<>();
        while ((inputline = reader.readLine()) != null){
            int n = Integer.valueOf(inputline);
            input.add(n);
        }
        reader.close();
        return input;
    }
}

