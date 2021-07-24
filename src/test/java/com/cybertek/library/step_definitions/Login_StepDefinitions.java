package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LibraryLoginPage;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefinitions {

    LibraryLoginPage loginPage=new LibraryLoginPage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        String url= ConfigurationReader.getProperty("lib_App_Url");
        Driver.getDriver().get(url);

    }
    @When("I login as a librarian")
    public void i_login_as_a_librarian() {

        loginPage.usernameInput.sendKeys("librarian13@library");
        loginPage.passwordInput.sendKeys("9rf6axdD");
        loginPage.signIn.click();

    }
    @When("I login as a student")
    public void i_login_as_a_student() {
        loginPage.usernameInput.sendKeys("student11@library");
        loginPage.passwordInput.sendKeys("tScBPCUr");
        loginPage.signIn.click();
    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        String actualTitle=Driver.getDriver().getTitle();
        String expectedTitle="Library";

        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }
    @When("I enter username {string}")
    public void i_enter_username(String arg0) {
       LibraryLoginPage loginPage=new LibraryLoginPage();
       loginPage.usernameInput.sendKeys(arg0);
    }

    @When("I enter password {string}")
    public void i_enter_password(String arg1) {
        loginPage.passwordInput.sendKeys(arg1);


    }
    @When("click the sign in button")
    public void click_the_sign_in_button() {
        loginPage.signIn.click();

    }
    @Then("there should be {int} users")
    public void there_should_be_users(Integer int1) {

        System.out.println(loginPage.usersCount.getText());
        String actualUsersCount=loginPage.usersCount.getText();

        String expectedUsersCount=String.valueOf(int1);

        Assert.assertEquals(actualUsersCount,expectedUsersCount);

    }


    @When("I login using {string} and {string}")
    public void iLoginUsingAndAOYKYTMJ(String arg0, String arg1) {

        loginPage.usernameInput.sendKeys(arg0);
        loginPage.passwordInput.sendKeys(arg1);
        loginPage.signIn.click();

    }
}
