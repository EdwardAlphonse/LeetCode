package problem;

import java.util.LinkedList;
import java.util.Stack;


public class ReverseOnlyLetters {

    public String solution1(String S) {
        char[] str = S.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        // Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            if (Character.isLetter(str[i])) {
                stack.push(str[i]);
            }
        }
        for (int i = 0; i < str.length; i++) {
            if (Character.isLetter(str[i])) {
                str[i] = stack.pop();
            }
        }
        return new String(str);
    }

    public String solution2(String S) {
        char[] str = S.toCharArray();
        StringBuilder reverse = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(str[i]))
                reverse.insert(0, str[i]);
        }
        for (int i = 0; i < S.length(); i++) {
            if (!Character.isLetter(str[i]))
                reverse.insert(i, str[i]);
        }
        return reverse.toString();
    }

    public String solution3(String S) {
        char[] str = S.toCharArray();
        int i = 0, j = str.length - 1;
        while (i < j) {
            while (i < j && !Character.isLetter(str[i])) i++;
            while (i < j && !Character.isLetter(str[j])) j--;
            swap(str, i++, j--);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb.toString();
        //return new String(str);
    }

    private void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

}
