package com.my.integration.cucumber.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

/**
 * @description:
 * @author: Lai Haimeng
 * @date: 2023/12/21
 */
public class PrettyCucumberReport {
    public void generateCucumberReport() {
        File reportOutputDirectory = new File("target");
        List<String> jsonFiles = new ArrayList<>();
        //Cucumber测试结果Json文件的位置
        //from:  @ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "json:target/cucumberReportJsonFiles/cucumber.json")
        jsonFiles.add("target/cucumber-report.json");


        String buildNumber = "1";
        String projectName = "my-integration-test";
        boolean runWithJenkins = false;
        boolean parallelTesting = false;

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);

        // optional configuration
//        configuration.setParallelTesting(parallelTesting);
//        configuration.setRunWithJenkins(runWithJenkins);
        configuration.setBuildNumber(buildNumber);
        // optionally add metadata on main page
        configuration.addClassifications("Platform", "Windows");
        configuration.addClassifications("Component", "API Test");
        configuration.addClassifications("Version", "1.0.0");

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable reportable = reportBuilder.generateReports();
    }
}
