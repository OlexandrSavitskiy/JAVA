import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
public class BookTest {

    @Test
    public void getCountFromList() {

        Book book =  new Book("Програмування мовою Java", "author1", "publishing", 2018);
        String actual = book.getName();
        String expected = "Програмування мовою Java";

        assertEquals(expected, actual);
    }
}