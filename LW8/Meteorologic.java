import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Meteorologic implements PrintableAndInputable {

    private Date date;
    private int temperature;

    public Meteorologic(){}
    public Meteorologic(Date date, int temperature, double pressure)
    {
        this.date = date;
        this.temperature = temperature;
    }

    public Date getDate()
    {
        return date;
    }
    public int getTemperature()
    {
        return temperature;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }
    public void setTemperature(int temperature)
    {
        this.temperature = temperature;
    }

    @Override
    public void Print(int i)
    {
        System.out.format("%-4d | %-20s | %-30d",
                i, MeteorologicFile.DateFormatter.format(date), temperature);
        System.out.println();
    }

    @Override
    public void Input() {
        Scanner in = new Scanner(System.in);

        boolean Error = true;
        do {
            try {
                System.out.print("Дата: ");
                String input = in.nextLine();
                date = MeteorologicFile.DateFormatter.parse(input);

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
                System.out.print("Температура: ");
                temperature = Integer.parseInt(in.nextLine());
                if(temperature < -80 || temperature > 80) throw new Exception("Дані введенно некоректно.");

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


    public static void PrintArray(ArrayList<Meteorologic> arr)
    {
        System.out.printf("%-4s | %-20s | %-30s", "№", "Дата", "Температура повітря");
        System.out.println();
        System.out.println("———————————————————————————————————————————————————————————————————————————————————————————————————————————————");
        int i = 0;
        for(Meteorologic item: arr) {
            item.Print(i++);
        }
        System.out.println("———————————————————————————————————————————————————————————————————————————————————————————————————————————————");
    }

    public static String PrintAvgTempMonth(ArrayList<Meteorologic> arr)
    {
        String[] MonthNames = {
                "Січень",
                "Лютий",
                "Березень",
                "Квітень",
                "Травень",
                "Червень",
                "Липень",
                "Серпень",
                "Вересень",
                "Жовтень",
                "Листопад",
                "Грудень"
        };

        int greater = -1;
        float greater_temp = 0;

        for (int i = 0; i < 12; i++)
        {
            int count = 0;
            float sum = 0;

            for(Meteorologic item: arr) {
                if(item.date.getMonth() -1 == i)
                {
                    count++;
                    sum+= item.temperature;
                }
            }

            if(count > 0)
            {
                float avg_temp = sum/count;
                System.out.printf("Середня температура місяця \"%s\": %.2f\n", MonthNames[i], avg_temp);

                if(greater_temp < avg_temp || greater == -1)
                {
                    greater = i;
                    greater_temp = avg_temp;
                }
            }
        }

        if (greater > -1)
        {
            System.out.printf("Найбільша середня температура місяця \"%s\" (%.2f)\n", MonthNames[greater], greater_temp);
            return MonthNames[greater];
        }
        else return "";
    }
}
