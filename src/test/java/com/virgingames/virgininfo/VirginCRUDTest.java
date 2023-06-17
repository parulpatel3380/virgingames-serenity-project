package com.virgingames.virgininfo;

import com.virgingames.testbase.TestBase;
import com.virgingames.virgingamesinfo.VirginGamesSteps;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasEntry;

@RunWith(SerenityRunner.class)
public class VirginCRUDTest extends TestBase {
    static ValidatableResponse response;

    @Steps
    VirginGamesSteps virginGamesSteps;

    @WithTag("VirginGames::SMOKE")
    @Title("Get All the record of JACKPOT info of currency SEK")
    @Test
    public void test001(){
        response = virginGamesSteps.getSEKcurrency().statusCode(200).log().all();

    }

    @WithTag("studentfeature::REGRESSION")
    @Title("Verify the id is :309 and name : virgingamessession of JACKPOT info ")
    @Test
    public void test002(){
        response = virginGamesSteps.getSEKcurrency().statusCode(200).log().all();
        HashMap<String, ?> JackpotRecord = response.extract().path("data.pots[1]");
        Assert.assertThat(JackpotRecord,hasEntry("currency","SEK"));
        Assert.assertThat(JackpotRecord,hasEntry("name","virgingamessession"));

    }
}
