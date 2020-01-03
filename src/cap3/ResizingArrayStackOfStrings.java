package cap3;

import edu.princeton.cs.algs4.ResizingArrayStack;
import edu.princeton.cs.algs4.StdOut;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ResizingArrayStackOfStrings {

    private String[] s = new String[1];
    private int N = 0;

    public boolean isEmpty(){return N== 0;}
    public int size(){return  N;}

    private void resize(int max){
        String[] temp = new String[max];
        for (int i = 0; i < s.length; i++) {
            temp[i] = s[i];
        }
        s = temp;
    }

    public void push(String string){
        if(N == s.length) resize(2 * s.length);
        s[N++] = string;
    }

    public String pop(){
        String value = s[--N];
        s[N] = null;
        if(N > 0 && N ==s.length/4) resize(s.length/2);
        return value;
    }

    public ResizingArrayStackOfStrings(int length){
        s = new String[length];
    }

    public static void main(String[] args) throws IOException {
        ResizingArrayStackOfStrings s;
        s = new ResizingArrayStackOfStrings(100);

        String[] as =  Files.readAllLines(Paths.get(args[0])).get(0).split("\\s+");
        // while(!StdIn.isEmpty()){
        for (int i = 0; i < as.length; i++) {
            String item = as[i];
            if(!item.equals("-"))
                s.push(item);
            else  if((!s.isEmpty())) StdOut.print(s.pop() + " ");
        }

        StdOut.println("("+s.size()+ " left on Stack)");
    }
}
