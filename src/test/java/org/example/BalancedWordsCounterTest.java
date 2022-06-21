package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class BalancedWordsCounterTest {
   private BalancedWordsCounter balancedWordsCounter;

    @Before
    public void setUp() {
        balancedWordsCounter=new BalancedWordsCounter();
    }

    @Test
    public void shouldSucceedWhenFirstCaseReturns28()
    {
        assertEquals(balancedWordsCounter.count("aabbabcccba"),28);
    }
    @Test
    public void shouldSucceedWhenEmptyReturns0()
    {
        assertEquals(balancedWordsCounter.count(""),0);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowRuntimeExceptionWhenNonLetter()
    {
        balancedWordsCounter.count("abababa1");
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowRuntimeExceptionWhenInputIsNull()
    {
        balancedWordsCounter.count(null);
    }
}
