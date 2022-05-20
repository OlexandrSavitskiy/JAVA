import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {

    public static void Add()
    {
        System.out.println("Додати запис:");

        PhoneDirectory item = new PhoneDirectory();
        item.Input();
        PhoneDirectoryFile.WriteToFile(item);

    }

    public static void Edit()
    {
        try {
            ArrayList<PhoneDirectory> items = PhoneDirectoryFile.ReadFromFile();

            Scanner in = new Scanner(System.in);
            int n;
            do {
                System.out.print("Введіть номер редагування: ");
                n = in.nextInt();

                if(n < 0 || n >= items.size()) System.out.println("Дані введено неккоректно.");
            }
            while (n < 0 || n >= items.size());

            System.out.println("Запис:");
            PhoneDirectory item = new PhoneDirectory();
            item.Input();
            items.set(n, item);

            PhoneDirectoryFile.RewriteFile(items);
            System.out.println("Змінено!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void Delete()
    {
        try {
            ArrayList<PhoneDirectory> items = PhoneDirectoryFile.ReadFromFile();

            Scanner in = new Scanner(System.in);
            int n;
            do {
                System.out.print("Введіть номер для видалення: ");
                n = in.nextInt();

                if(n < 0 || n >= items.size()) System.out.println("Дані введено неккоректно.");
            }
            while (n < 0 || n >= items.size());

            PhoneDirectoryFile.RemoveFromFile(n);
            System.out.println("Видалено!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void Print()
    {
        try {
            List<PhoneDirectory> items = PhoneDirectoryFile.ReadFromFile();
            PhoneDirectory.PrintArray(items);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void Search()
    {
        Scanner in = new Scanner(System.in);
        String key;
        System.out.println("Введіть прізвище: ");
        key = in.nextLine();

        try {
            List<PhoneDirectory> items = PhoneDirectoryFile.Search(key);

            if(items.size() > 0)
            {
                PhoneDirectory.PrintArray(items);
            }
            else
            {
                System.out.println("Не знайдено!");
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void Sort()
    {
        try {
            List<PhoneDirectory> items = PhoneDirectoryFile.Sort();

            if(items.size() > 0)
            {
                PhoneDirectory.PrintArray(items);
            }
            else
            {
                System.out.println("Записів не знайдено!");
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void Start()
    {
        Scanner in = new Scanner(System.in);

        String sel;
        do
        {
            System.out.println("1 — додати;");
            System.out.println("2 — редагувати;");
            System.out.println("3 — видалити;");
            System.out.println("4 — вивести;");
            System.out.println("5 — пошук по прізвище;");
            System.out.println("6 — сортувати за номером;");
            System.out.println("- — завершити");
            System.out.print("Операція: ");
            sel = in.next();
            System.out.println();

            switch (sel)
            {
                case "1":
                    System.out.println("Додавання: ");
                    Add();
                    break;
                case "2":
                    System.out.println("Редагування: ");
                    Edit();
                    break;
                case "3":
                    System.out.println("Видалення: ");
                    Delete();
                    break;
                case "4":
                    System.out.println("Виведення:");
                    Print();
                    break;
                case "5":
                    System.out.println("Пошук:");
                    Search();
                    break;
                case "6":
                    System.out.println("Сортувати: ");
                    Sort();
                    break;
                case "-":
                    return;
                default:
                    System.out.println("Даного завдання не існує!");
                    break;
            }
            System.out.println();
        } while (true);
    }
}
