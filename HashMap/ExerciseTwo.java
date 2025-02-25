import java.util.ArrayList;
import java.util.HashMap;


public class ExerciseTwo {
    public static HashMap<Integer, Integer> keyValue(ArrayList<Integer> mylist, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> num = new HashMap<>();

        for (int number : mylist) {
            map.put(number, map.getOrDefault(number, 0) + 1);
            if (map.get(number) >= n ) {
                if(!num.isEmpty()) {
                    num.remove(number);
                } 
                num.put(number, map.get(number));
            }
        }
        return num;
    }
}
