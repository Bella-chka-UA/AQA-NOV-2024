package org.prog.selenium.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {
    private String city;
    private String state;
    private String country;
    private String postcode;
    private StreetDto street;
    private CoordinatesDto coordinates;
    private TimezoneDto timezone;
}
