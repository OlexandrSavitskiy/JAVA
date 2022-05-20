import java.text.SimpleDateFormat;
import java.util.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ConcertFile {

    private static final String fileName = "Concert.txt";
    public static final SimpleDateFormat DateFormatter = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);



    private static void WriteToFile(BufferedWriter bufferedWriter, Concert concert) throws IOException {
        bufferedWriter.write("Концерт:" + "\n");
        bufferedWriter.write(concert.getName() + "\n");
        bufferedWriter.write(concert.getGenre() + "\n");
        bufferedWriter.write(DateFormatter.format(concert.getDate()) + "\n");
        bufferedWriter.write(concert.getCountVisitors() + "\n");
    }

    public static void WriteToFileList(ArrayList<Concert> concerts, boolean append) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName,append))) {
            for (Concert concert: concerts)
            {
                WriteToFile(bufferedWriter, concert);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void WriteToFile(Concert concert) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName,true))) {
            WriteToFile(bufferedWriter, concert);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void RewriteFile(ArrayList<Concert> concerts) {
        WriteToFileList(concerts, false);
    }

    public static void RemoveFromFile(int index) throws Exception {
        ArrayList<Concert> concerts = ReadFromFile();

        concerts.remove(index);
        RewriteFile(concerts);
    }

    public static ArrayList<Concert> ReadFromFile() throws Exception {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            ArrayList<Concert> concerts = new ArrayList<>();

            String line = bufferedReader.readLine();

            while(line != null)
            {
                Concert concert = new Concert();

                line = bufferedReader.readLine();
                concert.setName(line);

                line = bufferedReader.readLine();
                concert.setGenre(line);

                line = bufferedReader.readLine();
                concert.setDate(DateFormatter.parse(line));

                line = bufferedReader.readLine();
                concert.setCountVisitors(Integer.parseInt(line));

                concerts.add(concert);

                line = bufferedReader.readLine();
            }
            return concerts;

        } catch (FileNotFoundException e) {
            throw new Exception("Файл не існує!");
        } catch (NumberFormatException e) {
            throw new Exception("Дані введено некоректно!");
        }
        catch (IOException e) {
            throw new Exception("Помилка: " + e.getMessage());
        }
    }
}

