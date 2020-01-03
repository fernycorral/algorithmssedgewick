package cap3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class BagsQueuesNStacks {

    public static void fixParenthesis1_3_9(char[] exp){
        Stack<String> expressionStack = new Stack<>();
        String tempVal = "";
        for(char c:exp) {
            if (c != ')') {
                expressionStack.push(Character.toString(c));
            }
            else{
                String fixedExpr = "";
                 while(expressionStack.size() >0){
                     if(expressionStack.peek().equals("(")){
                         fixedExpr = expressionStack.pop() + fixedExpr;
                         while(!expressionStack.peek().equals("(") && expressionStack.size() >0){
                             fixedExpr = expressionStack.pop() + fixedExpr;
                         }
                         fixedExpr = expressionStack.pop() + fixedExpr;

                     }else if(!expressionStack.peek().equals("*")){
                        fixedExpr = expressionStack.pop() + fixedExpr;
                     }else{
                         break;
                     }

                 }
                 expressionStack.push("(");
                 expressionStack.push(fixedExpr);
                 expressionStack.push(")");
            }

        }
        String res="";
        for(String w:expressionStack){
                res = w + res;
        }
        System.out.print("Fixed String: ");
        System.out.println(res);
    }

    public static String infixToPostfix(String expression) {
        Stack<String> stackString = new Stack<>();
        Stack<String> stackStringSymbol = new Stack<>();
        String[] arr = expression.split("");
        for (int i = 0; i < arr.length; i++) {
            String letter = arr[i];
            if (letter.equals("*") || letter.equals("/")) {
                if (stackStringSymbol.isEmpty()) {
                    stackStringSymbol.push(letter);
                } else {
                    if (stackStringSymbol.peek().equals("+") || stackStringSymbol.peek().equals("-")) {
                        stackStringSymbol.push(letter);
                    } else {
                        stackString.push(stackStringSymbol.pop());
                        stackStringSymbol.push(letter);
                    }
                }
            } else if (letter.equals("+") || letter.equals("-")) {
                if (stackStringSymbol.isEmpty()) {
                    stackStringSymbol.push(letter);
                } else {
                    if (stackStringSymbol.peek().equals("*") || stackStringSymbol.peek().equals("/")) {
                        stackString.push(stackStringSymbol.pop());
                        stackStringSymbol.push(letter);
                    } else {
                        stackStringSymbol.push(letter);
                    }
                }
            } else {
                stackString.push(letter);
                if (i == arr.length - 1) {
                    while (!stackStringSymbol.isEmpty()) {
                        stackString.push(stackStringSymbol.pop());
                    }
                }

            }
        }
        String answer = "";
        while (!stackString.isEmpty()) {
            answer = stackString.pop() + answer;
        }
        return answer;
    }

    public static long resolvePostFix(String postfix){
        Stack<Integer> resultStack = new Stack<>();
        for(String digit:postfix.split("")){
            switch(digit){
                case "+":
                    resultStack.push(resultStack.pop() + resultStack.pop());
                    break;
                case "-":
                    resultStack.push(resultStack.pop() - resultStack.pop());
                    break;
                case "*":
                    resultStack.push(resultStack.pop() * resultStack.pop());
                    break;
                case "/":
                    int divisor = resultStack.pop();
                    resultStack.push(resultStack.pop() / divisor);
                    break;
                default:
                    resultStack.push(Integer.parseInt(digit));
            }
        }
        short a = 1;
        return a;//resultStack.pop();
    }

    public static StackCopy copy(StackCopy stack){
        StackCopy copy = new StackCopy();
        Iterator iterator = stack.iterator();
        while(iterator.hasNext())
            copy.push(iterator.next());

        return copy;
    }

    public static void main(String[] args) {
       // StdOut.println("please write your expression that need to be fixed");
       // String expr = StdIn.readLine();
       // fixParenthesis1_3_9(expr.toCharArray());
        StackCopy<String> stack = new StackCopy<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack = copy(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
