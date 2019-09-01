package test;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddImplementationTest {

    @Test
    public void testAdd() {
        //given
        AddImplementation addImplementation = new AddImplementation();

        // when
        int wynik = addImplementation.add(2, 2);

        // then
        Assert.assertEquals(4, wynik);
    }
}