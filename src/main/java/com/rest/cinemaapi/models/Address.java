package com.rest.cinemaapi.models;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Address {
    String city;

    String postalCode;

    String streetName;

    String streetNumber;

    public Address() {}

    public Address(
            String city,
            String postalCode,
            String streetName,
            String streetNumber
    ) {
        this.city = city;
        this.postalCode = postalCode;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }
}
