package ir.saeiddb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomArrayFunctions {

  private CustomArrayFunctions() {
  }

  private static final Logger LOGGER = LoggerFactory.getLogger(CustomArrayFunctions.class);

  public static List<Number> findDuplicatedNumbers(List<Number> numbers) {
    Set<Number> uniqueNumbers = new HashSet<>();
    List<Number> duplicates = new ArrayList<>();
    for (Number number : numbers) {
      if (uniqueNumbers.contains(number)) {
        duplicates.add(number);
      } else {
        uniqueNumbers.add(number);
      }
    }
    return duplicates;
  }

  public static List<Number[]> findFixedSumPairNumbersInSortedList(List<Number> sortedUniqueNumbers,
      Double expectedSum) {
    int first = 0;
    int last = sortedUniqueNumbers.size() - 1;
    List<Number[]> result = new ArrayList<>();
    while (last > first) {
      Double sum =
          sortedUniqueNumbers.get(first).doubleValue() + sortedUniqueNumbers.get(last)
              .doubleValue();
      if (sum.equals(expectedSum)) {
        LOGGER.debug("Expected sum: {} numbers are: {}, {} in indices: {}, {}", expectedSum,
            sortedUniqueNumbers.get(first), sortedUniqueNumbers.get(last), first, last);
        result.add(new Number[]{sortedUniqueNumbers.get(first), sortedUniqueNumbers.get(last)});
        last--;
        first++;
      } else if (sum > expectedSum) {
        last--;
      } else {
        first++;
      }
    }
    return result;
  }

  public static List<Double[]> findFixedSumNumbers(List<Number> numbers, Double expectedSum) {
    Set<Double> numbersSet = new HashSet<>();
    for (Number number : numbers) {
      numbersSet.add(number.doubleValue());
    }

    List<Double[]> results = new ArrayList<>();
    List<Double> pairFoundedNumbers = new ArrayList<>();
    for (Double number : numbersSet) {
      if (!pairFoundedNumbers.contains(number)) {
        double expectedNumber = expectedSum - number;
        if (numbersSet.contains(expectedNumber)) {
          results.add(new Double[]{number, expectedNumber});
          pairFoundedNumbers.add(expectedNumber);
          LOGGER.debug("Expected sum: {} numbers are: {}, {}", expectedSum, number, expectedNumber);
        }
      }
    }
    return results;
  }
}
