import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class PracticalTest {

    @Test
    public void CountPassengers() {
        Hour practical1 = new Hour("", "", 3, "");
        Hour practical2 = new Hour("", "", 5, "");
        Hour practical3 = new Hour("", "", 7, "");

        ArrayList<Hour> list = new ArrayList<>();
        list.add(practical1);
        list.add(practical2);
        list.add(practical3);

        int actual = Hour.CountPassengers(list);
        int expected = 15;

        assertEquals(expected, actual);
    }

    @Test
    public void LowerPassengers() {
        Hour practical1 = new Hour("", "", 3, "");
        Hour practical2 = new Hour("", "", 5, "");
        Hour practical3 = new Hour("", "", 7, "");

        ArrayList<Hour> list = new ArrayList<>();
        list.add(practical1);
        list.add(practical2);
        list.add(practical3);
        int actual = Hour.LowerPassengers(list).getPassengersCount();
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void LongerComment() {
        Hour practical1 = new Hour("", "", 3, "Test");
        Hour practical2 = new Hour("", "", 5, "Teeeeest");
        Hour practical3 = new Hour("", "", 7, "Tst");

        ArrayList<Hour> list = new ArrayList<>();
        list.add(practical1);
        list.add(practical2);
        list.add(practical3);

        String actual = Hour.LongerComment(list);
        String expected = "Teeeeest";

        assertEquals(expected, actual);
    }
}