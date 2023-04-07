package com.odinkirk.codecserver.integration.glue;

import com.odinkirk.codecserver.CodecServerApplication;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@SpringBootTest(classes = {CodecServerApplication.class,
        CucumberTestRunner.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber-reports"},
        tags = "@integration",
        features = "src/test/resources/features",
        glue = {"com.odinkirk.codecserver.integration.glue", "com.odinkirk.codecserver"},
        strict = true)
public class CucumberTestRunner {
}
