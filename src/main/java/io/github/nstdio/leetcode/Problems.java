package io.github.nstdio.leetcode;

public class Problems {
  /**
   * https://leetcode.com/problems/string-to-integer-atoi/
   */
  public static int atoi(String s) {
    int len = s.length();
    int i = 0;
    while (i < len && s.charAt(i++) == ' ') {} // skip whitespaces

    if (i == len)
      return 0;

    boolean negative = false;
    char sch = s.charAt(i);
    if (sch == '-' || sch == '+') {
      i++;
      negative = sch == '-';
    }

    long num = 0;
    char c;
    while (i < len && (c = s.charAt(i++)) >= '0' && c <= '9') {
      num = (num * 10) + (c - 48);
      if (num > Integer.MAX_VALUE) {
        num = Integer.MAX_VALUE;
        if (negative) num += 1;
        break;
      }
    }

    return (int) (negative ? -num : num);
  }

  public static int reverse(int x) {
    int r = 0;
    int hi = Integer.MAX_VALUE / 10;
    int lo = Integer.MIN_VALUE / 10;

    while (x != 0) {
      if (r > hi || r < lo) return 0;

      r = (r * 10) + x % 10;
      x /= 10;
    }

    return r;
  }

  public static int romanToInt(String s) {
    int n = 0;
    int len = s.length();
    int p = Integer.MAX_VALUE;
    for (int i = 0; i < len; i++) {
      int v = 0;

      //@formatter:off
      switch (s.charAt(i)) {
        case 'I': v=1;break;
        case 'V': v=5;break;
        case 'X': v=10;break;
        case 'L': v=50;break;
        case 'C': v=100;break;
        case 'D': v=500;break;
        case 'M': v=1000;break;
      }
      //@formatter:on

      if (p < v)
        v -= p * 2;
      n += v;
      p = v;
    }

    return n;
  }

  public static String intToRoman(int n) {
    String[] romans = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    int[] value = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    int i = romans.length - 1;
    var ret = new StringBuilder();

    while (n > 0) {
      while (value[i] <= n) {
        ret.append(romans[i]);
        n -= value[i];
      }
      i--;
    }

    return ret.toString();
  }

  public static boolean isMatch(String i, String p) {
    if (p.isEmpty()) {
      return i.isEmpty();
    }

    boolean isCharMatched = !i.isEmpty() && (p.charAt(0) == '.' || i.charAt(0) == p.charAt(0));
    if (p.length() > 1 && p.charAt(1) == '*') {
      if (isMatch(i, p.substring(2))) {
        return true;
      }
      return isCharMatched && isMatch(i.substring(1), p);
    } else {
      return isCharMatched && isMatch(i.substring(1), p.substring(1));
    }
  }
}
