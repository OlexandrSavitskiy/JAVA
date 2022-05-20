import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String taskNum;
        do
        {
            System.out.println("Практична 1");
            System.out.println("Введіть номер завдання:");
            System.out.println("1 - Завдання 1");
            System.out.println("2 - Завдання 2");
            System.out.println("Enter - завершити");
            System.out.print("Завдання: ");
            taskNum = in.nextLine();
            System.out.println();

            switch (taskNum) {
                case "1":
                    System.out.println("Завдання 1:");
                    Task1.Task1();
                    break;
                case "2":
                    System.out.println("Завдання 2:");
                    Task2.Task2();
                    break;
                case "":
                    System.out.println("Завершення програми...");
                    break;
                default:
                    System.out.println("Даного завдання не існує!");
                    break;
            }
            System.out.println();
        } while (!taskNum.equals(""));
    }
}
