package com.rest.cinemaapi.models;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class ContactData {
    String firstName;

    String lastName;

    String phoneNumber;

    String email;

    public ContactData() {
    }

    public ContactData(
            String firstName,
            String lastName,
            String phoneNumber,
            String email
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
