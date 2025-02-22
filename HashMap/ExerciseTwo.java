import java.util.ArrayList;
import java.util.HashMap;


public class ExerciseTwo {
    public static ArrayList<Integer> keyValue(ArrayList<Integer> mylist, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> num = new ArrayList<>();

        for (int number : mylist) {
            map.put(number, map.getOrDefault(number, 0) + 1);
            if (map.get(number) == n) { 
                num.add(number);
            } else if (!num.contains(number) && map.get(number) > n) { 
                num.add(number);
            }
        }
        return num;
    }
}
