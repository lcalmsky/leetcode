package io.lcalmsky.leetcode.lemonade_change;

public class Solution {
    public boolean lemonadeChange(int[] bills) {
        if (bills[0] != 5) return false;
        int fiveDollars = 1, tenDollars = 0;
        for (int i = 1, billsLength = bills.length; i < billsLength; i++) {
            int bill = bills[i];
            if (bill == 5) fiveDollars++;
            else if (bill == 10) {
                if (fiveDollars-- <= 0) return false;
                tenDollars++;
            } else if (bill == 20) {
                if (tenDollars > 0 && fiveDollars > 0) {
                    tenDollars--;
                    fiveDollars--;
                } else if (tenDollars <= 0 && fiveDollars >= 3) {
                    fiveDollars -= 3;
                } else return false;
            }
        }
        return true;
    }
}
