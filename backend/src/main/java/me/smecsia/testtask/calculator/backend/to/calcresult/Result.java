
package me.smecsia.testtask.calculator.backend.to.calcresult;

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
 *         &lt;element ref="{http://calcresult}Data"/>
 *         &lt;element ref="{http://calcresult}Message"/>
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
    "data",
    "message"
})
@XmlRootElement(name = "Result")
public class Result {

    @XmlElement(name = "Data")
    protected double data;
    @XmlElement(name = "Message", required = true)
    protected String message;

    /**
     * Gets the value of the data property.
     * 
     */
    public double getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     */
    public void setData(double value) {
        this.data = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

}
