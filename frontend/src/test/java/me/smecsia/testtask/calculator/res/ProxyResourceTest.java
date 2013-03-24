package me.smecsia.testtask.calculator.res;

import me.smecsia.testtask.calculator.client.*;
import me.smecsia.testtask.frontend.test.IntegrationTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * @author Ilya Sadykov
 */
@Category(IntegrationTest.class)
public class ProxyResourceTest {

    @Test
    public void testClient() {
        ProxyResource proxy = new ProxyResource();
        Expression expr = new Expression();
        Binary binary = new Binary();
        Left left = new Left();
        left.setNumber(20.0);
        Right right = new Right();
        right.setNumber(10.0);
        binary.setLeft(left);
        binary.setRight(right);
        binary.setOperator("+");
        expr.setBinary(binary);
        Result res = proxy.calc(Localhost.BASE_URI.toString(), expr);
        assertTrue("Result must be success", res.isSuccess());
        assertEquals("Result value must be 30", 30.0, res.getData());
    }
}
