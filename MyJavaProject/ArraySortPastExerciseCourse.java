import java.util.Random;

public class ArraySortPastExerciseCourse {   
    
    public static int[] Sort (int[] a1) {
        int n = a1.length;
        boolean change = true;
        int x = 0;
        while(change) {
            change = false;
            for(int i = 0; i < n - 1; i++)
                if(a1[i] > a1[i + 1]) {
                    x = a1[i];
                    a1[i] = a1[i + 1];
                    a1[i + 1] = x;
                    change = true;
                } 
        }
        return a1;
    }

    public static void main(String[] args){
        Random rand = new Random();
        
        int n = 10;
        int[] a1 = new int[n];

        for(int i = 0; i < n; i++) 
            a1[i] = rand.nextInt(50) + 1;
          
        a1 = ArraySortPastExerciseCourse.Sort(a1);
        System.out.println(a1[3]);
    }
}