import java.util.*;

public class PhoneDirectory {
    private String surname;
	private String name;
    private String fathername;
    private String address;
    private String phone;

    public PhoneDirectory() {}
    public PhoneDirectory(String surname, String name, String fathername, String address, String phone)
    {
		this.surname = surname;
        this.name = name;
        this.fathername = fathername;
        this.address = address;
        this.phone = phone;
    }

    public String getSurname()
    {
        return surname;
    }

    public String getName()
    {
        return name;
    }

    public String getFathername()
    {
        return fathername;
    }

    public String getAddress()
    {
        return address;
    }

    public String getPhone()
    {
        return phone;
    }


    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setFathername(String fathername)
    {
        this.fathername = fathername;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }


    public void Input()
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Прізвище: ");
        surname = in.nextLine();
        System.out.print("Ім'я: ");
        name = in.nextLine();
        System.out.print("По батькові: ");
        fathername = in.nextLine();
        System.out.print("Адреса: ");
        address = in.nextLine();
        System.out.print("Номер телефону: ");
        phone = in.nextLine();

    }

    public void Print(int i)
    {
            System.out.format("%-4s | %-30s | %-30s | %-30s | %-30s | %-10s",
                    i, surname, name, fathername, address, phone);
            System.out.println();
    }

    public static void PrintArray(List<PhoneDirectory> arr)
    {
        System.out.println("————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————");
        System.out.printf("%-4s | %-30s | %-30s | %-30s | %-30s | %-10s", "№", "Прізвище", "Ім'я", "По батькові", "Адреса", "Телефон:");
        System.out.println();
        System.out.println("————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————");
        int i = 0;
        for(PhoneDirectory item: arr) {
            item.Print(i++);
        }
        System.out.println("————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————");
    }
}
