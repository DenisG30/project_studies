// Задание 3.2.
import java.io.*;
import java.util.Random;

public class ReadAndSumValueOfFiles {
    static final int ER_WRONG = 1;
    static final int ER_READ_F = 2;
    static final int ER_CLOSE_F = 3;

    public static int SumValue(String[] num) {
        int sum = 0;
        for(int i = 0; i < num.length; i++) {
            String num1 = num[i];
            int sum1 = 0;
            int res1 = readAndSum(num1, sum1);
            if (res1 == ER_WRONG || res1 == ER_READ_F || res1 == ER_CLOSE_F) {
                return res1;
            }
            sum += res1;
        }
        /* 
        int sum2 = 0;
        int res2 = readAndSum(num2, sum2);
        if (res2 == ER_WRONG || res2 == ER_READ_F || res2 == ER_CLOSE_F) {
            return res2;
        }
        */

        //int sum = res1 + res2;
        return sum;
    }
    
    private static int readAndSum(String num, int sum) {
        BufferedReader br = null;
        try{
            File my_file = new File(num);
            br = new BufferedReader(new FileReader(my_file));
            String st;
            while ((st = br.readLine()) != null) {
                try {
                    sum += Integer.parseInt(st);
                } catch (NumberFormatException ex) {
                    return ER_WRONG;
                }   
            }
        } catch(IOException e) {
            return ER_READ_F;
        } finally {   
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ee) {
                    return ER_CLOSE_F;
                }
            }   
        }
        return sum; 
    }
    
    public static void main(String[] args) {
        //Random rand = new Random();

        String[] fileWay1 = {"1.txt", "2.txt", "3.txt", "4.txt"};
        //String fileWay1 = (rand.nextInt(9) + 1) + ".txt";
        //String fileWay2 = (rand.nextInt(9) + 1) + ".txt";

        int res = SumValue(fileWay1);

        switch (res) {
            case ER_WRONG:
                System.out.println("Ошибка! В одном из файлов присутствует недопустимое число.");
                break;
            case ER_READ_F:
                System.out.println("Ошибка при чтении файла.");
                break;
            case ER_CLOSE_F:
                System.out.println("Ошибка при закрытии файла.");
                break;
            default:
                System.out.println("Сумма всех значений равна " + res);
                break;
        }   
    }
}
