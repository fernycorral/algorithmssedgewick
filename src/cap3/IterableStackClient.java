package cap3;

import edu.princeton.cs.algs4.Stack;

import java.util.Iterator;

public class IterableStackClient implements Iterable<String> {
    @Override
    public Iterator<String> iterator() {
        return new StackIterator();
    }

    public static StackCopy copy(Stack<String> stack){
        StackCopy copy = new StackCopy();
        Iterator iterator= stack.iterator();

        while(iterator.hasNext())
            copy.push(stack.iterator().next());

        return copy;
    }

    private class StackIterator implements  Iterator<String>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public String next() {
            return null;
        }
    }
}
