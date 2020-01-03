package cap3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FixedCapacityStackOfStrings {

    private String[] a;
    private int N;

    public FixedCapacityStackOfStrings(int cap){
        a = new String[cap];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void push(String item){
        a[N++] = item;
    }

    public String pop(){
        return a[--N];
    }

    public boolean isFull(){
        return N == a.length;
    }

    public String peek(){
        return a[a.length-1];
    }
    public static void main(String[] args) throws IOException {
        FixedCapacityStackOfStrings s;
        s = new FixedCapacityStackOfStrings(100);

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
