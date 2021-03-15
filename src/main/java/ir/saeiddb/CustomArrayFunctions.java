package ir.saeiddb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomArrayFunctions {

  private static final Logger LOGGER = LoggerFactory.getLogger(CustomArrayFunctions.class);

  public static List<Number> findDuplicatedNumbers(List<Number> numbers) {
    Set<Number> uniqueNumbers = new HashSet();
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
          sortedUniqueNumbers.get(first).doubleValue() + sortedUniqueNumbers.get(last).doubleValue();
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
}