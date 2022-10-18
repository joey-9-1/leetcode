//<p><code>n</code>&nbsp;个灯泡排成一行，编号从 <code>1</code> 到
// <meta charset="UTF-8" />&nbsp;<code>n</code>&nbsp;。最初，所有灯泡都关闭。每天&nbsp;<strong>只打开一个</strong>&nbsp;灯泡，直到
// <meta charset="UTF-8" />&nbsp;<code>n</code>&nbsp;天后所有灯泡都打开。</p>
//
//<p>给你一个长度为
// <meta charset="UTF-8" />&nbsp;<code>n</code>&nbsp;的灯泡数组 <code>blubs</code> ，其中 <code>bulls[i] = x</code> 意味着在第 <code>(i+1)</code> 天，我们会把在位置 <code>x</code> 的灯泡打开，其中 <code>i</code> <strong>从 0 开始</strong>，<code>x</code> <strong>从 1 开始</strong>。</p>
//
//<p>给你一个整数
// <meta charset="UTF-8" />&nbsp;<code>k</code>&nbsp;，请返回<em>恰好有两个打开的灯泡，且它们中间 <strong>正好</strong> 有
//  <meta charset="UTF-8" />&nbsp;<code>k</code>&nbsp;个&nbsp;<strong>全部关闭的</strong> 灯泡的 <strong>最小的天数</strong> </em>。<em>如果不存在这种情况，返回 <code>-1</code> 。</em></p>
//
//<p>&nbsp;</p>
//
//<p><b>示例 1：</b></p>
//
//<pre>
//<b>输入：</b>
//bulbs = [1,3,2]，k = 1
//<b>输出：</b>2
//<b>解释：</b>
//第一天 bulbs[0] = 1，打开第一个灯泡 [1,0,0]
//第二天 bulbs[1] = 3，打开第三个灯泡 [1,0,1]
//第三天 bulbs[2] = 2，打开第二个灯泡 [1,1,1]
//返回2，因为在第二天，两个打开的灯泡之间恰好有一个关闭的灯泡。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>bulbs = [1,2,3]，k = 1
//<strong>输出：</strong>-1
//</pre>
//
//<p>&nbsp;</p>
//
//<p><b>提示：</b></p>
//
//<ul> 
// <li><code>n == bulbs.length</code></li> 
// <li><code>1 &lt;= n &lt;= 2 * 10<sup>4</sup></code></li> 
// <li><code>1 &lt;= bulbs[i] &lt;= n</code></li> 
// <li><code>bulbs</code> 是一个由从 <code>1</code> 到 <code>n</code> 的数字构成的排列</li> 
// <li><code>0 &lt;= k &lt;= 2 * 10<sup>4</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>树状数组</li><li>数组</li><li>有序集合</li><li>滑动窗口</li></div></div><br><div><li>👍 75</li><li>👎 0</li></div>
package org.example.leetcode.problems;

import java.util.TreeSet;

//683.K 个关闭的灯泡
//开题时间：2022-10-18 12:00:50
public class KEmptySlots {
    public static void main(String[] args) {
        Solution solution = new KEmptySlots().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
         * {1,100,30,31,60,59,57}    2
         *
         */
        //有序集合
        public int kEmptySlots(int[] bulbs, int k) {
            int len = bulbs.length;
            if (len - 2 < k)
                return -1;

            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0, t = k + 1; i < bulbs.length; i++) {
                Integer neighbor;
                int e = bulbs[i];
                if (((neighbor = set.floor(e)) != null && t == e - neighbor) ||
                        ((neighbor = set.ceiling(e)) != null && t == neighbor - e)) {
                    return i + 1;
                }
                set.add(e);
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}