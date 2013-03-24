
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
 *         &lt;element ref="{http://calculator}Binary" minOccurs="0"/>
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
    "binary",
    "number"
})
@XmlRootElement(name = "Expression")
public class Expression {

    @XmlElement(name = "Binary")
    protected Binary binary;
    @XmlElement(name = "Number")
    protected Double number;

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
