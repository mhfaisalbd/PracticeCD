package pstu.cse.csit;

import java.util.Arrays;
import java.util.Scanner;

public class ValidateIdentifier {
    static final String[] keywords = { "abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "extends", "false",
            "final", "finally", "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "interface", "long", "native",
            "new", "null", "package", "private", "protected", "public",
            "return", "short", "static", "strictfp", "super", "switch",
            "synchronized", "this", "throw", "throws", "transient", "true",
            "try", "void", "volatile", "while" };

    public static boolean isJavaKeyword(String keyword) {
        return (Arrays.binarySearch(keywords, keyword) >= 0);
    }

    public static boolean isIdentifier(String stream){
        if (isJavaKeyword(stream))
            return false;
        char firstChar = stream.charAt(0);
        boolean isComparable = firstChar == '_' ||
                (firstChar >= 'A' && firstChar <= 'Z') ||
                (firstChar >= 'a' && firstChar <= 'z');
        if (!isComparable) {
            return false;
        } else {

            for (int i=1; i< stream.length(); i++){
                char ch = stream.charAt(i);
                boolean isValid = ch == '_' ||
                        //ch == '$' ||
                        (ch >= 'A' && ch <= 'Z') ||
                        (ch >= 'a' && ch <= 'z') ||
                        (ch >= '0' && ch <= '9') ;
                if (!isValid) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an identifier: ");
        System.out.println(isIdentifier(scanner.nextLine())? "Valid Identifier": "Invalid Identifier");
    }
}
