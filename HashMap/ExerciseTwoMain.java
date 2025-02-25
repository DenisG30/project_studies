import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ExerciseTwoMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        ArrayList<Integer> mylist = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            mylist.add(i, rand.nextInt(10) + 1);
        }

        System.out.println("Введите значение числа n");
        int n = Integer.parseInt(sc.nextLine());

        sc.close();

        HashMap<Integer, Integer> repVal = new HashMap<Integer, Integer>();
        repVal = ExerciseTwo.keyValue(mylist, n);
        if (!repVal.isEmpty()) {
            System.out.println("Числа, повторяющиеся не менее " + n + " раз: " + repVal.keySet());
        } else {
            System.out.println("В данном списке не существует чисел повторяющихся не менее " + n + " раз!");
        }
    }
}
