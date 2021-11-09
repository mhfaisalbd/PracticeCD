package pstu.cse.csit;

import java.util.Scanner;

public class CommentCheck {
    public static boolean isComment(String stream){
        if(stream.charAt(0) == '/'){
            return (stream.charAt(1) == '/' || (stream.charAt(1) == '*' && stream.substring(2).contains("*/") ));
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a statement: ");
        System.out.println(isComment(scanner.nextLine()) ? "It is a comment": "It is not a comment");

    }
}
