package sortalgorithms.elementarysort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Example {

    private static  boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }

    private static void show(Comparable[] a){
        for (int k = 0; k < a.length ; k++) {
            StdOut.print(a[k] + " ");
        }

        StdOut.println();
    }


    public static boolean isSorted(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }


    public static void selectionSort(Comparable[] a){
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i +1 ; j < N; j++) {
                if(less(a[j],a[min]))
                    min = j;
            }
            exch(a, i, min);
        }
    }

    public static void insertionSort(Comparable[] a){
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }

    public static void main(String[] args) {

        String[] a = null;
        if(args.length == 0)
            a = StdIn.readAllStrings();
        else{
            try {
                a = Files.readAllLines(Paths.get(args[0])).get(0).split(" ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        show(a);
        selectionSort(a);
        assert isSorted(a);
        show(a);
    }
}
