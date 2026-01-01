package org.iti;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
    private ArrayList<Integer> myStackList;

    public MyStack() {
        myStackList = new ArrayList<>();
    }

    public boolean isEmpty() {
        return myStackList.isEmpty();
    }

    public MyStack push(int i) {
        myStackList.add(i);
        return this;
    }

    public int getStackPeek() {
        if (myStackList.isEmpty()) throw new IllegalStateException("Stack is empty");
        return myStackList.get(myStackList.size() - 1);
    }

    public int getStackSize() {
        return myStackList.size();
    }

    public List<Integer> getStackElements() {
        return myStackList;
    }

    public int pop() {
        if(myStackList.isEmpty()) throw new IllegalStateException("Stack is empty");
        int itemToRemove = getStackPeek();
        myStackList.remove(getStackSize() - 1);
        return itemToRemove;
    }
}
