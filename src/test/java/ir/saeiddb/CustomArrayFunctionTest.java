package ir.saeiddb;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomArrayFunctionTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(CustomArrayFunctionTest.class);

  private static final List<Number> NUMBERS_FOR_DUPLICATE_CHECKING = Arrays
      .asList(7, 4, 1, 9, 7, 5, 4, 1.0);
  private static final List<Number> SORTED_NUMBERS_FOR_FIXED_SUM_CHECKING = Arrays
      .asList(1, 3, 4, 6, 8, 11, 15, 23, 24, 58, 59, 62, 67, 69, 70, 78);

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
    List<Number[]> expectedResult = Arrays
        .asList(new Number[]{3, 70}, new Number[]{6, 67}, new Number[]{11, 62}, new Number[]{69, 4},
            new Number[]{15, 58});
    List<Number[]> actualResult = CustomArrayFunctions
        .findFixedSumPairNumbersInSortedList(SORTED_NUMBERS_FOR_FIXED_SUM_CHECKING, 73D);
    Assert.assertTrue(expectedResult.size() == actualResult.size());
    for (int i = 0; i < expectedResult.size(); i++) {
      boolean sameAnswerWasFound = false;
      for (int j = 0; j < actualResult.size(); j++) {
        if (expectedResult.get(i).length == actualResult.get(j).length &&
            Arrays.asList(expectedResult.get(i)).containsAll(Arrays.asList(actualResult.get(j)))) {
          sameAnswerWasFound = true;
          continue;
        }
      }
      Assert.assertTrue(sameAnswerWasFound);
    }
  }
}
