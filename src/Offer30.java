import java.util.Stack;

public class Offer30 {
    /**
     * initialize your data structure here.
     */
    public Stack<Integer> stack1;
    public Stack<Integer> stack2;

    public Offer30() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void push(int x) {
        int tmp = Integer.MAX_VALUE;
        if (!stack2.empty())
            tmp = stack2.peek();
        stack1.push(x);
        stack2.push(Math.min(tmp, x));
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        int tmp = 0;
        if (!stack1.empty()) {
            tmp = stack1.peek();
        }
        return tmp;
    }

    public int min() {
        if (!stack2.empty())
            return stack2.peek();
        return 0;
    }
}
