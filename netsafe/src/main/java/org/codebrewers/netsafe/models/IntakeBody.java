package org.codebrewers.netsafe.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IntakeBody {
    @JsonProperty("intakeUrl")
    private String intakeUrl;


    public String getIntakeUrl() {
        return intakeUrl;
    }

    public void setIntakeUrl(String intakeUrl) {
        this.intakeUrl = intakeUrl;
    }
}
