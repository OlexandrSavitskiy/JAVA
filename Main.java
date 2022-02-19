package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean exit=false;
        int menu, x , y,z;
        while (!exit){
            System.out.print("Введіть номер завдання(1 - 4): ");
            menu = in.nextInt();
            switch (menu) {
                case 1:

                    System.out.print("Введіть значення x: ");
                    float c = in.nextFloat();
                    Ex1(c);
                    break;
                case 2:
                    System.out.print("Введіть значення x , y та z : ");
                    x = in.nextInt();
                    y = in.nextInt();
                    z = in.nextInt();
                    Ex2(x, y, z);
                    break;
                case 3:
                    System.out.print("Введіть число: ");
                    int n = in.nextInt();
                    Ex3(n);
                    break;
                case 4:
                    System.out.print("Введіть значення x та z: ");
                    x = in.nextInt(); y = in.nextInt();
                    Ex4(x,y);
                    break;
                case 0:
                    exit = true;
                    break;
                default: System.out.println("Введене число надто велике!");
            }
        }
    }
    static void Ex1(float c){


            if (c <-10)
                System.out.println("Значення функції f=" + (3*(Math.pow(c, 3))-(Math.pow(c,2))));
            if (c >= -10 && c<=10)
                System.out.println("Значення функції f=" + (Math.sqrt(10 - c)));
            if (c>10)
                System.out.println("Значення функції f=" + (2*c+1));
    }
    static void Ex2(int x, int y, int z){
        if (x>y && x >z)System.out.println("Найбільше число :" + x);
            if (y>x && y>z)System.out.println("Найбільше число :" + y);
                if (z>x && z>y)System.out.println("Найбільше число :" + z);

    }
    static void Ex3(int n) {
        switch (n){
            case 1:System.out.println("Атвіновський");break;
            case 2:System.out.println("Балан");break;
            case 3:System.out.println("Безушко");break;
            case 4:System.out.println("Гловацький");break;
            case 5:System.out.println("Демко");break;
            case 6:System.out.println("Дзюба");break;
            case 7:System.out.println("Дмитрійчук");break;
            case 8:System.out.println("Довгаль");break;
            case 9:System.out.println("Євинчук");break;
            case 10:System.out.println("Єримій");break;
            default: System.out.println("Помилка введення");break;

        }
    }

    static void Ex4(int x, int y){
        double a1 ;
        try{

            a1 = (1-2*x);
            if (a1 == 0 || x<=0){
                throw new ArithmeticException("Problems?");
            }
            else
            {
                System.out.println (Math.sqrt((Math.log10(1-2*x))/(Math.log10(y+3))));
            }
        }
        catch (ArithmeticException e)
        {
            System.out.println("Помилка введення");
        }

    }

}