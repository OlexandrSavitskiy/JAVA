import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {

    private static void Add()
    {
        System.out.println("Концерт");
        Concert concert = new Concert();
        concert.Input();
        ConcertFile.WriteToFile(concert);
    }

    private static void Edit()
    {
        try {
            ArrayList<Concert> concerts = ConcertFile.ReadFromFile();

            Scanner in = new Scanner(System.in);
            int n;
            do {
                System.out.print("Введіть номер для редагування: ");
                n = in.nextInt();

                if(n < 0 || n >= concerts.size()) System.out.println("Номер введено неккоректно.");
            }
            while (n < 0 || n >= concerts.size());

            System.out.println("Нові дані:");
            Concert concert = new Concert();
            concert.Input();
            concerts.set(n, concert);

            ConcertFile.RewriteFile(concerts);
            System.out.println("Змінено!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void Delete()
    {
        try {
            ArrayList<Concert> concerts = ConcertFile.ReadFromFile();

            Scanner in = new Scanner(System.in);
            int n;
            do {
                System.out.print("Введіть номер для видалення: ");
                n = in.nextInt();

                if(n < 0 || n >= concerts.size()) System.out.println("Номер введено неккоректно.");
            }
            while (n < 0 || n >= concerts.size());

            ConcertFile.RemoveFromFile(n);
            System.out.println("Видалено!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void Print()
    {
        try {
            ArrayList<Concert> concerts = ConcertFile.ReadFromFile();
            Concert.PrintArray(concerts);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void AllVisitors()
    {
        try {
            ArrayList<Concert> concerts = ConcertFile.ReadFromFile();
            System.out.println(Concert.AllVisitors(concerts));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void MaxVisitors()
    {
        try {
            ArrayList<Concert> search = Concert.MaxVisitors(ConcertFile.ReadFromFile());

            if(search.size() > 0)
            {
                Concert.PrintArray(search);
            }
            else
            {
                System.out.println("Файл пустий!");
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void WordsInGenre()
    {
        try
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Номер концерту: ");
            int key = Integer.parseInt(in.nextLine());

            ArrayList<Concert> concerts = ConcertFile.ReadFromFile();

            System.out.println("Жанр: " + concerts.get(key).genre);
            System.out.println("Кількість слів: " + Concert.WordsInGenre(concerts, key));
        }
        catch (NumberFormatException e)
        {
            System.out.println("Дані введено некореткно!");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void Start()
    {
        Scanner in = new Scanner(System.in);

        String sel;
        do
        {
            System.out.println("Концерти:");
            System.out.println("1 — додати;");
            System.out.println("2 — редагувати;");
            System.out.println("3 — видалити;");
            System.out.println("4 — вивести;");
            System.out.println("5 — загальна кількість глядачів;");
            System.out.println("6 — концерт з максимальною кількістю глядачів;");
            System.out.println("7 — кількість слів у назві жанру;");
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
                    System.out.println("Загальна кількість глядачів: ");
                    AllVisitors();
                    break;
                case "6":
                    System.out.println("Концерт з максимальною кількістю глядачів: ");
                    MaxVisitors();
                    break;
                case "7":
                    System.out.println("Кількість слів у назві жанру: ");
                    WordsInGenre();
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