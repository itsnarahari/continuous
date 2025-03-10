package com.continuous;

import com.continuous.boot.config.JacocoExample;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JacocoTest {

    @Test
    public void valueCheck() {
        JacocoExample jacocoExample = new JacocoExample();
        String result = jacocoExample.check("Narahari");
        Assertions.assertEquals("Hello Narahari", result);
    }
}
