package com.ajin.deep.in.java.collection.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ajin
 */

public class TwoNumberSumDemo {


    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int[] twoSumTimeOut(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        int[] indexArray = new int[2];
        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] <= target) {
            map.put(i, nums[i]);
//            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 数值
            Integer value = entry.getValue();
            Integer key = entry.getKey();
            // 和target的差值
            int gap = target - value;

            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                Integer k = e.getKey();
                Integer v = e.getValue();
                if (!Objects.equals(key, k) && Objects.equals(v, gap)) {
                    indexArray[0] = entry.getKey();
                    indexArray[1] = k;
                    break;
                }
            }
        }
        return indexArray;


    }

    public static int[] twoSumTimeCorrect(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>(16);

        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer index = i;
            Integer value = map.get(i);
            Integer difference = target - value;
            if (map.containsValue(difference)) {
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (!entry.getKey().equals(index) && entry.getValue().equals(difference)) {
                        return new int[]{index, entry.getKey()};
                    }
                }
            }
        }
        throw new IllegalArgumentException();
    }

    public static int[] towSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException();
    }

    public static int[] towSum2(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>(16);

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
//        int[] nums = new int[]{-3, 4, 3, 90};
        int target = 9;
        System.out.println(Arrays.toString(towSum2(nums, target)));
    }
}
