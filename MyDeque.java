import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyDeque {
    private List<Object> items;

    public MyDeque() {
        items = new ArrayList<>();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void addFront(Object item) {
        items.add(item);
    }

    public void addRear(Object item) {// index is 0 this is the base bascly tail
        items.add(0, item);
    }

    public Object removeFront() {
        if (!isEmpty()) {
            return items.remove(items.size() - 1);
        } else {
            return null;
        }
    }

    public Object removeRear() {// index is 0 this is the base bascly tail
        if (!isEmpty()) {
            return items.remove(0);
        } else {
            return null;
        }
    }

    public int size() {
        return items.size();
    }

    public void palindromeChecker() {
        while (!items.isEmpty()) {
            Object front = removeFront();
            removeFront();
            Object rear = removeRear();
            if (!front.equals(rear)) {
                System.out.println("Deque is false");
                return;
            }
        }
        System.out.println("Deque is equal");
    }

    public void turnArrayToDeque(Object[] lst) {
        for (Object item : lst) {
            addRear(item);
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        MyDeque deque = new MyDeque();
        MyDeque dequeTwo = new MyDeque();
        MyDeque dequeTre = new MyDeque();
        Random random = new Random();
// adding all the things into the ques
        for (int i =0; i<4 ;i++){
            deque.addFront(random.nextInt((9 - 1) + 1) + 1);
        }
        for (int i =0; i<3 ;i++){
            dequeTwo.addFront(random.nextInt((9 - 1) + 1) + 1);
        }
        for (int i =0; i<5 ;i++){
            dequeTre.addFront(random.nextInt((9 - 1) + 1) + 1);
        }
        // showing them / printing them
        System.out.println("Before part C:");
        System.out.print("Que one ");
        while (deque.isEmpty()==false){
            System.out.print(deque.removeRear()+" ");
        }
        System.out.println(" ");
        System.out.print("Que two ");
        while (dequeTwo.isEmpty()==false){
            System.out.print(dequeTwo.removeRear()+" ");
        }
        System.out.println(" ");
        System.out.print("Que three ");
        while (dequeTre.isEmpty()==false){
            System.out.print(dequeTre.removeRear()+" ");
        }
        System.out.println(" ");
        // doing the enques and all that other stuff
        dequeTwo.addFront(21);
        dequeTre.removeRear();
        // showing the after
        System.out.println("After part C:");
        System.out.print("Que one ");
        while (deque.isEmpty()==false){
            System.out.print(deque.removeRear()+" ");
        }
        System.out.println(" ");
        System.out.print("Que two ");
        while (dequeTwo.isEmpty()==false){
            System.out.print(dequeTwo.removeRear()+" ");
        }
        System.out.println(" ");
        System.out.print("Que three ");
        while (dequeTre.isEmpty()==false){
            System.out.print(dequeTre.removeRear()+" ");
        }
        /*deque.addRear(12);
        deque.addFront(12);
        System.out.println(deque.isEmpty());
        deque.addFront(56);
        deque.removeRear();
        deque.removeFront();
        System.out.println(deque.size());

         */

    }
}
