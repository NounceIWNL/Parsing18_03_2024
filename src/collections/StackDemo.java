package collections;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.pop();
        System.out.println(stack.size());
    }
} 