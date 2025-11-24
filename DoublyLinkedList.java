public class DoublyLinkedList<T>{

    public class Node<Integer>
    {
        Integer data;
        Node<Integer> prev;
        Node<Integer> next;

        Node(Integer data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node<Integer> head;
    private int size;

    public void addLast(Integer data)
    {
        Node<Integer> newNode = new Node<>(data);

        if (head == null)
        {
            head = newNode;
        }
        else
        {
            Node<Integer> current = head;
            while (current.next != null)
            {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
        size++;
    }

    public void addFirst(T data)
    {
        Node<Integer> newNode = new Node(data);

        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
        size++;
    }

    public void removeFirst()
    {
        if (head == null) return;

        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        size--;
    }

    public void removeLast()
    {
        if (head == null) return;

        if (head.next == null) {
            head = null;
        } else {
            Node<Integer> current = head;
            while (current.next != null)
            {
                current = current.next;
            }
            current.prev.next = null;
        }
        size--;
    }

    public void remove(Integer data)
    {
        if (head == null) return;

        Node<Integer> current = head;

        if (current.data.equals(data))
        {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            size--;
            return;
        }

        while (current != null && !current.data.equals(data))
        {
            current = current.next;
        }

        if (current != null) {
            if (current.prev != null) {
                current.prev.next = current.next;
            }
            if (current.next != null) {
                current.next.prev = current.prev;
            }
            size--;
        }
    }

    public boolean contains(Integer data)
    {
        Node<Integer> current = head;
        while (current != null)
        {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    public void clear()
    {
        head = null;
        size = 0;
    }

    public void display()
    {
        if (head == null)
        {
            System.out.println("Список пуст");
            System.out.println("-------------------------");
            return;
        }
        Node<Integer> current = head;
        while (current != null)
        {
            System.out.print(current.data);
            if (current.next != null)
            {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.println();
        System.out.println("-------------------------");
    }

    public void add(int index, T data) {

        Node<Integer> newNode = new Node(data);

        if (head == null) {
            head = newNode;
        }
        else if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        else if (index == size) {
            Node<Integer> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
        else {
            Node<Integer> current = head;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
        }

        size++;
    }

    public void remove(int index) {

        if (index == 0) {
            removeFirst();
            return;
        }

        if (index == size - 1) {
            removeLast();
            return;
        }

        Node<Integer> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
    }

    public Integer get(int index) {

        Node<Integer> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    public void displayReverse() {

        Node<Integer> current = head;
        while (current.next != null) {
            current = current.next;
        }

        while (current != null) {
            System.out.print(current.data);
            if (current.prev != null) {
                System.out.print(" <-> ");
            }
            current = current.prev;
        }
        System.out.println();
        System.out.println("-------------------------");
    }

    public Integer getFirst() {
        return head.data;
    }

    public Integer getLast() {

        Node<Integer> current = head;
        while (current.next != null) {
            current = current.next;
        }

        return current.data;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList<>();

        list.addFirst(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        list.display();

        list.add(3, 0);

        list.display();

        list.remove(3);

        list.display();

        list.remove(2);
        list.display();

        System.out.println(list.get(3));
        list.displayReverse();
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
    }
}
