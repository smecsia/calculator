package me.smecsia.testtask.calculator.math;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Ilya Sadykov
 */
public class ExpressionEvaluatorTest {

    ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();

    @Test
    public void testEvaluator() {
        assertEquals("Result must be -1.0", -1.0, expressionEvaluator.evaluate(ExpressionBuilder.sample()));
    }

}
