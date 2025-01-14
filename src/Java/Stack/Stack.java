package Java.Stack;

public class Stack {
    private int[] data;
    private int top;
    private int size;

    public Stack(int size) {
        data = new int[size];
        this.size = size;
        top = -1;
    }

    public boolean isFull() {
        return size == top - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Java.Stack is full");
        } else {
            data[++top] = value;
        }
    }

    public void pop() {
        if (!isEmpty()) {
            top--;
        }
    }

    public int peak() {
        if (isEmpty()) {
            return -1;
        } else {
            return data[top];
        }
    }

    public int size() {
        return top + 1;
    }
}
