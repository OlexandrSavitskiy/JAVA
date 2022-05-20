import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String sel;
        do
        {
            System.out.println("Лабораторна 5");
            System.out.println("Завдання:");
            System.out.println("1 — Завдання 1");
            System.out.println("2 — Завдання 2");
            System.out.println("3 — Завдання 3");
            System.out.println("- — завершити програму");
            System.out.print("Введіть номер завдання: ");
            sel = in.nextLine();
            System.out.println();

            switch (sel)
            {
                case "1":
                    System.out.println("Завдання №1:");
                    Task1.Start();
                    break;
                case "2":
                    System.out.println("Завдання №2:");
                    Task2.Start();
                    break;
                case "3":
                    System.out.println("Завдання №3:");
                    Task3.Start();
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
