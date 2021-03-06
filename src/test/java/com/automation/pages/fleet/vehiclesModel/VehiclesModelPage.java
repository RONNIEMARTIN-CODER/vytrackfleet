package com.automation.pages.fleet.vehiclesModel;

import com.automation.utilities.AbstractPageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VehiclesModelPage extends AbstractPageBase {

    @FindBy(linkText = "Create Vehicles Model")
    private WebElement createVehiclesModelBtn;

    @FindBy(xpath = "(//h1)[2]")
    private  WebElement subTitle;

    @FindBy(className = "fa-cog hide-text")
    private WebElement configBtn;

    public void clickOnConfigBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(configBtn)).click();
    }

    public void clickOnCreateVehiclesModelBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(createVehiclesModelBtn)).click();
    }

    public WebElement getSubTitle(){
        return subTitle;
    }


}
