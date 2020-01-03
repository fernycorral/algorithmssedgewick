package cap3;

import java.util.Iterator;
import java.util.Stack;

public class StackCopy<Type> implements Iterable{
    private int N = 1;
    private Type[] localArr = (Type[])new Object[1];


    public void push(Type item){
        if(N==localArr.length) resize(localArr.length * 2);
        localArr[N++] = item;
    }

    public Type pop(){
        Type item = localArr[--N];
        localArr[N] = null;
        if(N > 0 && N == localArr.length/4) resize(localArr.length/2);
        return item;
    }

    public void resize(int max){
        Type[] temp = (Type[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = localArr[i];
        }
        localArr = temp;
    }



    @Override
    public Iterator iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Type>{

        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < N;
        }

        @Override
        public Type next() {
         return localArr[i++];
        }
    }

}


