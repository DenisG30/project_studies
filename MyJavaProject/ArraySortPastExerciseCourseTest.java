import org.junit.Test;
import static org.junit.Assert.*;
    
public class ArraySortPastExerciseCourseTest {        
    @Test
    public void testSortArray() {
        Random random = new Random();
        for(int i = 0; i < 100; i++) {
            int n = 10; 
            int [] a2 = new int[n];
            int [] a3 = new int[n];
            for(int j = 0; j < n; j++) {
                a2[j] = random.nextInt(10) + 1;
                a3[j] = a2[j];
            }
            Arrays.sort(a2);
            assertArrayEquals(a2, ArraySortPastExerciseCourse.Sort(a3));
        } 
    }

    @Test
    public void testSortArrayEqualValue() {
        int[] a2 = {1, 1, 2, 2, 3};
        int[] a3 = {2, 1, 3, 2, 1};
        
        assertArrayEquals(a2, ArraySortPastExerciseCourse.Sort(a3));
    }

    @Test
    public void testSortArrayEmpty() {
        int[] a2 = {};
        int[] a3 = {};
        
        assertArrayEquals(a2, ArraySortPastExerciseCourse.Sort(a3));
    }

    @Test
    public void testSortArrayNullValue() {
        int[] a2 = null;
        
        assertThrows(NullPointerException.class, () -> { ArraySortPastExerciseCourse.Sort(a2);
        });
    }
}
    
