package io.github.nstdio.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ProblemsTest {

  @ParameterizedTest
  @CsvSource(value = {
      "123,123",
      "          123      ,123",
      "          123.2  ,123",
      "1,1",
      "+1,1",
      "-1,-1",
      "   ,0",
      "4193 with words,4193",
      "2147483648,2147483647", // overflow
      "-2147483649,-2147483648", // overflow
      "-91283472332,-2147483648", // overflow
  }, ignoreLeadingAndTrailingWhitespace = false)
  void shouldMatch(String input, int expected) {
    //when
    var actual = Problems.atoi(input);

    //then
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @CsvSource(value = {
      "-123,-321",
      "123,321",
      "2147483647,0",
      "-2147483648,0",
  })
  void reverse(int input, int expected) {
    //when
    int actual = Problems.reverse(input);

    //then
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @CsvSource(value = {
      "I,1",
      "II,2",
      "III,3",
      "IV,4",
      "V,5",
      "VI,6",
      "VII,7",
      "VIII,8",
      "IX,9",
      "X,10",
      "MCMXCIV,1994",
      "LVIII,58",
  })
  void romainToInt(String input, int expected) {
    //when
    int actual = Problems.romanToInt(input);

    //then
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @CsvSource(value = {
      "CXXII,122",
      "I,1",
      "II,2",
      "III,3",
      "IV,4",
      "V,5",
      "VI,6",
      "VII,7",
      "VIII,8",
      "IX,9",
      "X,10",
      "LX,60",
      "MCMXCIV,1994",
      "LVIII,58",
  })
  void intToRoman(String expected, int input) {
    //when
    var actual = Problems.intToRoman(input);

    //then
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @CsvSource(value = {
      "aaaaaab,.*..,true",
      "ab,.*..,true",
      "a,a*b*,true",
      "a,a*b*c*d*.*,true",
      "a,ab*,true",
      "aaa,a*a,true",
      "aab,c*a*b,true",
      "zzz,.*z,true",
      "abcyz,ab.*yz,true",
      "xabc,.*abc,true",
      "abc,.*abc,true",
      "abcc,.*abc,false",
      "xyabc,.*abc,true",
      "a,.*.*.*,true",
      "ab,.*.*.*,true",
      "ab,..*.*.*,true",
      "abcblahblahxyz,ab.*z,true",
      "abcblahblahxyz,a.*z,true",
      "zzzb,.*z,false",
      "xyz,.*z,true",
      "xyz,xy.*,true",
      "xyzz,xy.*,true",
      "abc,a.c,true",
      "aZc,a.c,true",
      "aZc,azc,false",
      "ac,a.c,false",
      "ac,ac,true",
      "acv,ac,false",
      "a,a.,false",
      "a,a.,false",
      "a,.,true",
      "aa,.,false",
      "aa,.a,true",
      "aa,.b,false",
      "aab,.b,false",
      "aaaaaaaa,a*,true",
      "abaaaaaa,a*,false",
      "baaaaaaa,.a*,true",
      "jaflmxswcbznm,.*,true",
      "xyz,.*,true",
      "xyzzzz,xy.*,true"
  })
  void isMatch(String input, String pattern, boolean expected) {
    //when
    var actual = Problems.isMatch(input, pattern);

    //then
    assertEquals(expected, actual, () -> "input: %s, pattern: %s, expected: %s".formatted(input, pattern, expected));
  }
}