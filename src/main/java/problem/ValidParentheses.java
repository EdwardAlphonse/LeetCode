package com.hoopluz.WeiXinRedPackage1.LeetCode;

import java.util.Stack;

/**
 * Author : lihuiming
 * Description :
 * Date : 2020/3/7 0007
 * Time : 16:07
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else if (c == ')' || c == '}' || c == ']') {
                {
                    if (stack.isEmpty())
                        return false;
                }
                char t = stack.pop();
                if (c == ')' && t == '(')
                    continue;
                else if (c == '}' && t == '{')
                    continue;
                else if (c == ']' && '[' == t)
                    continue;
                else
                    return false;
            }
        }
        if (stack.size() > 0) {
            return false;
        }
        return true;
    }

    public boolean isValid2(String s) {
        Stack<Character> g = new Stack<>();
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(' || str[i] == '{' || str[i] == '[') {
                g.push(str[i]);
            } else {
                if (g.isEmpty())
                    return false;
                char t = g.pop();
                if (str[i] == ')' && t == '(')
                    continue;
                else if (str[i] == ']' && t == '[')
                    continue;
                else if (str[i] == '}' && t == '{')
                    continue;
                else
                    return false;
            }
        }
        if (g.size() > 0) {
            return false;
        }
        return true;
    }

    public boolean isValid3(String s) {
        if (s.isEmpty()) {
            return true;
        }
        char[] carr = s.toCharArray();
        if (carr.length % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < carr.length; ++i) {
            char curr = carr[i];
            if (curr == '(' || curr == '[' || curr == '{') {
                stack.push(curr);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.peek();
                if (!(top == '(' && curr == ')' ||
                        top == '[' && curr == ']' ||
                        top == '{' && curr == '}')) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.size() > 0) {
            return false;
        }
        return true;
     //   return stack.empty();
    }

}
