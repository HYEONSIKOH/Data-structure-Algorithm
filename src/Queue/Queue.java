package Queue;

public class Queue {
    private int[] arr;
    private int front;
    private int rear;
    private int size;

    public Queue() {
        size = 10001;
        arr = new int[size];
        front = 0;
        rear = 0;
    }

    // Queue가 비어있는지 확인
    public boolean isEmpty() { return front == rear; }

    // Queue에 값 넣기
    public void enqueue(int value){
        arr[rear++] = value;
        rear %= size;
    }

    // Queue에서 맨 앞에 값 확인
    public int peek() { return isEmpty() ? -1 : arr[front]; }

    // Queue 맨 뒤 값 확인
    public int back() { return isEmpty() ? -1 : arr[(rear - 1 + size) % size]; }

    // Queue에서 맨 앞에 값 빼기
    public int dequeue() {
        if (isEmpty()) return -1;

        int res = arr[front];
        front = ++front % size;

        return res;
    }

    // Queue 안에 정수 개수 확인
    public int size() {
        if (rear >= front) return rear - front;
        else return size - front + rear;
    }
}
