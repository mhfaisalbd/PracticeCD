package pstu.cse.csit;

import java.util.Scanner;

public class RegularExpression {
    public static String regexFinder(String stream){
        int state = 0;
        for (int i = 0; i < stream.length(); i++){
            switch (state) {
                case 0 -> state = stream.charAt(i) == 'a' ? 1 : stream.charAt(i) == 'b' ? 2 : 99;
                case 1 -> state = stream.charAt(i) == 'b' ? 4 : 3;
                case 2, 5 -> state = stream.charAt(i) == 'b' ? 2 : 99;
                case 3 -> state = stream.charAt(i) == 'b' ? 2 : 3;
                case 4 -> state = stream.charAt(i) == 'b' ? 5 : 2;
            }
        }
        return switch (state) {
            case 1, 3 -> "a*";
            case 2, 4 -> "a*b+";
            case 5 -> "abb";
            default -> "Not Recognized";
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a stream: ");
        System.out.println(regexFinder(scanner.nextLine()));
    }
}
