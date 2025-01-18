// Задание 3.1.
import java.io.*;
import java.util.Random;

public class CreationFiles {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        for(int i = 1; i <= 10; i++) {
            File my_file = new File(i + ".txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(my_file));
            for(int j = 1; j <= 3; j++) {
                bw.write(String.valueOf(rand.nextInt(1000)));
                bw.newLine();
            }
            bw.close();
        }
    }
}
