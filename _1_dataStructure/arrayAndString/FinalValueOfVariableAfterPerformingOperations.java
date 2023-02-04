//<p>存在一种仅支持 4 种操作和 1 个变量 <code>X</code> 的编程语言：</p>
//
//<ul> 
// <li><code>++X</code> 和 <code>X++</code> 使变量 <code>X</code> 的值 <strong>加</strong> <code>1</code></li> 
// <li><code>--X</code> 和 <code>X--</code> 使变量 <code>X</code> 的值 <strong>减</strong> <code>1</code></li> 
//</ul>
//
//<p>最初，<code>X</code> 的值是 <code>0</code></p>
//
//<p>给你一个字符串数组 <code>operations</code> ，这是由操作组成的一个列表，返回执行所有操作后，<em> </em><code>X</code> 的 <strong>最终值</strong> 。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>operations = ["--X","X++","X++"]
//<strong>输出：</strong>1
//<strong>解释：</strong>操作按下述步骤执行：
// 最初，X = 0
//--X：X 减 1 ，X =  0 - 1 = -1
// X++：X 加 1 ，X = -1 + 1 =  0
// X++：X 加 1 ，X =  0 + 1 =  1
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>operations = ["++X","++X","X++"]
//<strong>输出：</strong>3
//<strong>解释：</strong>操作按下述步骤执行： 
// 最初，X = 0
//++X：X 加 1 ，X = 0 + 1 = 1
//++X：X 加 1 ，X = 1 + 1 = 2
// X++：X 加 1 ，X = 2 + 1 = 3
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>operations = ["X++","++X","--X","X--"]
//<strong>输出：</strong>0
//<strong>解释：</strong>操作按下述步骤执行：
// 最初，X = 0
// X++：X 加 1 ，X = 0 + 1 = 1
//++X：X 加 1 ，X = 1 + 1 = 2
//--X：X 减 1 ，X = 2 - 1 = 1
// X--：X 减 1 ，X = 1 - 1 = 0
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= operations.length &lt;= 100</code></li> 
// <li><code>operations[i]</code> 将会是 <code>"++X"</code>、<code>"X++"</code>、<code>"--X"</code> 或 <code>"X--"</code></li> 
//</ul>
//
//<div><li>👍 22</li><li>👎 0</li></div>
package org.example.leetcode.problems._1_dataStructure.arrayAndString;

import java.util.Arrays;

// 2011.执行操作后的变量值
// 开题时间：2022-11-06 09:02:13
public class FinalValueOfVariableAfterPerformingOperations {
  public static void main(String[] args) {
    Solution solution = new FinalValueOfVariableAfterPerformingOperations().new Solution();
  }
  
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int finalValueAfterOperations2(String[] operations) {
      int var = 0;
      for (String operation : operations) {
        switch (operation) {
          case "X++", "++X" -> var++;
          case "--X", "X--" -> var--;
        }
      }
      return var;
    }
    
    public int finalValueAfterOperations3(String[] operations) {
      int var = 0;
      for (String operation : operations)
        var += 44 - operation.charAt(1);
      return var;
    }
    
    public int finalValueAfterOperations(String[] operations) {
      return Arrays.stream(operations)
          .mapToInt(s -> 44 - s.charAt(1))
          .sum();
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)
}