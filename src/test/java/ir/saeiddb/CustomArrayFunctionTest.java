package ir.saeiddb;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class CustomArrayFunctionTest {

  private static final List<Number> NUMBERS_FOR_DUPLICATE_CHECKING = Arrays
      .asList(7, 4, 1, 9, 7, 5, 4, 1.0);
  private static final List<Number> SORTED_NUMBERS_FOR_FIXED_SUM_CHECKING = Arrays
      .asList(1, 3, 4, 6, 8, 11, 15, 23, 24, 58, 59, 62, 67, 69, 70, 78);
  private static final List<Number> NUMBERS_FOR_FIXED_SUM_CHECKING = Arrays
      .asList(24, 1, 59, 3, 4, 8, 15, 23, 8, 58, 62, 6, 67, 69, 6, 70, 78, 11);

  @Test
  public void findDuplicatedNumbersTest() {
    List<Number> expectedResult = Arrays.asList(4, 7);
    List<Number> actualResult = CustomArrayFunctions
        .findDuplicatedNumbers(NUMBERS_FOR_DUPLICATE_CHECKING);
    Assert.assertTrue(expectedResult.size() == actualResult.size() &&
        expectedResult.containsAll(actualResult));
  }

  @Test
  public void findFixedSumPairNumbersInSortedArrayTest() {
    List<Number[]> expectedResults = Arrays
        .asList(new Number[]{3, 70}, new Number[]{6, 67}, new Number[]{11, 62}, new Number[]{69, 4},
            new Number[]{15, 58});
    List<Number[]> actualResults = CustomArrayFunctions
        .findFixedSumPairNumbersInSortedList(SORTED_NUMBERS_FOR_FIXED_SUM_CHECKING, 73D);
    checkListOfArrayEquality(expectedResults, actualResults);
  }

  @Test
  public void findFixedSumNumbersTest() {
    List<Double[]> expectedResults = Arrays
        .asList(new Double[]{3D, 70D}, new Double[]{6D, 67D}, new Double[]{11D, 62D},
            new Double[]{69D, 4D}, new Double[]{15D, 58D});
    List<Double[]> actualResults = CustomArrayFunctions
        .findFixedSumNumbers(NUMBERS_FOR_FIXED_SUM_CHECKING, 73D);
    checkListOfArrayEquality(expectedResults, actualResults);
  }

  private void checkListOfArrayEquality(List<? extends Number[]> expectedResults,
      List<? extends Number[]> actualResults) {
    Assert.assertEquals(expectedResults.size(), actualResults.size());
    for (Number[] expectedResult : expectedResults) {
      boolean sameAnswerWasFound = false;
      for (Number[] actualResult : actualResults) {
        if (expectedResult.length == actualResult.length &&
            Arrays.asList(expectedResult).containsAll(Arrays.asList(actualResult))) {
          sameAnswerWasFound = true;
          break;
        }
      }
      Assert.assertTrue(sameAnswerWasFound);
    }
  }
}
