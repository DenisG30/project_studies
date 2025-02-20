// Задание 3.2.
import java.io.*;
import java.util.Random;

public class ReadAndSumValueOfFiles {
    static final int OK = 0;
    static final int ER_WRONG = 1;
    static final int ER_READ_F = 2;
    static final int ER_CLOSE_F = 3;

    public static HashMap<Integer, Integer> SumValue(String[] num) {
        HashMap<Integer, Integer> errAndSum = new HashMap<Integer, Integer>();
        int keys = 0;
        int values = 0;
                
        for (int i = 0; i < num.length; i++) {
            int[] arr = readAndSum(num[i]);
        
            if (arr[0] != 0) {
                keys = arr[0];
                errAndSum.put(keys, values);
                return errAndSum;
            }    
         
            values += arr[1];
            errAndSum.put(keys, values);
        }
        return errAndSum;
    }
    
    private static int[] readAndSum(String num) {
        int[] arr = new int[2];
        int sum = 0;
        arr[0] = 0; // Статус
        arr[1] = 0;  // Сумма
        BufferedReader br = null;
        
        try{
            File my_file = new File(num);
            br = new BufferedReader(new FileReader(my_file));
            String st;
            while ((st = br.readLine()) != null){
                try {
                    sum += Integer.parseInt(st);
                } catch (NumberFormatException ex) {
                    arr[0] = 1;
                }   
            }
            
        } catch(IOException e) {
            arr[0] = 2;
        } finally {   
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ee) {
                    arr[0] = 3;
                }
            }
        }
        arr[1] = sum;
        return arr; 
    }
    
    public static void main(String[] args) {
        String[] fileWay1 = {"1.txt", "2.txt", "3.txt", "4.txt"};
        HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();
        res = SumValue(fileWay1);
    }
}
