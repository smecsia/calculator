
package me.smecsia.testtask.calculator.backend.to.calculator;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://calculator}Unary" minOccurs="0"/>
 *         &lt;element ref="{http://calculator}Number" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "unary",
    "number"
})
@XmlRootElement(name = "right")
public class Right {

    @XmlElement(name = "Unary")
    protected Unary unary;
    @XmlElement(name = "Number")
    protected Double number;

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
