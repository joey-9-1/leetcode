//<p>给你两个按 <strong>非递减顺序</strong> 排列的整数数组&nbsp;<code>nums1</code><em> </em>和 <code>nums2</code>，另有两个整数 <code>m</code> 和 <code>n</code> ，分别表示 <code>nums1</code> 和 <code>nums2</code> 中的元素数目。</p>
//
//<p>请你 <strong>合并</strong> <code>nums2</code><em> </em>到 <code>nums1</code> 中，使合并后的数组同样按 <strong>非递减顺序</strong> 排列。</p>
//
//<p><strong>注意：</strong>最终，合并后数组不应由函数返回，而是存储在数组 <code>nums1</code> 中。为了应对这种情况，<code>nums1</code> 的初始长度为 <code>m + n</code>，其中前 <code>m</code> 个元素表示应合并的元素，后 <code>n</code> 个元素为 <code>0</code> ，应忽略。<code>nums2</code> 的长度为 <code>n</code> 。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//<strong>输出：</strong>[1,2,2,3,5,6]
//<strong>解释：</strong>需要合并 [1,2,3] 和 [2,5,6] 。
//合并结果是 [<em><strong>1</strong></em>,<em><strong>2</strong></em>,2,<em><strong>3</strong></em>,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums1 = [1], m = 1, nums2 = [], n = 0
//<strong>输出：</strong>[1]
//<strong>解释：</strong>需要合并 [1] 和 [] 。
//合并结果是 [1] 。
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums1 = [0], m = 0, nums2 = [1], n = 1
//<strong>输出：</strong>[1]
//<strong>解释：</strong>需要合并的数组是 [] 和 [1] 。
//合并结果是 [1] 。
//注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>nums1.length == m + n</code></li> 
// <li><code>nums2.length == n</code></li> 
// <li><code>0 &lt;= m, n &lt;= 200</code></li> 
// <li><code>1 &lt;= m + n &lt;= 200</code></li> 
// <li><code>-10<sup>9</sup> &lt;= nums1[i], nums2[j] &lt;= 10<sup>9</sup></code></li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>进阶：</strong>你可以设计实现一个时间复杂度为 <code>O(m + n)</code> 的算法解决此问题吗？</p>
//
//<div><li>👍 1639</li><li>👎 0</li></div>
package org.example.leetcode.problems._2_algorithm.slidingWindow_doublePointer;

//88.合并两个有序数组
//开题时间：2022-11-12 15:16:47
public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //双指针+顺序遍历  m+m+n   1
        public void merge9(int[] A, int m, int[] B, int n) {
            System.arraycopy(A, 0, A, n, m);
            for (int idx = 0, i = n, j = 0; idx < m + n; idx++) {
                if (i >= m + n)
                    A[idx] = B[j++];
                else if (j >= n || A[i] <= B[j])
                    A[idx] = A[i++];
                else
                    A[idx] = B[j++];
            }
        }

        //☆☆☆☆☆ 双指针+倒序遍历  m+n   1
        public void merge(int[] A, int m, int[] B, int n) {
            for (int idx = m + n - 1, i = m - 1, j = n - 1; j >= 0; idx--)
                A[idx] = i < 0 || A[i] < B[j] ?
                        B[j--] :
                        A[i--];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}