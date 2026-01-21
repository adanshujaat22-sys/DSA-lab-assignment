class DynamicQueue {
    private int[] queue;
    private int front, rear, size;

    public DynamicQueue(int capacity) {
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int value) {
        if (size == queue.length) {
            resize();
        }
        rear++;
        queue[rear] = value;
        size++;
    }

    private void resize() {
        int[] newQueue = new int[queue.length * 2];
        for (int i = 0; i < queue.length; i++) {
            newQueue[i] = queue[i];
        }
        queue = newQueue;
        System.out.println("Queue resized to " + queue.length);
    }

    public int dequeue() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }
        int value = queue[front];
        front++;
        size--;
        return value;
    }

    public int peek() {
        return queue[front];
    }

    public void display() {
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public void findMinMax() {
        int min = queue[front];
        int max = queue[front];

        for (int i = front; i <= rear; i++) {
            if (queue[i] < min) min = queue[i];
            if (queue[i] > max) max = queue[i];
        }
        System.out.println("Min = " + min + ", Max = " + max);
    }


// ✅ MAIN CLASS (SEPARATE)

    public static void main(String[] args) {

        System.out.println("=== Array Queue with Dynamic Resizing ===");

        DynamicQueue q = new DynamicQueue(3);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40); // resize happens here

        q.display();
        System.out.println("Peek: " + q.peek());
        q.findMinMax();

        System.out.println("Dequeued: " + q.dequeue());
        q.display();
    }
}

/*
class LinkedQueue {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front, rear;

    // Enqueue
    public void enqueue(int value) {
        Node newNode = new Node(value);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    // Dequeue
    public int dequeue() {
        if (front == null) {
            throw new RuntimeException("Queue is empty");
        }

        int value = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }
        return value;
    }

    // Peek
    public int peek() {
        return front.data;
    }

    // Find Min & Max
    public void findMinMax() {
        int min = front.data;
        int max = front.data;

        Node temp = front;
        while (temp != null) {
            if (temp.data < min) min = temp.data;
            if (temp.data > max) max = temp.data;
            temp = temp.next;
        }

        System.out.println("Min = " + min + ", Max = " + max);
    }
}