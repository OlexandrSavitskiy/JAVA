import org.junit.Test;
import static org.junit.Assert.*;

public class Task2Test {

    @Test
    public void SumBtwMinMax() {
        int[] arr = new int[]{2, 3, 10};

        try
        {
            int actual = Task2.SumBtwMinMax(arr);
            int expected = 12;

            assertEquals(expected, actual);

        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}