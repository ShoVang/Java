class Node {
    private int data;
    private Node next;

    public Node(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int nodeData) {
        this.data = nodeData;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node nodeNext) {
        this.next = nodeNext;
    }

    @Override
    public String toString() {
        return Integer.toString(data);
    }
}

class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void addAtHead(int data) {
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public void addAtEnd(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public void insertAtPosition(int data, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        if (position == 0) {
            addAtHead(data);
        } else if (position == size) {
            addAtEnd(data);
        } else {
            Node newNode = new Node(data);
            Node current = head;
            Node previous = null;
            int count = 0;

            while (count < position) {
                previous = current;
                current = current.getNext();
                count++;
            }

            newNode.setNext(current);
            previous.setNext(newNode);
            size++;
        }
    }

    public boolean remove(int data) {
        if (isEmpty()) {
            return false;
        }

        if (head.getData() == data) {
            head = head.getNext();
            size--;
            return true;
        }

        Node current = head;
        Node previous = null;

        while (current != null && current.getData() != data) {
            previous = current;
            current = current.getNext();
        }

        if (current != null) {
            previous.setNext(current.getNext());
            size--;
            return true;
        }

        return false;
    }

    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.getData() == data) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public int getPosition(int data) {
        Node current = head;
        int position = 0;

        while (current != null) {
            if (current.getData() == data) {
                return position;
            }
            current = current.getNext();
            position++;
        }

        return -1;  // Not found
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            Node current = head;
            while (current != null) {
                System.out.print(current.getData() + " ");
                current = current.getNext();
            }
            System.out.println();
        }
    }
    public void sort() {
        if (size <= 1) {
            return; // No need to sort an empty or single-element list
        }

        Node current = head;
        while (current != null) {
            Node minNode = current;
            Node nextNode = current.getNext();

            while (nextNode != null) {
                if (nextNode.getData() < minNode.getData()) {
                    minNode = nextNode;
                }
                nextNode = nextNode.getNext();
            }

            // Swap the data of current and minNode
            int tempData = current.getData();
            current.setData(minNode.getData());
            minNode.setData(tempData);

            current = current.getNext();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addAtHead(7);
        list.addAtHead(6);
        list.addAtHead(9);
        list.addAtHead(5);
        list.addAtHead(4);
        list.addAtEnd(3);

        System.out.print("Original List: ");
        list.display();

        list.sort();
        System.out.print("Sorted List: ");
        list.display();
    }
}