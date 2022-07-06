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
}