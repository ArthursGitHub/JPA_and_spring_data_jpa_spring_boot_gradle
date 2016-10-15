package org.learn.bookpub.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Captures pricing for room categories.
 *
 * @author Ludovic Dewailly
 */
@XmlType
public class Pricing {

    private long id;
    private PricingModel pricingModel;
    private Double priceGuest1;
    private Double priceGuest2;
    private Double priceGuest3;

    private Pricing() {
        // required for Hibernate
    }

    public Pricing(PricingModel pricingModel) {
        if (pricingModel == null) {
            throw new IllegalArgumentException("pricingModel");
        }
        this.pricingModel = pricingModel;
    }

    @XmlElement
    public long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    @XmlElement
    public PricingModel getPricingModel() {
        return pricingModel;
    }

    public void setPricingModel(PricingModel pricingModel) {
        if (pricingModel == null) {
            throw new IllegalArgumentException("pricingModel");
        }
        this.pricingModel = pricingModel;
    }

    @XmlElement
    public Double getPriceGuest1() {
        return priceGuest1;
    }

    public void setPriceGuest1(Double priceGuest1) {
        this.priceGuest1 = priceGuest1;
    }

    @XmlElement
    public Double getPriceGuest2() {
        return priceGuest2;
    }

    public void setPriceGuest2(Double priceGuest2) {
        this.priceGuest2 = priceGuest2;
    }

    @XmlElement
    public Double getPriceGuest3() {
        return priceGuest3;
    }

    public void setPriceGuest3(Double priceGuest3) {
        this.priceGuest3 = priceGuest3;
    }
}
