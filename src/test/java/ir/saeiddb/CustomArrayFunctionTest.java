package ir.saeiddb;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class CustomArrayFunctionTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomArrayFunctionTest.class);

    private static final List<Number> NUMBERS_FOR_DUPLICATE_CHECKING = Arrays.asList(7, 4, 1, 9, 7, 5, 4, 1.0);

    @Test
    public void findDuplicatedNumbersTest() {
        List<Number> expectedResult = Arrays.asList(4, 7);
        List<Number> actualResult = CustomArrayFunctions.findDuplicatedNumbers(NUMBERS_FOR_DUPLICATE_CHECKING);
        Assert.assertTrue(expectedResult.size() == actualResult.size() &&
                expectedResult.containsAll(actualResult));
    }
}
