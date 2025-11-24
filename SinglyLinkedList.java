import java.util.List;

public class SinglyLinkedList<Integer>
{

    public static class Node<Integer>
    {
        Integer data;
        Node<Integer> next;

        Node(Integer data)
        {
            this.data = data;
            this.next = null;
        }
    }

    private Node<Integer> head;
    private int size;


    public void addLast(Integer data)
    {
        Node<Integer> NewNode = new Node<>(data);

        if (head == null)
        {
            head = NewNode;
        }
        else
        {
            Node<Integer> current = head;
            while (current.next != null)
            {
                current = current.next;
            }
            current.next = NewNode;
        }
        size++;
    }

    public void addFirst(Integer data)
    {
        Node<Integer> NewNode = new Node<>(data);

        Node<Integer> current = NewNode;
        current.next = head;
        head = NewNode;
        size++;
    }

    public void removeFirst()
    {
        Node<Integer> current = head;
        head = current.next;
        size--;
    }

    public void removeLast()
    {
        Node<Integer> current = head;

        while(current.next.next != null)
        {
            current = current.next;
        }
        current.next = null;
        size--;
    }

    public void remove(Integer data)
    {
        Node<Integer> current = head;

        if (current.data.equals(data))
        {
            head = head.next;
            size--;
            return;
        }

        while(current.next.data != data)
        {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    public void contains(Integer data)
    {
        Node<Integer> current = head;
        while (current.data != data)
        {
          current = current.next;
          if (current.next == null)
          {
              System.out.println("Элемента " + data + " нет в списке");
              return;
          }
        }
        System.out.println("Элемент " + data + " есть в списке");
    }

    public int size()
    {
        return size;
    }

    public void isEmpty()
    {
        if (head == null)
        {
            System.out.println("Список пуст");
        }
    }

    public void clear()
    {
        head = null;
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
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
        System.out.println("-------------------------");
    }

    public static void main(String[] arg)
    {
        SinglyLinkedList list = new SinglyLinkedList<>();

        System.out.println("Проверка списка на пустоту");
        list.isEmpty();
        System.out.println("-------------------------");


        System.out.println("Список изначально");
        list.display();

        System.out.println("Добавляем элементы в конец");
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);
        list.addLast(70);
        list.addLast(80);
        list.display();

        System.out.println("Добавляем элементы в начало");
        list.addFirst(10);
        list.addFirst(0);
        list.display();

        System.out.println("Удаляем первый элемент");
        list.removeFirst();
        list.display();

        System.out.println("Удаляем последний элемент");
        list.removeLast();
        list.display();

        System.out.println("Удаляем конкретный элемент");
        list.remove(20);
        list.display();

        System.out.println("Проверка наличия элемента");
        list.contains(90);
        list.contains(60);
        System.out.println("-------------------------");

        System.out.print("Длина списка = ");
        System.out.println(list.size());
        System.out.println("-------------------------");

        System.out.println("Очистка списка");
        list.clear();
        list.display();

    }
}