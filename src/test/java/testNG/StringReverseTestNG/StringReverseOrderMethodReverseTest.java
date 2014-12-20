package testNG.StringReverseTestNG;

import classes.StringReverseOrder;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StringReverseOrderMethodReverseTest {
    private StringReverseOrder stringReverseOrder;

    @BeforeTest
    public void init(){
        stringReverseOrder = new StringReverseOrder();
    }

    @Test
    public void methodReverseFirstTest(){
        Assert.assertEquals(stringReverseOrder.reverseValue("testvalue"), "eulavtset");
    }

    @Test
    public void methodReverseSecondTest(){
        Assert.assertEquals(stringReverseOrder.reverseValue(" Test reverse ! @ # $ "), " $ # @ ! esrever tseT ");
    }

    @Test
    public void methodLengthTest(){
        stringReverseOrder.reverseValue("test length");
        Assert.assertEquals(stringReverseOrder.length(), 11);
    }

    @Test
    public void methodCharAtTest(){
        stringReverseOrder.reverseValue("test char At");
        Assert.assertEquals(stringReverseOrder.charAt(10), 'e');
    }

    @Test
    public void methodSubSequenceTest(){
        stringReverseOrder.reverseValue("test Sub Sequence Test");
        Assert.assertEquals(stringReverseOrder.subSequence(0, 4), "tseT");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void methodReverseNullTest(){
        stringReverseOrder.reverseValue(null);
    }
}
