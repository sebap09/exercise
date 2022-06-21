package org.example;

import org.junit.Before;
import org.junit.Test;



import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;



public class BubbleSortTest {

    private BubbleSort bubbleSort;

    @Before
    public void setUp() {
        bubbleSort=new BubbleSort();
    }

    @Test
    public void shouldSucceedWhenFirstCaseIntegersOnly()
    {
        List<Comparable> input = Arrays.asList(1, 4, 5, 6, 8, 3, 8);
        List<Comparable> result= bubbleSort.sort(input);
        List<Comparable> expected = Arrays.asList(1,3,4,5,6,8,8);
        assertArrayEquals(result.toArray(),expected.toArray());

    }

    @Test
    public void shouldSucceedWhenSecondCaseAllNumbers()
    {
        List<Comparable> input = Arrays.asList(-9,0.2,4,0.1,5,9);
        List<Comparable> result=bubbleSort.sort(input);
        List<Comparable> expected =Arrays.asList(-9,0.1,0.2,4,5,9);
        assertArrayEquals(expected.toArray(),result.toArray());
    }

    @Test
    public void shouldSucceedWhenEmptyInputAndEmptyResult()
    {
        List<Comparable> input = Collections.emptyList();
        List<Comparable> result=bubbleSort.sort(input);
        List<Comparable> expected =Collections.emptyList();
        assertArrayEquals(expected.toArray(),result.toArray());
    }

    @Test
    public void shouldSucceedWhenOmittedNullValue()
    {
        List<Comparable> input = Arrays.asList(null,5.0001);
        List<Comparable> result=bubbleSort.sort(input);
        List<Comparable> expected =Arrays.asList(5.0001);
        assertArrayEquals(expected.toArray(),result.toArray());

    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowRuntimeExceptionWhenInputIsNull()
    {
        bubbleSort.sort(null);
    }
}
