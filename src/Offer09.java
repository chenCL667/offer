import java.util.Stack;

public class Offer09 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int size;

    public Offer09() {
        this.size = 0;//这个字段其实不必要
        this.stack1 = new Stack<Integer>();
        this.stack2 = new Stack<Integer>();
    }

//    加入队列时，先把栈2的数据全都放回栈1中，然后进栈
//    public void appendTail(int value) {
//        while (!stack2.empty()){
//            stack1.push(stack2.pop());
//        }
//        stack1.push(value);
//        this.size++;
//    }

    //    入栈时将数据放到栈1中，时间复杂度为O(1)
    public void appendTail(int value) {
        this.stack1.push(value);
    }

//    出栈时先把所有的栈1的所有数据都放到栈2中，然后将栈2的顶部数据弹出
//    public int deleteHead() {
//        if (stack1.empty() && stack2.empty()) return -1;
//        while (!stack1.empty()){
//            stack2.push(stack1.pop());
//        }
//        this.size--;
//        return stack2.pop();
//    }

    //    当栈2为空时才把栈1的数据全都放入栈2中，否则弹出栈2顶部的元素
    public int deleteHead() {
        if (this.stack1.empty() && this.stack2.empty()) return -1;
        if (this.stack2.empty() && !this.stack1.empty()) {
            while (!this.stack1.empty()) {
                this.stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        Offer09 obj = new Offer09();
        System.out.println(obj.deleteHead());
        obj.appendTail(5);
        obj.appendTail(2);
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
    }
}
