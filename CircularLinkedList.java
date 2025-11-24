public class CircularLinkedList<T> {
    private Node<Integer> head;
    private Node<Integer> tail;
    private int size;

    class Node<Integer> {
        Integer data;
        Node<Integer> next;

        public Node(Integer data) {
            this.data = data;
            this.next = null;
        }
    }

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addLast(Integer data) {
        Node<Integer> newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        size++;
    }

    public void addFirst(Integer data) {
        Node<Integer> newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        size++;
    }

    public void removeFirst() {
        head = head.next;
        tail.next = head;
        size--;
    }

    public void removeLast() {
        Node<Integer> current = head;
        while (current.next != tail) {
            current = current.next;
        }
        current.next = head;
        tail = current;
        size--;
    }

    public void remove(T data) {
        if (head.data.equals(data)) {
            removeFirst();
            return;
        }

        Node<Integer> current = head;
        do {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        } while (current != head);
    }

    public boolean find(Integer data) {
        Node<Integer> current = head;
        do {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        } while (current != head);
        return false;
    }

    public void rotate() {
        head = head.next;
        tail = tail.next;
    }

    public boolean findCycle() {
        return true;
    }

    public int size() {
        return size;
    }

    public void display() {
        Node<Integer> current = head;
        do {
            System.out.print(current.data);
            if (current.next != head) {
                System.out.print(" -> ");
            }
            current = current.next;
        } while (current != head);
        System.out.println(" -> (head)");
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList<>();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.display();

        list.addFirst(0);
        list.display();

        System.out.println(list.find(2));
        System.out.println(list.find(5));

        list.rotate();
        list.display();

        System.out.println(list.findCycle());

        list.removeFirst();
        list.display();

        list.removeLast();
        list.display();

        list.remove(2);
        list.display();

        System.out.println(list.size());
    }
}