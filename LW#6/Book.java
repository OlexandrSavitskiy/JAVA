import java.util.*;

public class Book {
    private String name;
    private String author;
    private String publishing;
    private int year;

    public String getName() {return name;}
    public String getAuthor() {return author;}
    public String getPublishing() {return publishing;}
    public int getYear() {return year;}

    public Book() {}
    public Book(String name, String author, String publishing, int year)
    {
        this.name = name;
        this.author = author;
        this.publishing = publishing;
        this.year = year;
    }

    public void Input()
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Назва книги: ");
        name = in.nextLine();
        System.out.print("Автор: ");
        author = in.nextLine();
        System.out.print("Видавництво: ");
        publishing = in.nextLine();

        boolean Error = true;
        do {
            try {
                System.out.print("Рік: ");
                year = Integer.parseInt(in.nextLine());
                if(year < 1000) throw new Exception("Введіть рік корректно!");

                Error = false;
            }
            catch (NumberFormatException e) {
                System.out.println("Помилка при введені. Невірний тип. Спробуйте ще раз!");
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        } while (Error);
    }

    public void Print()
    {
            System.out.format("%-30s | %-30s | %-18s | %-5d",
                    name, author, publishing, year);
            System.out.println();
    }

    public static void TaskPrint(Book[] arr)
    {
        System.out.printf("%-30s | %-30s | %-18s | %-5s", "Назва", "Автор", "Видавництво", "Рік");
        System.out.println();
        System.out.println("———————————————————————————————————————————————————————————————————————————————————————————————————————————————");
        for(Book item: arr) {
            if(item.name.toLowerCase(Locale.ROOT).contains("програмування"))
                item.Print();
        }
        System.out.println("———————————————————————————————————————————————————————————————————————————————————————————————————————————————");
    }



}
