import org.junit.Test;
import static org.junit.Assert.*;

public class Task1Test {



    @Test
    public void SumNotPair() {
        int[] arr = new int[]{-4, 6, -5, -12};
        int actual = Task1.SumNotPairIndex(arr);
        int expected = -9;

        assertEquals(expected, actual);
    }

    @Test
    public void SumBetween() {
        int[] arr = new int[]{2, -6, 5, -12};
        try
        {
            int actual = Task1.SumBetween(arr, Task1.PosNIndex(arr, 1), Task1.PosNIndex(arr, 2));

            int expected = -6;

            assertEquals(expected, actual);
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}