import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Cat {
    private String name;
    private double weight;
    private int freq;

    public Cat(String name, double weight, int freq) {
        this.name = name;
        this.weight = weight;
        this.freq = freq;
    }
    
    @Override
    public String toString() {
        return "Имя = " + name + ", масса = " + weight + ", частота мурчания = " + freq;
    }
    

    public static void main(String[] args) {
        ArrayList<Cat> cats = new ArrayList<>();
        String way = "3.3.txt";
        BufferedReader br = null;
        try {
            File my_file = new File(way);
            br = new BufferedReader(new FileReader(way)); 
            String st;
            while ((st = br.readLine()) != null) {
                String[] parts = st.split(" ");
                if (parts.length != 3) {
                    System.out.println("Строка не подходит: " + st);
                    continue; 
                }
                String name = parts[0];
                double weight;
                int freq;

                try {
                    weight = Double.parseDouble(parts[1]);
                    freq = Integer.parseInt(parts[2]);
                } catch (NumberFormatException e) {
                    System.out.println("Значения чисел в строке не подходят: " + st);
                    continue;
                
                }
                cats.add(new Cat(name, weight, freq));
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ee) {
                    System.out.println( "Ошибка при закрытии  файла: " + ee.getMessage());
                }
            }    
        }
        
        
        for (Cat cat : cats) {
            System.out.println(cat);
        }
        
    }
}
