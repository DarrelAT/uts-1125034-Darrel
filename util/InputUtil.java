package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readLine() {
        return scanner.nextLine();
    }

    public static int readInt() {
        while (true) {
            try {
                int val = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                return val;
            } catch (InputMismatchException e) {
                System.out.print("Input harus berupa angka bulat! Masukkan ulang: ");
                scanner.nextLine(); // Clear invalid token
            }
        }
    }

    public static double readDouble() {
        while (true) {
            try {
                double val = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                return val;
            } catch (InputMismatchException e) {
                System.out.print("Input harus berupa angka desimal! Masukkan ulang: ");
                scanner.nextLine(); // Clear invalid token
            }
        }
    }
}