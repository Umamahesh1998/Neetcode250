package org.ps2.slidingwindow;

/**
 * Given two strings s and t, return the shortest substring of s such that every character in t,
 * including duplicates, is present in the substring. If such a substring does not exist, return an empty string "".
 * You may assume that the correct output is always unique.
 * Example 1:
 * Input: s = "OUZODYXAZV", t = "XYZ"
 * Output: "YXAZ"
 */
public class MinimumWindowSubstring_76_3 {

    /**
     * Basic ga we have two strings we need to return the s's shortest substring that it contains every charater of t
     * mana plan enti antey
     * we will create two int array of size 128 --> need,window. we will fill need with the t values
     * we will maintain 4 variables required, formed, left, minLen
     * so we will  maintain a count of charatcers that are required
     * we will run loop on top of s(big string)
     * when ever we find one element we will append the count of it in window and check we have that in need or not
     * if present we will compare the count in both arrays if same we will increase formed count
     * if formed==required then--> we will update minLen value with right-left+1 and start value with left
     * now we will start removing character from left
     * after removing/decreasing the count of that character from window
     * we will check if the need count is more then window count
     * then we will reduced formed count
     * we will icrease left count
     * <p>
     * now we will check if minlen still equals Integer.MAX_VALUE if not we will send s.substring(start,start+minLen)
     */
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        int need[] = new int[128], window[] = new int[128], left = 0, required = 0, formed = 0, minLen = Integer.MAX_VALUE, start = 0;

        //filling the need array
        for (char c : t.toCharArray())
            need[c]++;
        //counting the req element count
        for (int count : need) {
            if (count > 0) {
                required++;
            }
        }

        //now lets start with s
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            window[ch]++;
            //we are checking the count matching and updating the formed value
            if (need[ch] > 0 && need[ch] == window[ch])
                formed++;
            while (formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                //now lets remove element from end
                char remove = s.charAt(left);
                window[remove]--;
                if (need[remove] > 0 && need[remove] > window[remove]) {
                    formed--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
