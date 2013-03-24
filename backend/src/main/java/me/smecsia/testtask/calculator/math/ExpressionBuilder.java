package me.smecsia.testtask.calculator.math;

import me.smecsia.testtask.calculator.backend.to.*;

/**
 * @author Ilya Sadykov
 */
public class ExpressionBuilder {

    public Expression expression(Binary binary) {
        Expression res = new Expression();
        res.setBinary(binary);
        return res;
    }

    public Expression expression(double value) {
        Expression res = new Expression();
        res.setNumber(value);
        return res;
    }

    public Left left(Expression expr) {
        Left res = new Left();
        res.setExpression(expr);
        return res;
    }

    public Left left(Binary bin) {
        Left res = new Left();
        res.setBinary(bin);
        return res;
    }

    public Left left(double number) {
        Left res = new Left();
        res.setNumber(number);
        return res;
    }

    public Right right(Expression expr) {
        Right res = new Right();
        res.setExpression(expr);
        return res;
    }

    public Right right(Binary bin) {
        Right res = new Right();
        res.setBinary(bin);
        return res;
    }

    public Right right(double number) {
        Right res = new Right();
        res.setNumber(number);
        return res;
    }

    public Binary binary(Left left, String operator, Right right) {
        Binary res = new Binary();
        res.setLeft(left);
        res.setRight(right);
        res.setOperator(operator);
        return res;
    }

    public static Expression sample() {
        ExpressionBuilder exp = new ExpressionBuilder();
        return exp.expression(
                exp.binary(
                        exp.left(
                                1.0
                        ),
                        "+",
                        exp.right(
                                exp.binary(
                                        exp.left(2.0),
                                        "*",
                                        exp.right(
                                                exp.expression(
                                                        exp.binary(
                                                                exp.left(3.0),
                                                                "-",
                                                                exp.right(4.0)
                                                        )
                                                )

                                        )
                                )
                        )
                )
        );
    }
}
