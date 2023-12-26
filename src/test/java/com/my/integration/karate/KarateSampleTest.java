package com.my.integration.karate;

import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.AfterAll;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description:
 * @author: Lai Haimeng
 * @date: 2023/12/20
 */
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class KarateSampleTest {

    @Karate.Test
    Karate testSample() {
        return Karate.run("classpath:com/my/integration/karate").relativeTo(getClass()).outputCucumberJson(true);
    }

    /*@Karate.Test
    Karate testTags() {
        return Karate.run("tags").relativeTo(getClass()).outputCucumberJson(true);
    }*/

    /**
     * 在跑所有测试案例之后, 调用PrettyKarateReport美化测试结果报告
     * 注意这里是: org.junit.jupiter.api.AfterAll
     */
    @AfterAll
    public static void generateReport(){
        System.out.println("run after all test: gen pretty reports");
        PrettyKarateReport prettyKarateReport = new PrettyKarateReport();
        prettyKarateReport.generateCucumberReport();
    }
}
