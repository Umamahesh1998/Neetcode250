package org.ps1.arraysAndHashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecode {
    public static void main(String[] args) {
        var ip = List.of("Hello", "World");
        var op=encode(ip);
        System.out.println(op);
        var op2=decode(op);
        System.out.println(op2);
    }

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String st : strs)
            sb.append(st.length()).append("#").append(st);
        return sb.toString();
    }

    public static List<String> decode(String str) {
        List<String> sts = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#')
                j++;
            int len = Integer.parseInt(str.substring(i, j));
            sts.add(str.substring(j + 1, j + 1 + len));
            i = j + 1 + len;
        }
        return sts;
    }
}
