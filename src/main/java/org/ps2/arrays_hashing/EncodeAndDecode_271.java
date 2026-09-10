package org.ps2.arrays_hashing;

import java.util.ArrayList;
import java.util.List;

/**
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
 */
public class EncodeAndDecode_271 {
    public static void main(String[] args) {

    }

    /**
     * encode the string send it via network decode method will decode that string
     */
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String st : strs) {
            sb.append(st.length()).append("#").append(st);
        }
        return sb.toString();
    }

    /**
     * initiate i=0;
     * loop run chestam while(i<str.lenght)
     * we will append the j value till we reach the #
     * once after reaching the # place we will consider the string from i to j as a lenght value we will parse it
     * int len= Integer.parseInt(str.subString(i,j))
     * now we will take a substring from j+1 --> j+1+len and add it into the ans list
     * append the i value with i=j+1+len to skip the completed string
     */
    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#')
                j++;
            int len = Integer.parseInt(str.substring(i, j));
            i = j + 1 + len;
            ans.add(str.substring(j + 1, i));
        }
        return ans;
    }
}
