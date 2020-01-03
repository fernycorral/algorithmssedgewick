package cap3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Parentheses {

    public static boolean isBalanced(){
        StdOut.println("write your string please to evaluate parentheses");
        String parenthesesString = StdIn.readLine();
        FixedCapacityStackOfStrings fixedCapacityStackOfStrings = new FixedCapacityStackOfStrings(100);
        for(char s: parenthesesString.toCharArray()){

            switch (s){
                case ')':

                    if(!fixedCapacityStackOfStrings.pop().equals("("))
                        return false;
                    break;
                case ']':

                    if(!fixedCapacityStackOfStrings.pop().equals("["))
                        return false;
                    break;
                case '}':

                    if(!fixedCapacityStackOfStrings.pop().equals("{"))
                        return false;
                    break;
                    default:
                        fixedCapacityStackOfStrings.push(Character.toString(s));
            }

        }
        return fixedCapacityStackOfStrings.isEmpty();


    }

    public static void main(String[] args) {
        System.out.println("is balanced "+ isBalanced());
    }
}



/*
* ( ( [()]))
*
*
*
*
*
* */