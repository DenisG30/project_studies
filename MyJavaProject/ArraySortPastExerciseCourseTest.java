import org.junit.Test;
import static org.junit.Assert.*;
    
public class ArraySortPastExerciseCourseTest {        
    @Test
    public void testSortArray() {
        int[] a2 = {1, 2, 3, 4, 5};
        int[] a3 = {2, 5, 1, 3, 4};
        
        assertArrayEquals(a2, ArraySortPastExerciseCourse.Sort(a3));
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
    
