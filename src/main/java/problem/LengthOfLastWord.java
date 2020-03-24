package problem;

public class LengthOfLastWord {

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Length
    // of Last Word.
    // Memory Usage: 37.6 MB, less than 7.57% of Java online submissions for
    // Length of Last Word.
    public int lengthOfLastWord1(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) {
            return 0;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Length
    // of Last Word.
    // Memory Usage: 37.6 MB, less than 7.57% of Java online submissions for
    // Length of Last Word.
    public int lengthOfLastWord2(String s) {
        if (null == s || 0 >= s.length()) {
            return 0;
        }
        int length = 0;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (' ' != chars[i]) {
                length++;
            } else if (length > 0) {
                return length;
            }
        }
        return length;
    }

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Length
    // of Last Word.
    // Memory Usage: 37.8 MB, less than 7.57% of Java online submissions for
    // Length of Last Word.
    public int lengthOfLastWord3(String s) {
        int length = 0, i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i--) != ' ')
                length++; // 非空且为最后一个字符串，则计数
            else if (length > 0)
                return length; // 遇到空，且长度不为0，说明字符串长度统计已结束
        }
        return length;
    }


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Length
    // of Last Word.
    // Memory Usage: 37.7 MB, less than 7.57% of Java online submissions for
    // Length of Last Word.
    public int lengthOfLastWord4(String s) {
        String[] words = s.split(" ");
        if (words.length == 0) {
            return 0;
        } else {
            return words[words.length - 1].length();
        }
    }

}
