package pstu.cse.csit;

import java.util.Scanner;
import java.util.Stack;

/**
 LL1

 G -> E$
 E -> TK
 K-> +TK | empty
 T -> FH
 H-> *FH | empty
 F -> (E)  | a





 =========================================
 a        +           *           (           )         $
 --------------------------------------------------------------------
 G| G->E$     |         |         | G->E$    |          |       |
 --------------------------------------------------------------------
 E| E->TK     |         |         |  E->TK  |          |       |
 --------------------------------------------------------------------
 K|           | K->+TK  |         |          | K->     | K->  |
 --------------------------------------------------------------------
 T|    T->FH  |         |         |  T->FH  |          |       |
 --------------------------------------------------------------------
 H|           |   H->   | H->*FH  |          |    H->  | H->  |
 --------------------------------------------------------------------
 F|    F->a   |         |         | F->(E)    |         |       |
 --------------------------------------------------------------------
 ===============================================================================
 */
public class LL1_Parser {
    //input
    public String input;//"i*i$"
    private int indexOfInput=-1;
    //Stack
    Stack <String> stack = new Stack<>();
    //Table of rules
    String [][] table=
            {
                    {"E$",null,null,"E$",null,null}
                    ,
                    {"TK",null,null,"TK",null,""}
                    ,
                    {null,"+TK",null,null,"",""}
                    ,
                    {"FH",null,null,"FH",null,null}
                    ,
                    {null,"","*FH",null,"",""}
                    ,
                    {"a",null,null,"(E)",null,null}


            };
    String [] nonTers={"G","E","K","T","H","F"};
    String [] terminals={"a","+","*","(",")","$"};


    public LL1_Parser(String in)
    {
        this.input=in;
    }

    private  void pushRule(String rule)
    {
        for(int i=rule.length()-1;i>=0;i--)
        {
            char ch=rule.charAt(i);
            String str=String.valueOf(ch);
            push(str);
        }
    }

    //algorithm
    public void algorithm    ()
    {


        push(this.input.charAt(0)+"");//
        push("G");
        //Read one token from input

        String token=read();

        do {
            String top = this.pop();
            //if top is non-terminal
            if (isNonTerminal(top)) {
                String rule = this.getRule(top, token);
                this.pushRule(rule);
            } else if (isTerminal(top)) {
                if (!top.equals(token)) {
                    error("this token is not corrent , By Grammer rule . Token : (" + token + ")");
                } else {
                    System.out.println("Matching: Terminal :( " + token + " )");
                    token = read();
//top=pop();

                }
            } else {
                error("Never Happens , Because top : ( " + top + " )");
            }
            //if top is terminal

        } while (!token.equals("$"));//out of the loop when $

        //accept
        System.out.println("Input is Accepted by LL1");
    }

    private boolean isTerminal(String s) {
        for (String terminal : this.terminals) {
            if (s.equals(terminal)) {
                return true;
            }

        }
        return false;
    }

    private boolean isNonTerminal(String s) {
        for (String nonTer : this.nonTers) {
            if (s.equals(nonTer)) {
                return true;
            }

        }
        return false;
    }

    private String read() {
        indexOfInput++;
        char ch=this.input.charAt(indexOfInput);

        return String.valueOf(ch);
    }

    private void push(String s) {
        this.stack.push(s);
    }
    private String pop() {
        return this.stack.pop();
    }

    private void error(String message) {
        System.out.println(message);
        throw new RuntimeException(message);
    }
    public String getRule(String non,String term)
    {

        int row=getnonTermIndex(non);
        int column=getTermIndex(term);
        String rule=this.table[row][column];
        if(rule==null)
        {
            error("There is no Rule by this , Non-Terminal("+non+") ,Terminal("+term+") ");
        }
        return rule;
    }

    private int getnonTermIndex(String non) {
        for(int i=0;i<this.nonTers.length;i++)
        {
            if(non.equals(this.nonTers[i]))
            {
                return i;
            }
        }
        error(non +" is not NonTerminal");
        return -1;
    }

    private int getTermIndex(String term) {
        for(int i=0;i<this.terminals.length;i++)
        {
            if(term.equals(this.terminals[i]))
            {
                return i;
            }
        }
        error(term +" is not Terminal");
        return -1;
    }


    public static void main(String[] args) {

        LL1_Parser parser=new LL1_Parser(/*"a+(a+a*(a)+a)$"*/ new Scanner(System.in).nextLine());//i*i+(i+i)$
        parser.algorithm();

    }

}