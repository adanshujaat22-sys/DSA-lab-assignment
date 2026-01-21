public class DoublyLinkedList {

    private Node head;
    private Node tail;

    private static class Node {
        int value;
        Node next, prev;

        Node(int value) {
            this.value = value;
        }
    }

    void addFirst(int value) {
        Node node = new Node(value);

        if (head == null) {
            head = tail = node;
            return;
        }

        node.next = head;
        head.prev = node;
        head = node;
    }

    void addLast(int value) {
        Node node = new Node(value);

        if (head == null) {
            head = tail = node;
            return;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    void printForward() {
        Node temp = head;
        System.out.println("Forward");

        while (temp != null) {
            System.out.print(temp.value + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    void printBackward() {
        Node temp = tail;
        System.out.println("Backward");

        while (temp != null) {
            System.out.print(temp.value + " <-- ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    void deleteFirst() {
        if (head == null)
            return;

        if (head == tail) {
            head = tail = null;
            return;
        }

        head = head.next;
        head.prev = null;
    }

    void deleteLast() {
        if (head == null)
            return;

        if (head == tail) {
            head = tail = null;
            return;
        }

        tail = tail.prev;
        tail.next = null;
    }

    void deleteByValue(int value) {
        Node temp = head;

        while (temp != null && temp.value != value)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Value not found");
            return;
        }

        if (temp == head) {
            head = temp.next;
            if (head != null)
                head.prev = null;
        } else {
            temp.prev.next = temp.next;
            if (temp.next != null)
                temp.next.prev = temp.prev;
            else
                tail = temp.prev;
        }
    }

    void deleteBeforeValue(int value) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        while (temp != null && temp.value != value)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Value not found");
            return;
        }

        if (temp.prev == null) {
            System.out.println("No previous node exists to delete");
            return;
        }

        if (temp.prev.prev == null) {
            head = temp;
            temp.prev = null;
            return;
        }

        temp.prev.prev.next = temp;
        temp.prev = temp.prev.prev;
    }

    void deleteAfterValue(int value) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        while (temp != null && temp.value != value)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Value not found");
            return;
        }

        if (temp.next == null) {
            System.out.println("No next node exists");
            return;
        }

        if (temp.next.next == null) {
            tail = temp;
            temp.next = null;
            return;
        }

        temp.next = temp.next.next;
        temp.next.prev = temp;
    }

    int findMin() {
        if (head == null)
            throw new RuntimeException("List is empty");

        int min = head.value;
        Node temp = head.next;

        while (temp != null) {
            if (temp.value < min)
                min = temp.value;
            temp = temp.next;
        }
        return min;
    }

    int findMax() {
        if (head == null)
            throw new RuntimeException("List is empty");

        int max = head.value;
        Node temp = head.next;

        while (temp != null) {
            if (temp.value > max)
                max = temp.value;
            temp = temp.next;
        }
        return max;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.addFirst(20);
        list.addFirst(10);

        list.addLast(30);
        list.addLast(40);
        list.addLast(5);
        list.addLast(50);

        list.printForward();
        list.printBackward();

        list.deleteFirst();
        list.printForward();

        list.deleteLast();
        list.printForward();

        list.deleteByValue(20);
        list.printForward();

        list.deleteBeforeValue(30);
        list.deleteAfterValue(20);

        System.out.println("Minimum value is: " + list.findMin());
        System.out.println("Maximum value is: " + list.findMax());
    }
}