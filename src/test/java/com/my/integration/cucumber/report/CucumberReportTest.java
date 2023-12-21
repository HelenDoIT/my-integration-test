package com.my.integration.cucumber.report;

import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;

/**
 * @description:
 * @author: Lai Haimeng
 * @date: 2023/12/21
 */
//整合springboot
@SpringBootTest
@CucumberContextConfiguration
//cucumber 启动
@Suite
@IncludeEngines("cucumber")
/*@CucumberOptions(
        tags = {"@API"},
        features = {"src/test/resources/feature"},
        glue = {"com.my.integration"},
        plugin = {
                "pretty",
                "html:target/cucumber",
                "json:target/cucumberReportJsonFiles/cucumber-report.json"
        })*/
@SelectClasspathResource("feature")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "petty")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "json:target/cucumberReportJsonFiles/cucumber.json")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.my.integration")
public class CucumberReportTest {

    @Test
    void contextLoads(){

    }

    @AfterAll
    public static void generateReport(){
        PrettyCucumberReport prettyCucumberReport = new PrettyCucumberReport();
        prettyCucumberReport.generateCucumberReport();
    }


}
