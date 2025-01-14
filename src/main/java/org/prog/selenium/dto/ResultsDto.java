package org.prog.selenium.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultsDto {
    private List<PersonDto> results;

    public List<PersonDto> getResults() {
        return results;
    }
    public void setResults (List<PersonDto> results){
        this.results= results;
    }

}
