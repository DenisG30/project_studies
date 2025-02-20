// Задание 3.2.
import java.io.*;
import java.util.Random;

public class ReadAndSumValueOfFiles {
    static final int OK = 0;
    static final int ER_WRONG = 1;
    static final int ER_READ_F = 2;
    static final int ER_CLOSE_F = 3;

    public static HashMap<String, Integer> SumValue(String[] num) {
        int sum = 0;
        HashMap<String, Integer> valueAndError = new HashMap<String, Integer>();
        valueAndError.put("error", 0);
        valueAndError.put("value", 0);
        
        for (int i = 0; i < num.length; i++) {
            int[] arr = readAndSum(num[i]);
            if (arr[0] != 0) {
                valueAndError.remove("error");
                valueAndError.put("error", arr[0]);
                return valueAndError;
            }    
            sum += arr[1];
        }
        valueAndError.remove("value");
        valueAndError.put("value", sum);
        return valueAndError;
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
        HashMap<String, Integer> res = new HashMap<String, Integer>();
        res = SumValue(fileWay1);

        switch (res.get("error")) {
            case OK:
                    System.out.println("Сложение завершено! Сумма значений равна " + res.get("value"));   
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
