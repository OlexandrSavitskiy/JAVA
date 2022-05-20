import java.util.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PhoneDirectoryFile {
	private static final String fileName = "C:\\Users\\Lenovo\\Desktop\\ЛР6\\lab6\\PhoneDirectory.txt";

	private static void WriteToFile(BufferedWriter bufferedWriter, PhoneDirectory item) throws Exception{
		bufferedWriter.write("Контакт:" + "\n");
		bufferedWriter.write(item.getSurname() + "\n");
		bufferedWriter.write(item.getName() + "\n");
		bufferedWriter.write(item.getFathername() + "\n");
		bufferedWriter.write(item.getAddress() + "\n");
		bufferedWriter.write(item.getPhone() + "\n");
	}

	public static void WriteToFile(PhoneDirectory item) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName,true))) {
            WriteToFile(bufferedWriter, item);
        }
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }

	public static void RewriteFile(ArrayList<PhoneDirectory> arr) {
		try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
			for (PhoneDirectory item: arr)
			{
				WriteToFile(bufferedWriter, item);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void RemoveFromFile(int index) throws Exception {
		ArrayList<PhoneDirectory> libraries = ReadFromFile();

		libraries.remove(index);

		RewriteFile(libraries);
	}
	
	public static ArrayList<PhoneDirectory> ReadFromFile() throws Exception {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
			ArrayList<PhoneDirectory> libraries;
			libraries = new ArrayList<>();

			String line = bufferedReader.readLine();

			while(line != null)
			{
				PhoneDirectory item = new PhoneDirectory();
				line = bufferedReader.readLine();
				item.setSurname(line);

				line = bufferedReader.readLine();
				item.setName(line);

				line = bufferedReader.readLine();
				item.setFathername(line);

				line = bufferedReader.readLine();
				item.setAddress(line);

				line = bufferedReader.readLine();
				item.setPhone(line);

				libraries.add(item);

				line = bufferedReader.readLine();
			}
			return libraries;
			
        } catch (FileNotFoundException e) {
            throw new Exception("Файл не існує!");
        } catch (IOException e) {
            throw new Exception("Помилка: " + e.getMessage());
        }
    }
	
	public static ArrayList<PhoneDirectory> Sort() throws Exception {
		ArrayList<PhoneDirectory> list;

		list = ReadFromFile();
		boolean sorted = false;

		while (!sorted) {
			sorted = true;
			for (int i = 0; i < list.size()-1; i++) {
				if (list.get(i).getPhone().compareTo(list.get(i + 1).getPhone()) > 0) {
					PhoneDirectory temp = list.get(i);
					list.set(i, list.get(i + 1));
					list.set(i + 1, temp);
					sorted = false;
				}
			}
		}

		return list;

	}
	
	public static ArrayList<PhoneDirectory> Search(String author) throws Exception {
		ArrayList<PhoneDirectory> read = ReadFromFile();
		ArrayList<PhoneDirectory> libraries = new ArrayList<>();

		for(PhoneDirectory item: read) {
			if(item.getSurname().contains(author))
			{
				libraries.add(item);
			}
		}
		return libraries;
	}
}
