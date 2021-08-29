package com.algorithm.jz;

/**
 *
 */
public class JZ2 {

    public static void main(String[] args) {
        String str = "We Are Happy";
        JZ2 jz2 = new JZ2();
        System.out.println("平移法 : " + jz2.replaceSpace1(str));
        System.out.println("遍历法 : " + jz2.replaceSpace2(str));
    }

    /**
     * 平移法
     *
     * @param str
     * @return
     */
    public String replaceSpace1(String str) {
        if (str == null && str.length() == 0) {
            return str;
        }

        int strLength = str.length();

        char[] chars = new char[strLength * 3];
        int charsIndex = 0;

        for (int i = 0; i < strLength; i++) {
            char currChar = str.charAt(i);
            if (currChar == ' ') {
                chars[charsIndex++] = '%';
                chars[charsIndex++] = '2';
                chars[charsIndex++] = '0';
            } else {
                chars[charsIndex++] = currChar;
            }

        }
        return new String(chars, 0, charsIndex);
    }

    /**
     * 遍历法
     *
     * @param str
     * @return
     */
    public String replaceSpace2(String str) {
        if (str == null && str.length() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (' ' == c) {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
