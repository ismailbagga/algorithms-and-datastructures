package io.isma.datastructures.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ArrayLeetcodeProblems {


    public int[] twoSum1(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                var sum = nums[i] + nums[j];
                if (sum == target) return new int[]{i, j};
            }
        }
        return new int[]{};
    }

    public static int[] twoSum2(int[] nums, int target) {


        Map<Integer, Integer> hashmap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            var valueToLookFor = target - nums[i];
            if (hashmap.containsKey(valueToLookFor)) return new int[]{i, hashmap.get(valueToLookFor)};
            hashmap.put(nums[i], i);
        }
        return new int[]{};
    }

    public static boolean containsDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;

    }

    public static boolean containsDuplicate2(int[] nums) {
        var set = new HashSet<Integer>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;


    }
}