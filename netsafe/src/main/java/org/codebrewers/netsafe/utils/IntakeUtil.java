package org.codebrewers.netsafe.utils;

import org.codebrewers.netsafe.models.Data;
import org.codebrewers.netsafe.models.IntakeAnalysisReply;

import java.util.Optional;

public class IntakeUtil {

    public static String getProcessingId(IntakeAnalysisReply intakeAnalysisReply) {
        String s = Optional.ofNullable(intakeAnalysisReply)
                .map(IntakeAnalysisReply::getData)
                .map(Data::getId)
                .filter(id -> !id.isBlank())
                .map(id ->
                        id.split("-", 3)
                )
                .map(id -> id[1])
                .get();
        return s;
    }
}
