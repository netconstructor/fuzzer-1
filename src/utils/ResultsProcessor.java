package utils;

import com.gargoylesoftware.htmlunit.WebResponse;

public class ResultsProcessor {

    public static void processWebResponse(WebResponse response) {
        if (response.getStatusCode() > 399) {
            FuzzyLogger.logError(response.getStatusCode() + ": "
                    + response.getStatusMessage());
        }

        for (String sensativeString : SensativeData.getSensativeData()) {
            if (response.getContentAsString().contains(sensativeString)) {
                FuzzyLogger.logError("Found Sensative Data: "
                        + response.getContentAsString());
            }
        }
    }

}
