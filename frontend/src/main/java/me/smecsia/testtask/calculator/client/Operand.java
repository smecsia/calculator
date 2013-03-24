
package me.smecsia.testtask.calculator.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Operand complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Operand">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://calculator}Expression" minOccurs="0"/>
 *         &lt;element ref="{http://calculator}Binary" minOccurs="0"/>
 *         &lt;element ref="{http://calculator}Unary" minOccurs="0"/>
 *         &lt;element name="Number" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Operand", propOrder = {
    "expression",
    "binary",
    "unary",
    "number"
})
@XmlSeeAlso({
    Right.class,
    Left.class
})
public class Operand {

    @XmlElement(name = "Expression")
    protected Expression expression;
    @XmlElement(name = "Binary")
    protected Binary binary;
    @XmlElement(name = "Unary")
    protected Unary unary;
    @XmlElement(name = "Number")
    protected Double number;

    /**
     * Gets the value of the expression property.
     * 
     * @return
     *     possible object is
     *     {@link Expression }
     *     
     */
    public Expression getExpression() {
        return expression;
    }

    /**
     * Sets the value of the expression property.
     * 
     * @param value
     *     allowed object is
     *     {@link Expression }
     *     
     */
    public void setExpression(Expression value) {
        this.expression = value;
    }

    /**
     * Gets the value of the binary property.
     * 
     * @return
     *     possible object is
     *     {@link Binary }
     *     
     */
    public Binary getBinary() {
        return binary;
    }

    /**
     * Sets the value of the binary property.
     * 
     * @param value
     *     allowed object is
     *     {@link Binary }
     *     
     */
    public void setBinary(Binary value) {
        this.binary = value;
    }

    /**
     * Gets the value of the unary property.
     * 
     * @return
     *     possible object is
     *     {@link Unary }
     *     
     */
    public Unary getUnary() {
        return unary;
    }

    /**
     * Sets the value of the unary property.
     * 
     * @param value
     *     allowed object is
     *     {@link Unary }
     *     
     */
    public void setUnary(Unary value) {
        this.unary = value;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setNumber(Double value) {
        this.number = value;
    }

}
