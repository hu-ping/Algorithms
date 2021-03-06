package test48;
/**
 * 在一个字符串中找到第一个只出现一次的字符，并返回它的位置。
 * 解题思路： 
 * 以上实现的空间复杂度还不是最优的。考虑到只需要找到只出现一次的字符，那么需要统计的次数信息只有 0,1,更大，使用两个比特位就能存储这些信息。
 * @author 54060
 *
 */
import java.util.BitSet;

public class Solution1_2 {
	public int FirstNotRepeatingChar2(String str) {
	    BitSet bs1 = new BitSet(256);
	    BitSet bs2 = new BitSet(256);
	    for (char c : str.toCharArray()) {
	        if (!bs1.get(c) && !bs2.get(c))
	            bs1.set(c);     // 0 0 -> 0 1
	        else if (bs1.get(c) && !bs2.get(c))
	            bs2.set(c);     // 0 1 -> 1 1
	    }
	    for (int i = 0; i < str.length(); i++) {
	        char c = str.charAt(i);
	        if (bs1.get(c) && !bs2.get(c))  // 0 1
	            return i;
	    }
	    return -1;
	}
}
