import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ConcertTest {

    @Test
    public void AllVisitors() {

        Concert item1 = new Concert("", "", new Date(), 5);
        Concert item2 = new Concert("", "", new Date(), 4);
        Concert item3 = new Concert("", "", new Date(), 1);

        ArrayList<Concert> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);

        int actual = Concert.AllVisitors(list);
        int expected = 10;

        assertEquals(expected, actual);

    }

    @Test
    public void MaxVisitors() {
         Concert item1 = new Concert("", "", new Date(), 5);
         Concert item2 = new Concert("", "", new Date(), 4);
         Concert item3 = new Concert("", "", new Date(), 1);

         ArrayList<Concert> list = new ArrayList<>();
         list.add(item1);
         list.add(item2);
         list.add(item3);

         int actual = Concert.MaxVisitors(list).get(0).getCountVisitors();
         int expected = 5;

         assertEquals(expected, actual);
    }

    @Test
    public void WordsInGenre() {
        Concert item1 = new Concert("", "Слово слово", new Date(), 5);

        ArrayList<Concert> list = new ArrayList<>();
        list.add(item1);

        int actual = Concert.WordsInGenre(list, 0);
        int expected = 2;

        assertEquals(expected, actual);
    }
}