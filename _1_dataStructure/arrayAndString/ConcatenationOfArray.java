//<p>给你一个长度为 <code>n</code> 的整数数组 <code>nums</code> 。请你构建一个长度为 <code>2n</code> 的答案数组 <code>ans</code> ，数组下标<strong> 从 0 开始计数 </strong>，对于所有&nbsp;<code>0 &lt;= i &lt; n</code> 的 <code>i</code> ，满足下述所有要求：</p>
//
//<ul> 
// <li><code>ans[i] == nums[i]</code></li> 
// <li><code>ans[i + n] == nums[i]</code></li> 
//</ul>
//
//<p>具体而言，<code>ans</code> 由两个 <code>nums</code> 数组 <strong>串联</strong> 形成。</p>
//
//<p>返回数组<em> </em><code>ans</code> 。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [1,2,1]
//<strong>输出：</strong>[1,2,1,1,2,1]
//<strong>解释：</strong>数组 ans 按下述方式形成：
//- ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
//- ans = [1,2,1,1,2,1]</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [1,3,2,1]
//<strong>输出：</strong>[1,3,2,1,1,3,2,1]
//<strong>解释：</strong>数组 ans 按下述方式形成：
//- ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
//- ans = [1,3,2,1,1,3,2,1]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>n == nums.length</code></li> 
// <li><code>1 &lt;= n &lt;= 1000</code></li> 
// <li><code>1 &lt;= nums[i] &lt;= 1000</code></li> 
//</ul>
//
//<div><li>👍 39</li><li>👎 0</li></div>
package org.example.leetcode.problems._1_dataStructure.arrayAndString;

import java.util.Arrays;

//1929.数组串联
//开题时间：2022-11-05 08:43:48
public class ConcatenationOfArray {
    public static void main(String[] args) {
        Solution solution = new ConcatenationOfArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getConcatenation(int[] nums) {
            int[] ans = Arrays.copyOf(nums, nums.length * 2);
            System.arraycopy(nums, 0, ans, nums.length, nums.length);
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}