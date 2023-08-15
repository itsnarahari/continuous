package com.test;

import com.test.boot.config.JacocoExample;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
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
