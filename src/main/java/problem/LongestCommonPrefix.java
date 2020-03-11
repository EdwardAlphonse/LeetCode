package problem;

import java.util.Arrays;

public class LongestCommonPrefix {

	// Runtime: 0 ms, faster than 100.00% of Java online submissions for Longest
	// Common Prefix.
	// Memory Usage: 37.5 MB, less than 87.72% of Java online submissions for
	// Longest Common Prefix.
	public String longestCommonPrefix1(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		String min = strs[0];
		String max = strs[0];
		for (String current : strs) {
			if (current.compareTo(max) > 0) {
				max = current;
			} else if (current.compareTo(min) < 0) {
				min = current;
			}
		}
		int index = 0;
		for (int i = 0; i < min.length() && i < max.length(); i++) {
			if (min.charAt(i) != max.charAt(i)) {
				break;
			}
			index++;
		}
		return min.substring(0, index);
	}

	// Runtime: 1 ms, faster than 62.08% of Java online submissions for Longest
	// Common Prefix.
	// Memory Usage: 38.6 MB, less than 69.59% of Java online submissions for
	// Longest Common Prefix.
	public String longestCommonPrefix2(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		int minLen = strs[0].length();
		int minIndex = 0;

		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() < minLen) {
				minLen = strs[i].length();
				minIndex = i;
			}
		}

		String s = strs[minIndex];
		int endIndex = s.length();
		int i;

		// could use bineary compare to get better perofrmance?!
		while (endIndex > 0) {
			String sub = s.substring(0, endIndex);
			for (i = 0; i < strs.length; i++) {
				if (!strs[i].startsWith(sub)) { // fast than
												// ->if(!strs[i].substring(0,
												// endIndex).equals(sub)){
					break; // because substring will new a new string and
							// compare A&b
							// startWith just compare a&b
				}
			}
			if (i == strs.length) {
				break;
			} else {
				endIndex--;
			}
		}

		return s.substring(0, endIndex);
	}

	// Runtime: 1 ms, faster than 62.08% of Java online submissions for Longest
	// Common Prefix.
	// Memory Usage: 37.8 MB, less than 80.70% of Java online submissions for
	// Longest Common Prefix.
	public String longestCommonPrefix3(String[] strs) {
		if (strs.length == 0)
			return "";

		StringBuilder pre = new StringBuilder(strs[0]);
		for (int i = 1; i < strs.length; i++) {
			for (int j = 0; j < pre.length(); j++) {
				if (j >= strs[i].length() || pre.charAt(j) != strs[i].charAt(j)) {
					pre.delete(j, pre.length());
					break;
				}
			}
		}
		return pre.toString();

	}

	// Runtime: 1 ms, faster than 62.08% of Java online submissions for Longest
	// Common Prefix.
	// Memory Usage: 37.8 MB, less than 80.70% of Java online submissions for
	// Longest Common Prefix.
	public static String longestCommonPrefix4(String[] strs) {
		if (strs.length == 0)
			return "";
		String prefix = strs[0];
		int index = prefix.length();
		for (int i = 1; i < strs.length; i++) {
			for (int j = 0; j < index; j++) {
				if (j >= strs[i].length() || prefix.charAt(j) != strs[i].charAt(j)) {
					index = j;
					break;
				}
			}
		}
		return prefix.substring(0, index);
	}

	// Runtime: 1 ms, faster than 62.08% of Java online submissions for Longest
	// Common Prefix.
	// Memory Usage: 38.8 MB, less than 39.18% of Java online submissions for
	// Longest Common Prefix.
	public String longestCommonPrefix5(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		Arrays.sort(strs);
		int [] aaa={};
		Arrays.sort(aaa);
		int i = 0, len = Math.min(strs[0].length(), strs[strs.length - 1].length());
		while (i < len && strs[0].charAt(i) == strs[strs.length - 1].charAt(i))
			i++;
		return strs[0].substring(0, i);
	}
}
