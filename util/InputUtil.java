package util; 

import java.util.Scanner;

public class InputUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static int readInt() {
        int value = scanner.nextInt();
        scanner.nextLine(); 
        return value;
    }

    public static double readDouble() {
        double value = scanner.nextDouble();
        scanner.nextLine(); 
        return value;
    }

    public static String readLine() {
        return scanner.nextLine();
    }

    public static String readString() {
        String value = scanner.next();
        scanner.nextLine(); 
        return value;
    }

    public static char readChar() {
        String input = scanner.nextLine();
        if (input.length() > 0) {
            return input.charAt(0);
        }
        return ' '; 
    }
}