public class Offer21 {
    public int[] exchange(int[] nums) {
        int front = 0, rear = nums.length - 1;
        while (front < rear) {
            while (front < nums.length && nums[front] % 2 == 1) front++;
            while (rear >= 0 && nums[rear] % 2 == 0) rear--;
            if (front < rear) {
                nums[front] = nums[front] + nums[rear];
                nums[rear] = nums[front] - nums[rear];
                nums[front] = nums[front] - nums[rear];
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8};
        Offer21 offer21 = new Offer21();
        for (int e : offer21.exchange(nums)) {
            System.out.println(e);
        }

    }
}
