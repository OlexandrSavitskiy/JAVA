import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void Add() {
        Scanner in = new Scanner(System.in);

        System.out.println("Година:");
        Hour hour = new Hour();
        hour.Input();
        HourFile.WriteToFile(hour);
    }

    public static void Edit() {
        try {
            ArrayList<Hour> hours = HourFile.ReadFromFile();

            Scanner in = new Scanner(System.in);
            int n;
            do {
                System.out.print("Введіть номер для редагування: ");
                n = in.nextInt();

                if (n < 0 || n >= hours.size()) System.out.println("Дані введено неккоректно.");
            }
            while (n < 0 || n >= hours.size());

            System.out.println("Нові дані:");
            Hour hour = new Hour();
            hour.Input();
            hours.set(n, hour);

            HourFile.RewriteFile(hours);
            System.out.println("Змінено!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void Delete() {
        try {
            ArrayList<Hour> hours = HourFile.ReadFromFile();

            Scanner in = new Scanner(System.in);
            int n;
            do {
                System.out.print("Введіть номер для видалення: ");
                n = in.nextInt();

                if (n < 0 || n >= hours.size()) System.out.println("Дані введено неккоректно.");
            }
            while (n < 0 || n >= hours.size());

            HourFile.RemoveFromFile(n);
            System.out.println("Видалено!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void Print() {
        try {
            ArrayList<Hour> hours = HourFile.ReadFromFile();
            Hour.PrintArray(hours);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void CountPassengers() {
        try {
            ArrayList<Hour> hours = HourFile.ReadFromFile();
            if (hours.size() <= 0) throw new Exception("Файл пустий");

            System.out.println("Загальна кількість пасажирів: " + Hour.CountPassengers(hours));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void LowerPassengers() {
        try {
            ArrayList<Hour> hours = HourFile.ReadFromFile();
            if (hours.size() <= 0) throw new Exception("Файл пустий");

            Hour.LowerPassengers(hours).Output();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void LongerComment() {
        try {
            ArrayList<Hour> hours = HourFile.ReadFromFile();
            if (hours.size() <= 0) throw new Exception("Файл пустий");

            System.out.println("Найдовший коментар:");
            System.out.println(Hour.LongerComment(hours));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String sel;
        do {
            System.out.println("Практичні завдання. Операції:");
            System.out.println("1 — додати запис;");
            System.out.println("2 — редагувати запис;");
            System.out.println("3 — видалити запис;");
            System.out.println("4 — вивести інформацію на екран;");
            System.out.println("5 — загальна кількість пасажирів;");
            System.out.println("6 — година з найменшою кількістю пасажирів;");
            System.out.println("7 — найдовший коментар;");
            System.out.println("- — завершити");
            System.out.print("Операція: ");
            sel = in.next();
            System.out.println();

            switch (sel) {
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
                    CountPassengers();
                    break;
                case "6":
                    System.out.println("Година з найменшою кількістю пасажирів:");
                    LowerPassengers();
                    break;
                case "7":
                    LongerComment();
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
