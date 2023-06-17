package com.virgingames.virgingamesinfo;

import com.virgingames.constants.EndPoints;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class VirginGamesSteps {

    @Step("Getting all the JAKPOT records")
    public ValidatableResponse getJackpotRecord(){
        return SerenityRest.given()
                .when()
                .get(EndPoints.GET_ALL_JACKPOT)
                .then();
    }

    @Step("Get all the jackpot whose currency is SEK")
    public ValidatableResponse getSEKcurrency(){
        return  SerenityRest.given()
                .when()
                .queryParam("currency","SEK")
                .get(EndPoints.GET_ALL_JACKPOT)
                .then();
    }
}
