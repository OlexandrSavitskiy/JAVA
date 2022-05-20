import java.util.ArrayList;
import java.util.Scanner;

public class TramStop {
    protected String name;
    protected String routesNum;

    public String getName()
    {
        return name;
    }

    public String getRoutesNum()
    {
        return routesNum;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setRoutesNum(String routesNum)
    {
        this.routesNum = routesNum;
    }

    //virtual:
    public void Output() {};
    public void Input() {};

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

    //virtual:
    public int countPassengers(ArrayList<Hour> arr)
    {
        return 0;
    }

    public static int CountPassengers(ArrayList<Hour> arr)
    {
        return arr.get(0).countPassengers(arr);
    }

    public static Hour LowerPassengers(ArrayList<Hour> arr)
    {
        Hour lower = arr.get(0);

        for (Hour item: arr) {
            if(item.getPassengersCount() < lower.getPassengersCount())
                lower = item;
        }

        return lower;
    }

    public static String LongerComment(ArrayList<Hour> arr)
    {
        String longer = arr.get(0).getComment();
        for(Hour item: arr) {
            if(item.getComment().length() > longer.length())
                longer = item.getComment();
        }
        return longer;
    }

}
