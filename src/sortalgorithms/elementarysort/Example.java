package sortalgorithms.elementarysort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

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
                //Arrays.stream(a).forEach(System.out::print);
            }
        }
    }

    public static void shellSort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while(h < N/3) h = 3 * h + 1;
        while (h >= 1){
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j-=h) {
                    exch(a, j, j-h);
                }
            }
            h = h/3;
        }
    }
    static Comparable[] aux;

    private static void merge(Comparable[] a,int lo, int mid, int hi){
        int i = lo, j = mid + 1;
new ArrayList<String>().sort();
        for (int k = lo; k <= hi ; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if(i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if(less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private static void mergeSort(Comparable[]a){
        aux = new Comparable[a.length];
        mergeSort(a,0,a.length-1);
    }

    private static void mergeSort(Comparable[]a,int lo,int hi){
        if(hi <= lo) return;
        int mid = lo + (hi -lo)/2;
        mergeSort(a,lo,mid);
        mergeSort(a,mid + 1,hi);
        merge(a,lo,mid,hi);
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
       // selectionSort(a);
        mergeSort(a);
        assert isSorted(a);
        show(a);
    }
}