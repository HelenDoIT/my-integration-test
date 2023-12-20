package com.my.integration.cucumber;

import com.my.integration.controller.BookListController;
import com.my.integration.response.AjaxResult;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @author: Lai Haimeng
 * @date: 2023/12/20
 */
public class StepDefinitions {

    @Autowired
    private BookListController bookListController;

    private AjaxResult ajaxResult;
    private Integer status;

    @Given("api get list")
    public void api_get_list(){

    }

    @When("a request is made to endpoint")
    public void book_get_list(){
        ajaxResult = bookListController.listAllBook();
        status = (Integer) ajaxResult.get("code");
    }

    @Then("the response should have status code 200")
    public void the_response(){
        Assertions.assertEquals(200,status);
    }
}
