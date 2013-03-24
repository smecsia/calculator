package me.smecsia.testtask.calculator.math;

import me.smecsia.testtask.calculator.backend.to.*;

/**
 * @author Ilya Sadykov
 */
public class ExpressionEvaluator {

    public double evaluate(Unary unary) {
        String operator = unary.getOperator();
        if (operator.equals("+")) {
            return evaluate(unary.getExpression());
        } else if (operator.equals("-")) {
            return -evaluate(unary.getExpression());
        }
        throw new EvaluateException("Unknown operator:  " + unary.getOperator());
    }

    public double evaluate(Operand op) {
        if (op.getExpression() != null) {
            return evaluate(op.getExpression());
        } else if (op.getBinary() != null) {
            return evaluate(op.getBinary());
        } else if (op.getUnary() != null) {
            return evaluate(op.getUnary());
        }
        return op.getNumber();
    }

    public double evaluate(Binary binary) {
        String operator = binary.getOperator();
        double left = evaluate(binary.getLeft());
        double right = evaluate(binary.getRight());
        if (operator.equals("+")) {
            return left + right;
        } else if (operator.equals("-")) {
            return left - right;
        } else if (operator.equals("/")) {
            return left / right;
        } else if (operator.equals("*")) {
            return left * right;
        }
        throw new EvaluateException("Unknown operator: " + operator);
    }

    public double evaluate(Expression expression) {
        if (expression.getBinary() != null) {
            return evaluate(expression.getBinary());
        }
        return expression.getNumber();
    }
}
