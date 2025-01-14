package org.prog.selenium.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private String gender;
    private String nat;
    private NameDto name;
    private LocationDto location;

}
