// Задание 3.2.
import java.io.*;
import java.util.Random;

public class ReadAndSumValueOfFiles {

    public static String SumValue(String num1, String num2) {
        int sum1 = 0;
        BufferedReader brOne = null;
        try{
            File my_fileOne = new File(num1);
            brOne = new BufferedReader(new FileReader(my_fileOne));
            String st1;
            int count1 = 0;
            while ((st1 = brOne.readLine()) != null) {
                count1 ++;
                try {
                    sum1 += Integer.parseInt(st1); 
                } catch (NumberFormatException ex) {
                    return "Ошибка! Строка " + count1 + " не является числом. " + ex.getMessage();
                }   
            }
        } catch(IOException e) {
            return "Ошибка при чтении файла: " + e.getMessage();
        } finally {   
            if (brOne != null) {
                try {
                    brOne.close();
                } catch (IOException ee) {
                    return "Ошибка при закрытии  файла: " + ee.getMessage();
                }
            }
        }  

        int sum2= 0;
        BufferedReader brTwo = null;
        try{
            File my_fileTwo = new File(num2);
            brTwo = new BufferedReader(new FileReader(my_fileTwo));
            String st2;
            int count2 = 0;
            while ((st2 = brTwo.readLine()) != null) {
                count2 ++;
                try {
                    sum2 += Integer.parseInt(st2); 
                } catch (NumberFormatException ex) {
                    return "Ошибка! Строка " + count2 + " не является числом. " + ex.getMessage();
                }   
            }
        } catch(IOException e) {
            return "Ошибка при чтении файла: " + e.getMessage();
        } finally {   
            if (brTwo != null) {
                try {
                    brTwo.close();
                } catch (IOException ee) {
                    return "Ошибка при закрытии  файла: " + ee.getMessage();
                }
            }
        }

        int sum = sum1 + sum2;
        return String.valueOf(sum);
    } 
    public static void main(String[] args) {
        Random rand = new Random();

        String fileWay1 = (rand.nextInt(9) + 1) + ".txt";
        String fileWay2 = (rand.nextInt(9) + 1) + ".txt";

        System.out.println(SumValue(fileWay1, fileWay2));
        
    }
}