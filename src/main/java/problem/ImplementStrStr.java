package problem;

public class ImplementStrStr {

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for
    // Implement strStr().
    // Memory Usage: 37.9 MB, less than 67.17% of Java online submissions for
    // Implement strStr().
    public int strStr1(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() <
                needle.length()) {
            return -1;
        } else if (needle.isEmpty()) {
            return 0;
        }
        int n_length = needle.length();
        int l = haystack.length() - n_length;
        for (int i = 0; i <= l; i++) {
            if (haystack.substring(i, i + n_length).equals(needle))
                return i;
        }
        return -1;
    }

    // Runtime: 2 ms, faster than 49.13% of Java online submissions for
    // Implement strStr().
    // Memory Usage: 37.8 MB, less than 67.17% of Java online submissions for
    // Implement strStr().
    public int strStr2(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.equals("")) {
            return 0;
        }
        int j = 0, idx = -1;
        int hl = haystack.length();
        int hn = needle.length();
        for (int i = 0; i < hl && j < hn; ) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                if (j == 0) {
                    idx = i;
                }
                j++;
            } else {
                if (idx != -1) {
                    j = 0;
                    i = idx;
                    idx = -1;
                }
            }
            i++;
        }
        if (j == hn) {
            return idx;
        } else {
            return -1;
        }
    }

    // Runtime: 3 ms, faster than 30.60% of Java online submissions for
    // Implement strStr().
    // Memory Usage: 38 MB, less than 66.41% of Java online submissions for
    // Implement strStr().
    //Runtime: 2 ms, faster than 49.04% of Java online submissions for Implement strStr().
    //Memory Usage: 38 MB, less than 66.41% of Java online submissions for Implement strStr().
    public int strStr3(String haystack, String needle) {
        int l1 = needle.length();
        int l2 = haystack.length();
        if (l1 == 0)
            return 0;
        if (l2 == 0)
            return -1;
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == l1)
                    return i;
                if (i + j == l2)
                    return -1;
                if (needle.charAt(j) != haystack.charAt(i + j))
                    break;
            }
        }
    }

    //Runtime: 1 ms, faster than 63.05% of Java online submissions for Implement strStr().
    //Memory Usage: 38.2 MB, less than 64.88% of Java online submissions for Implement strStr().
    public int strStr4(String haystack, String needle) {
        int l1 = needle.length();
        int l2 = haystack.length();
        if (l1 == 0)
            return 0;
        if (l2 == 0)
            return -1;
        for (int i = 0; i < l2; i++) {
            if (i + l1 > l2)
                break;
            for (int j = 0; j < l1; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j))
                    break;
                if (j == l1 - 1)
                    return i;
            }
        }
        return -1;
    }

    // Runtime: 3 ms, faster than 30.60% of Java online submissions for
    // Implement strStr().
    // Memory Usage: 38.6 MB, less than 43.51% of Java online submissions for
    // Implement strStr().
    public int strStr5(String haystack, String needle) {
        int i = 0, j = 0, n = haystack.length(), m = needle.length();

        if (m == 0)
            return 0;

        int[] lps = getLPS(needle, m);

        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                // found the needle in haystack!
                if (j == m)
                    return i - m;
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }

        return -1;
    }

    // KMP get the longest prefix and suffix
    int[] getLPS(String s, int n) {
        int i = 1, len = 0;
        int[] lps = new int[n];

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                lps[i++] = ++len;
            } else if (len == 0) {
                lps[i++] = 0;
            } else {
                len = lps[len - 1];
            }
        }
        return lps;
    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement strStr().
    //Memory Usage: 38.3 MB, less than 63.36% of Java online submissions for Implement strStr().
    public int strStr6(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
