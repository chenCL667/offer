import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Offer03 {
    public int findRepeatNumber(int[] nums) {
//        暴力遍历，时间复杂为O(n*n)，空间复杂度为O(1)
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if ( nums[i] == nums[j]) return nums[i];
//            }
//        }
//        return -1;


//        利用哈希表，时间复杂度为O(n)，空间复杂度为O(n)
//         Map<Integer, Integer> map  = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if(!map.containsKey(nums[i])) {
//                map.put(nums[i], 1);
//            } else {
//                return nums[i];
//            }
//        }
//        return -1;

//        先排序，然后遍历，时间复杂度为O(nlogn)，空间复杂度为O(1)
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (nums[i] != nums[i + 1])
//                return nums[i];
//        }
//        return -1;

//        原地交换
//        如果下标为i的位置不是存放的数字i而是数字m，那么将数字m放回下标为m的位置
//        如果数字m在放回的时候，发现数字m处已经有一个m存在了，则说明m在数组中出现了两次
        for (int i  = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]])
                    return nums[i];
                int tmp = nums[i];
                nums[i]= nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }
}
