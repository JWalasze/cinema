package com.rest.cinemaapi.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReservationDTO {
    private ContactData contactData;

    private Long programmeId;

    private List<Long> reservedSeatsIds;

    public ReservationDTO(ContactData contactData, Long programmeId, List<Long> reservedSeatsIds) {
        this.contactData = contactData;
        this.programmeId = programmeId;
        this.reservedSeatsIds = reservedSeatsIds;
    }
}
