import java.util.HashMap;
import java.util.Random;

public class ExerciseOne {
    public static void main(String[] args) {
        HashMap<Integer, String> dict = new HashMap<Integer, String>();
        Random rand = new Random();
        int n = 100;
        Integer[] keys = new Integer[n];

        for (int i = 0; i < n; i++) {
            int key = rand.nextInt(n); 
            keys[i] = key;
            String value = "String " + i;    
            dict.put(key, value);
            System.out.println(key + " " + value);
        }

        for (Integer key : keys) {
            System.out.println("Ключ: " + key + ", Значение: " + dict.get(key));
        }

        dict.clear();

        System.out.println(dict.size());
    }    
}