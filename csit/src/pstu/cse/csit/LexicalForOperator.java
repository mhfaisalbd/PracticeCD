package pstu.cse.csit;

import java.util.Scanner;

public class LexicalForOperator {

    public static String lexicalForOperator(String stream){
        char firstChar = stream.charAt(0);
        switch (firstChar){
            case'>': if(stream.charAt(1)=='=')
                return ("\n Greater than or equal");
            else
                return ("\n Greater than");

            case'<': if(stream.charAt(1)=='=')
                return ("\n Less than or equal");
            else
                return ("\nLess than");

            case'=': if(stream.charAt(1)=='=')
                return ("\nEqual to");
            else
                return ("\nAssignment");

            case'!': if(stream.charAt(1)=='=')
                return ("\nNot Equal");
            else
                return ("\n Bit Not");

            case'&': if(stream.charAt(1)=='&')
                return ("\nLogical AND");
            else
                return ("\n Bitwise AND");

            case'|': if(stream.charAt(1)=='|')
                return ("\nLogical OR");
            else
                return ("\nBitwise OR");

            case'+': return ("\n Addition");

            case'-': return ("\nSubstraction");

            case'*': return ("\nMultiplication");

            case'/': return ("\nDivision");

            case'%': return ("Modulus");

            default: return ("\n Not a operator");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an operator: ");
        System.out.println(lexicalForOperator(scanner.nextLine()));
    }
}
