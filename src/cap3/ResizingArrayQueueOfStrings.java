package cap3;

import edu.princeton.cs.algs4.Queue;

public class ResizingArrayQueueOfStrings {

    String[] a;
    int index;

    public ResizingArrayQueueOfStrings(int lenght){
        a = new String[lenght];

    }

    public void enqueue(String element){
        if(index == a.length) return;
        a[index++] = element;
    }

    public String dequeue(){
        return a[index];
    }
}
