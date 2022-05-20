import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class MeteorologicTest {

    @Test
    public void PrintAvgTempMonth() {
        Meteorologic item1 = new Meteorologic(new Date(2022, 10, 11), 20, 200);
        Meteorologic item2 = new Meteorologic(new Date(2022, 10, 13), 10, 600);
        Meteorologic item3 = new Meteorologic(new Date(2022, 11, 11), 20, 400);

        ArrayList<Meteorologic> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);

        String actual = Meteorologic.PrintAvgTempMonth(list);
        String expected = "Листопад";

        assertEquals(expected, actual);
    }
}