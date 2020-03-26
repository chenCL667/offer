import java.util.Stack;

public class Offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null && popped == null) return true;
        if (pushed == null && popped != null) return false;
        if (pushed != null && popped == null) return false;
        if (pushed.length != popped.length) return false;

        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (index < popped.length && !stack.empty() &&  popped[index] == stack.peek()) {
                stack.pop();
                index++;
            }
        }
        if (stack.empty() && index == popped.length) return true;
        return false;
    }

    public static void main(String[] args) {
        int[] pushed = {1, 2};
        int[] popped = {1, 2};

        Offer31 offer31 = new Offer31();
        System.out.println(offer31.validateStackSequences(pushed, popped));
    }
}
