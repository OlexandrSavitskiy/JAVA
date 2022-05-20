import java.text.SimpleDateFormat;
import java.util.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HourFile {
    private static final String fileName = "Hour.txt";
    public static final SimpleDateFormat DateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

    private static void WriteToFile(BufferedWriter bufferedWriter, Hour Hour) throws IOException {
        bufferedWriter.write("Година:" + "\n");
        bufferedWriter.write(Hour.getName() + "\n");
        bufferedWriter.write(Hour.getRoutesNum() + "\n");
        bufferedWriter.write(Hour.getPassengersCount() + "\n");
        bufferedWriter.write(Hour.getComment() + "\n");
    }

    public static void WriteToFileList(ArrayList<Hour> Hours, boolean append) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName,append))) {
            for (Hour Hour: Hours)
            {
                WriteToFile(bufferedWriter, Hour);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void WriteToFile(Hour Hour) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true))) {
            WriteToFile(bufferedWriter, Hour);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void RewriteFile(ArrayList<Hour> hours) {
        WriteToFileList(hours, false);
    }

    public static void RemoveFromFile(int index) throws Exception {
        ArrayList<Hour> hours = ReadFromFile();

        hours.remove(index);
        RewriteFile(hours);
    }

    public static ArrayList<Hour> ReadFromFile() throws Exception {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            ArrayList<Hour> hours = new ArrayList<>();

            String line = bufferedReader.readLine();

            while(line != null)
            {
                Hour Hour = new Hour();

                line = bufferedReader.readLine();
                Hour.setName(line);

                line = bufferedReader.readLine();
                Hour.setRoutesNum(line);

                line = bufferedReader.readLine();
                Hour.setPassengersCount(Integer.parseInt(line));

                line = bufferedReader.readLine();
                Hour.setComment(line);

                hours.add(Hour);

                line = bufferedReader.readLine();
            }
            return hours;

        } catch (FileNotFoundException e) {
            throw new Exception("Файл не існує!");
        } catch (IOException e) {
            throw new Exception("Помилка: " + e.getMessage());
        }
    }

    public static ArrayList<Hour> Sort() throws Exception {
        ArrayList<Hour> list;
        list = ReadFromFile();
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i).getPassengersCount() < list.get(i + 1).getPassengersCount()) {
                    Hour temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    sorted = false;
                }
            }
        }

        return list;
    }

    public static ArrayList<Hour> Search(String key) throws Exception {
        ArrayList<Hour> read = ReadFromFile();
        ArrayList<Hour> hours = new ArrayList<>();

        for(Hour item: read) {
            if(item.getName().contains(key))
            {
                hours.add(item);
            }
        }
        return hours;
    }
}
