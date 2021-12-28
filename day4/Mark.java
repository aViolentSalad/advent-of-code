package day4;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Mark {
    public static ArrayList<ArrayList<ArrayList<Integer>>> marking(int n,
            ArrayList<ArrayList<ArrayList<Integer>>> bingoSheet) {
        for (ArrayList<ArrayList<Integer>> sheets : bingoSheet) {
            for (ArrayList<Integer> rows : sheets) {
                for (int col = 0; col < rows.size(); col++) {
                    if (rows.get(col) == n) {
                        rows.set(col, 111);
                    }
                }
            }
        }
        return bingoSheet;
    }

    public static int[] check(ArrayList<ArrayList<ArrayList<Integer>>> bingoSheet) {
        int count = -1;
        for (ArrayList<ArrayList<Integer>> sheets : bingoSheet) {
            count++;
            ArrayList<Integer> colCheckSum = new ArrayList<>();
            colCheckSum.add(0);
            colCheckSum.add(0);
            colCheckSum.add(0);
            colCheckSum.add(0);
            colCheckSum.add(0);
            for (int rowIdx = 0; rowIdx < (sheets.size()); rowIdx++) {
                int rowCheckSum = 0;
                ArrayList<Integer> rows = sheets.get(rowIdx);
                for (int colIdx = 0; colIdx < (rows.size() - 1); colIdx++) {
                    if (rows.get(colIdx)==111 && rows.get(colIdx + 1) == 111) {
                        rowCheckSum++;
                    }
                }
                if (rowCheckSum == 4) {
                    int [] ans = {1,count};
                    return ans;
                }
                if (rowIdx < 4) {
                    ArrayList<Integer> nextRow = sheets.get(rowIdx+1);
                    for (int i = 0; i < 5; i++) {
                        if (rows.get(i) == 111 && nextRow.get(i)== 111){
                            colCheckSum.set(i,colCheckSum.get(i)+1);
                        }
                    }
                }
                for ( int i : colCheckSum){
                    if (i==4){
                        int [] ans = {1,count};
                        return ans;
                    }
                }
            }
        }
        int [] ans = {0,count};
        return ans;
    }
}
