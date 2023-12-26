package com.my.integration.karate;

import com.intuit.karate.junit5.Karate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description:
 * @author: Lai Haimeng
 * @date: 2023/12/20
 */
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Slf4j
public class KarateSampleTest {

    @Karate.Test
    Karate testSample() {
        return Karate.run(new String[]{"sample"}).relativeTo(getClass()).outputCucumberJson(true);
    }

    @Karate.Test
    Karate testTags() {
        return Karate.run("tags").relativeTo(getClass()).outputCucumberJson(true);
    }

    @AfterAll
    public static void generateReport(){
        System.out.println("run after all test: gen pretty reports");
        PrettyKarateReport prettyKarateReport = new PrettyKarateReport();
        prettyKarateReport.generateCucumberReport();
    }
    /*@Karate.Test
    Karate testSystemProperty() {
        return Karate.run("classpath:karate/tags.feature")
                .tags("@second")
                .karateEnv("e2e")
                .systemProperty("foo", "bar");
    }*/
}
