import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void OutputMatrix(float[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%.2f\t", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void RandomMatrix(float[][] matrix) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (random.nextInt(200) -100) + random.nextFloat();
            }
        }
    }

    public static float MinBottomElement(float[][] matrix) {
        float min = matrix[0][0];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                if(matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
        }
`
        return min;
    }


    public static void Task2() {
        Scanner in = new Scanner(System.in);
        int n;

        do {
            System.out.print("Введіть розмір матриці:");
            n = in.nextInt();
            if(n < 1) System.out.println("Розмір матриці не може бути меньше 1!");
        }
        while (n < 1);

        float[][] matrix = new float[n][n];

        System.out.println("Матриця:");
        RandomMatrix(matrix);
        OutputMatrix(matrix);

        System.out.printf("Мiнiмальний елемент серед елементiв, якi знаходяться нижче головної дiагоналi квадрату: %.2f", MinBottomElement(matrix));
    }
}
