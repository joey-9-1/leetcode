package org.example.leetcode.problems.algorithm.sort.others;

import org.example.leetcode.problems.algorithm.sort.Swap;
import org.example.leetcode.problems.common.tool.Tools;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//猴子排序（即随机排序）  O(n*n!)
public class Bogo {
    public static void main(String[] args) {
//        Swap.sort(Bogo::bogoSort);
        Swap.sortHard(Bogo::bogoSort);
    }

    public static void bogoSort(int[] arr) {
        List<Integer> list = Tools.toList(arr);

        while (true) {
            if (Swap.isSortedNaturally(list)) break;
            Collections.shuffle(list);
        }

        System.arraycopy(Tools.toArray(list), 0, arr, 0, arr.length);
    }
}
