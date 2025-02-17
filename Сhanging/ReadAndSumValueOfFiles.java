// Задание 3.2.
import java.io.*;
import java.util.Random;

public class ReadAndSumValueOfFiles {
    static final int OK = 0;
    static final int ER_WRONG = 1;
    static final int ER_READ_F = 2;
    static final int ER_CLOSE_F = 3;

    public static int[] SumValue(String[] num) {
        int[] res = new int[2]; // код ошибки и общая сумма
        res[0] = 0;
        res[1] = 0;
        
        for (int i = 0; i < num.length; i++) {
            int[] arr = readAndSum(num[i]);
            if (arr[0] != 0) {
                res[0] = arr[0];
                return res;
            }    
            res[1] += arr[1];
        }
        return res;
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
    
        int[] res = new int[2];
        res = SumValue(fileWay1);

        switch (res[0]) {
            case OK:
                    System.out.println("Сложение завершено! Сумма значений равна " + res[1]);   
                break;
            case ER_WRONG:
                    System.out.println("Ошибка! В одном из файлов присутствует недопустимое число.");   
                break;
            case ER_READ_F:
                System.out.println("Ошибка при чтении файла.");
                break;
            case ER_CLOSE_F:
                System.out.println("Ошибка при закрытии файла.");
                break;
        }
    }
}
