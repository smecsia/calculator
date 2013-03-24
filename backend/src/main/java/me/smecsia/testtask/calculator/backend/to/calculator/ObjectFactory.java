
package me.smecsia.testtask.calculator.backend.to.calculator;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the calculator package. 
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

    private final static QName _Number_QNAME = new QName("http://calculator", "Number");
    private final static QName _Operator_QNAME = new QName("http://calculator", "operator");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: calculator
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
     * Create an instance of {@link Unary }
     * 
     */
    public Unary createUnary() {
        return new Unary();
    }

    /**
     * Create an instance of {@link Expression }
     * 
     */
    public Expression createExpression() {
        return new Expression();
    }

    /**
     * Create an instance of {@link Right }
     * 
     */
    public Right createRight() {
        return new Right();
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link Double }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://calculator", name = "Number")
    public JAXBElement<Double> createNumber(Double value) {
        return new JAXBElement<Double>(_Number_QNAME, Double.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calculator", name = "operator")
    public JAXBElement<String> createOperator(String value) {
        return new JAXBElement<String>(_Operator_QNAME, String.class, null, value);
    }

}
