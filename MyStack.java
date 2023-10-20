import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyStack<T> {
    private ArrayList<T> items; // Use ArrayList to simulate a stack

    public MyStack() {
        items = new ArrayList<>();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
    public void push(T item) {
        items.add(item);
    }
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return items.remove(items.size() - 1);
    }
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return items.get(items.size() - 1);
    }
    public int size() {
        return items.size();
    }

    public void rev_string(String my_str)  {
        int length = my_str.length();
        MyStack<Character> stack = new MyStack<>();
        while (length >= 0){
    char x = my_str.charAt(length-1);
            stack.push(x);
            System.out.println(stack.peek());
            length --;

        }
    }
    public void decimalToBinary(int my_int) {
        int i =0;
        MyStack<Integer> stack = new MyStack<>();
        MyStack<Integer> stackTwo = new MyStack<>();
        int remandier;
        while (my_int>0){
            remandier = my_int % 8;
            my_int = my_int / 8;
            stack.push(remandier);
         // System.out.println(stack.peek()+(" "));
            //need to put it into a stack now then pop and peek cuz its printign back wards

            stackTwo.push(stack.pop());// pusheds into stack 2
        }

        // while loop to pop and peek
        for (int x = 0; x<= stackTwo.size() + 1 ; x++)
        {
            System.out.print(stackTwo.peek());
            stackTwo.pop();
        }


    }


    
    public static int binaryToDecimal(String binary) {
        MyStack<Integer> stack = new MyStack<>();

        for (int i = 0; i < binary.length(); i++) {
            int digit = Character.getNumericValue(binary.charAt(i));
            stack.push(digit);
        }

        int decimal = 0;
        int power = 0;

        while (!stack.isEmpty()) {
            int digit = stack.pop();
            decimal += digit * (int) Math.pow(2, power);
            power++;
        }

        return decimal;
    }
    public boolean isBalanced (String my_str) {

        MyStack<Character> stack = new MyStack<>();
        int length = my_str.length();
        char x;
        int countOpen =0;
        int countClose =0;

        stack.rev_string(my_str);
        while (stack.isEmpty()== false){
            x= stack.peek();
            if (x == '(' ){
                countOpen++;
            }
            if (x == ')' ){
                countClose++;
            }
            stack.pop();
        }
        if (countOpen != countClose ){
                return false;
        }
        else
            return true;

    }

    public static void main(String[]args){
      /*  MyStack<Integer> stack = new MyStack<>();
        stack.push(21);
        stack.peek();
        System.out.println(stack.peek());

       */
         /*
            MyStack<Integer> stack = new MyStack<>();
            String my_string = "Hello, World!";
            stack.rev_string(my_string);
          */
     int  my_int  = 64;
            MyStack<Integer> stack = new MyStack<>();
            stack.decimalToBinary(my_int);


        }
}