import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Hour extends TramStop {
    private int passengersCount;
    private String comment;

    public Hour(){}
    public Hour(String name, String routesNum, int passengersCount, String comment)
    {
        this.name = name;
        this.routesNum = routesNum;
        this.passengersCount = passengersCount;
        this.comment = comment;
    }

    public int getPassengersCount()
    {
        return passengersCount;
    }

    public String getComment()
    {
        return comment;
    }

    public void setPassengersCount(int passengersCount)
    {
        this.passengersCount = passengersCount;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    @Override
    public void Output()
    {
        System.out.format("%-30s | %-30s | %-20d | %-60s",
                name, routesNum, passengersCount, comment);
        System.out.println();
    }

    public static void PrintArray(ArrayList<Hour> arr)
    {
        System.out.println("———————————————————————————————————————————————————————————————————————————————————————————————————————————————");
        System.out.printf("%-30s | %-30s | %-20s | %-60s", "Назва", "Номери маршрутів", "Дата", "Коментар");
        System.out.println();
        System.out.println("———————————————————————————————————————————————————————————————————————————————————————————————————————————————");
        for(Hour item: arr) {
            item.Output();
        }
        System.out.println("———————————————————————————————————————————————————————————————————————————————————————————————————————————————");
    }

    @Override
    public void Input() {
        Scanner in = new Scanner(System.in);

        System.out.print("Назва: ");
        name = in.nextLine();

        System.out.print("Номери маршрутів: ");
        routesNum = in.nextLine();

        boolean Error = true;
        do {
            try {
                System.out.print("Кількість пасажирів: ");
                passengersCount = Integer.parseInt(in.nextLine());
                if(passengersCount <= 1) throw new Exception("Кількість повинна бути більша за 1");

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

        System.out.print("Коментар: ");
        comment = in.nextLine();
    }

    @Override
    public int countPassengers(ArrayList<Hour> arr)
    {
        int count = 0;
        for(Hour item: arr) {
            count+=item.getPassengersCount();
        }
        return count;
    }



}
