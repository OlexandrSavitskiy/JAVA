import java.text.SimpleDateFormat;
import java.util.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MeteorologicFile {

    private static final String fileName = "Meteorologic.txt";
    public static final SimpleDateFormat DateFormatter = new SimpleDateFormat("dd.MM", Locale.ENGLISH);

    private static void WriteToFile(BufferedWriter bufferedWriter, Meteorologic meteor) throws IOException {
        bufferedWriter.write("Метеорологічне спостереження:" + "\n");
        bufferedWriter.write(DateFormatter.format(meteor.getDate())+ "\n");
        bufferedWriter.write(meteor.getTemperature() + "\n");
    }

    public static void WriteToFileList(ArrayList<Meteorologic> meteors, boolean append) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName,append))) {
            for (Meteorologic meteor: meteors)
            {
                WriteToFile(bufferedWriter, meteor);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void WriteToFile(Meteorologic meteor) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName,true))) {
            WriteToFile(bufferedWriter, meteor);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void RewriteFile(ArrayList<Meteorologic> meteors) {
        WriteToFileList(meteors, false);
    }

    public static void RemoveFromFile(int index) throws Exception {
        ArrayList<Meteorologic> meteors = ReadFromFile();

        meteors.remove(index);
        RewriteFile(meteors);
    }

    public static ArrayList<Meteorologic> ReadFromFile() throws Exception {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            ArrayList<Meteorologic> meteors = new ArrayList<>();

            String line = bufferedReader.readLine();

            while(line != null)
            {
                Meteorologic meteor = new Meteorologic();

                line = bufferedReader.readLine();
                meteor.setDate(DateFormatter.parse(line));

                line = bufferedReader.readLine();
                meteor.setTemperature(Integer.parseInt(line));

                meteors.add(meteor);

                line = bufferedReader.readLine();
            }
            return meteors;

        } catch (FileNotFoundException e) {
            throw new Exception("Файл не існує!");
        } catch (NumberFormatException e) {
            throw new Exception("Дані в файлі не є коректними!");
        }
        catch (IOException e) {
            throw new Exception("Помилка: " + e.getMessage());
        }
    }

    public static ArrayList<Meteorologic> Sort() throws Exception {
        ArrayList<Meteorologic> list;
        list = ReadFromFile();
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i).getTemperature() < list.get(i + 1).getTemperature()) {
                    Meteorologic temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    sorted = false;
                }
            }
        }

        return list;
    }
}

