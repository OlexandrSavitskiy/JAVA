import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {

    private static void Add()
    {
        System.out.println("Спостереження:");
        Meteorologic meteor = new Meteorologic();
        meteor.Input();
        MeteorologicFile.WriteToFile(meteor);
    }

    private static void Edit()
    {
        try {
            ArrayList<Meteorologic> meteors = MeteorologicFile.ReadFromFile();

            Scanner in = new Scanner(System.in);
            int n;
            do {
                System.out.print("Введіть номер для редагування: ");
                n = in.nextInt();

                if(n < 0 || n >= meteors.size()) System.out.println("Номер введено неккоректно.");
            }
            while (n < 0 || n >= meteors.size());

            System.out.println("Нові дані:");
            Meteorologic meteor = new Meteorologic();
            meteor.Input();
            meteors.set(n, meteor);

            MeteorologicFile.RewriteFile(meteors);
            System.out.println("Змінено!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void Delete()
    {
        try {
            ArrayList<Meteorologic> meteors = MeteorologicFile.ReadFromFile();

            Scanner in = new Scanner(System.in);
            int n;
            do {
                System.out.print("Введіть номер для видалення: ");
                n = in.nextInt();

                if(n < 0 || n >= meteors.size()) System.out.println("Номер введено неккоректно.");
            }
            while (n < 0 || n >= meteors.size());

            MeteorologicFile.RemoveFromFile(n);
            System.out.println("Видалено!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void Print()
    {
        try {
            ArrayList<Meteorologic> meteors = MeteorologicFile.ReadFromFile();
            Meteorologic.PrintArray(meteors);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void Sort()
    {
        try {
            ArrayList<Meteorologic> meteors = MeteorologicFile.Sort();

            if(meteors.size() > 0)
            {
                Meteorologic.PrintArray(meteors);
            }
            else
            {
                System.out.println("Файл пустий!");
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void Task()
    {
        try {
            ArrayList<Meteorologic> meteors = MeteorologicFile.ReadFromFile();
            Meteorologic.PrintAvgTempMonth(meteors);
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
            System.out.println("Метеорологічні спостереження. Операції:");
            System.out.println("1 — додати;");
            System.out.println("2 — редагувати;");
            System.out.println("3 — видалити;");
            System.out.println("4 — вивести;");
            System.out.println("5 — сортувати;");
            System.out.println("6 — середня температура кожного місяця, місяць з найбільшою середньою температурою;");
            System.out.println("- — завершити");
            System.out.print("Операція: ");
            sel = in.nextLine();
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
                    System.out.println("Сортувати: ");
                    Sort();
                    break;
                case "6":
                    System.out.println("Середня температура кожного місяця, місяць з найбільшою середньою температурою: ");
                    Task();
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
