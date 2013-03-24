
package me.smecsia.testtask.calculator.client;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the me.smecsia.testtask.calculator.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: me.smecsia.testtask.calculator.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Binary }
     * 
     */
    public Binary createBinary() {
        return new Binary();
    }

    /**
     * Create an instance of {@link Left }
     * 
     */
    public Left createLeft() {
        return new Left();
    }

    /**
     * Create an instance of {@link Operand }
     * 
     */
    public Operand createOperand() {
        return new Operand();
    }

    /**
     * Create an instance of {@link Expression }
     * 
     */
    public Expression createExpression() {
        return new Expression();
    }

    /**
     * Create an instance of {@link Unary }
     * 
     */
    public Unary createUnary() {
        return new Unary();
    }

    /**
     * Create an instance of {@link Right }
     * 
     */
    public Right createRight() {
        return new Right();
    }

    /**
     * Create an instance of {@link Result }
     * 
     */
    public Result createResult() {
        return new Result();
    }

}
