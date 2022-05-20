import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Concert extends Performer{
    private Date date;
    private int countVisitors;

    public Date getDate() {
        return date;
    }

    public int getCountVisitors() {
        return countVisitors;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCountVisitors(int countVisitors) {
        this.countVisitors = countVisitors;
    }

    public Concert(){}
    public Concert(String name, String genre, Date date, int countVisitors)
    {
        this.name = name;
        this.genre = genre;
        this.date = date;
        this.countVisitors = countVisitors;
    }

    @Override
    public void Input() {
        Scanner in = new Scanner(System.in);

        System.out.print("Ім'я: ");
        name = in.nextLine();

        System.out.print("Жанр: ");
        genre = in.nextLine();

        boolean Error = true;
        do {
            try {
                System.out.print("Дата: ");
                String input = in.nextLine();
                date = ConcertFile.DateFormatter.parse(input);

                Error = false;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        } while (Error);

        Error = true;
        do {
            try {
                System.out.print("Кількість глядачів: ");
                countVisitors = Integer.parseInt(in.nextLine());
                if(countVisitors < 1 ) throw new Exception("Дані введенно некоректно.");

                Error = false;
            }
            catch (NumberFormatException e) {
                System.out.println("Введіть число!");
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        } while (Error);
    }

    @Override
    public void Print(int i)
    {
        System.out.format("%-4d | %-15s | %-15s | %-15s | %-20d",
                i, name, genre, ConcertFile.DateFormatter.format(date), countVisitors);
        System.out.println();
    }

    public static void PrintArray(ArrayList<Concert> arr)
    {
        System.out.println("———————————————————————————————————————————————————————————————————————————————————————————————————————————————");
        System.out.printf("%-4s | %-15s | %-15s | %-15s | %-20s", "№", "Ім'я виконавця", "Жанр", "Дата", "Кількість глядачів");
        System.out.println();
        System.out.println("———————————————————————————————————————————————————————————————————————————————————————————————————————————————");
        int i = 0;
        for(Concert item: arr) {
            item.Print(i++);
        }
        System.out.println("———————————————————————————————————————————————————————————————————————————————————————————————————————————————");
    }

    public static int AllVisitors(ArrayList<Concert> arr)
    {
        int count = 0;

        for(Concert item: arr) {
            count+=item.countVisitors;
        }

        return count;
    }

    public static ArrayList<Concert> MaxVisitors(ArrayList<Concert> arr)
    {
        int max = arr.get(0).countVisitors;

        for(Concert kiosk: arr)
        {
            if(max < kiosk.countVisitors)
                max = kiosk.countVisitors;
        }

        ArrayList<Concert> newArr = new ArrayList<>();

        for(Concert kiosk: arr)
        {
            if(kiosk.countVisitors == max)
                newArr.add(kiosk);
        }

        return newArr;
    }

    public static int WordsInGenre(ArrayList<Concert> concerts, int i)
    {
        try {
            if(i < 0 || i >= concerts.size())
            {
                System.out.println("Не знайдено!");
            }
            else
            {
                String[] words = concerts.get(i).genre.split(" ");
                return words.length;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return 0;
    }
}
