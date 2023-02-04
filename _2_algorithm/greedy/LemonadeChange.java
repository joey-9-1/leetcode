//<p>在柠檬水摊上，每一杯柠檬水的售价为&nbsp;<code>5</code>&nbsp;美元。顾客排队购买你的产品，（按账单 <code>bills</code> 支付的顺序）一次购买一杯。</p>
//
//<p>每位顾客只买一杯柠檬水，然后向你付 <code>5</code> 美元、<code>10</code> 美元或 <code>20</code> 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 <code>5</code> 美元。</p>
//
//<p>注意，一开始你手头没有任何零钱。</p>
//
//<p>给你一个整数数组 <code>bills</code> ，其中 <code>bills[i]</code> 是第 <code>i</code> 位顾客付的账。如果你能给每位顾客正确找零，返回&nbsp;<code>true</code>&nbsp;，否则返回 <code>false</code>&nbsp;。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>bills = [5,5,5,10,20]
//<strong>输出：</strong>true
//<strong>解释：
//</strong>前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
// 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
// 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
// 由于所有客户都得到了正确的找零，所以我们输出 true。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>bills = [5,5,10,10,20]
//<strong>输出：</strong>false
//<strong>解释：</strong>
// 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
// 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
// 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
// 由于不是每位顾客都得到了正确的找零，所以答案是 false。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= bills.length &lt;= 10<sup>5</sup></code></li> 
// <li><code>bills[i]</code>&nbsp;不是&nbsp;<code>5</code>&nbsp;就是&nbsp;<code>10</code>&nbsp;或是&nbsp;<code>20</code>&nbsp;</li> 
//</ul>
//
//<div><li>👍 406</li><li>👎 0</li></div>
package org.example.leetcode.problems._2_algorithm.greedy;

// 860.柠檬水找零
// 开题时间：2023-01-19 14:34:35
public class LemonadeChange {
  public static void main(String[] args) {
    Solution solution = new LemonadeChange().new Solution();
    System.out.println(solution);
  }
  
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean lemonadeChange(int[] bills) {
      int five = 0, ten = 0;
      for (int bill : bills) {
        switch (bill) {
          case 5 -> five++;
          case 10 -> {
            if (five > 0) {
              five--;
              ten++;
            } else
              return false;
          }
          default -> {
            if (ten > 0 && five > 0) {
              five--;
              ten--;
            } else if (five >= 3)
              five -= 3;
            else
              return false;
          }
        }
      }
      return true;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)
}