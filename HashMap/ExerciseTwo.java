import java.util.ArrayList;
import java.util.HashMap;


public class ExerciseTwo {
    public static ArrayList<Integer> keyValue(ArrayList<Integer> mylist, int n) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int number : mylist) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

         ArrayList<Integer> num = new ArrayList<>();
        
        for (HashMap.Entry<Integer, Integer> meaning : map.entrySet()) {
             if (meaning.getValue() >= n) {
                 num.add(meaning.getKey());
             }
        }
        return num;
    }
}
