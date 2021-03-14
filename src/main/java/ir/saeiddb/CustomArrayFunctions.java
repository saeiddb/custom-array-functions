package ir.saeiddb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class CustomArrayFunctions {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomArrayFunctions.class);

    public static List<Number> findDuplicatedNumbers(List<Number> numbers) {
        Set<Number> uniqueNumbers = new HashSet();
        List<Number> duplicates = new ArrayList<>();
        for (Number number :
                numbers) {
            if (uniqueNumbers.contains(number)) {
                duplicates.add(number);
            } else {
                uniqueNumbers.add(number);
            }
        }
        return duplicates;
    }
}