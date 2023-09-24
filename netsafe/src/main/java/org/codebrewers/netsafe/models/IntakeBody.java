package org.codebrewers.netsafe.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class IntakeBody implements Serializable {
    @JsonProperty("intakeUrl")
    private String intakeUrl;


    public String getIntakeUrl() {
        return intakeUrl;
    }

    public void setIntakeUrl(String intakeUrl) {
        this.intakeUrl = intakeUrl;
    }

    @Override
    public String toString() {
        return "IntakeBody{" +
                "intakeUrl='" + intakeUrl + '\'' +
                '}';
    }
}
