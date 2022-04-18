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
}