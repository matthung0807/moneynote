package idv.matt.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import idv.matt.application.MoneynoteApplication;

@SpringBootTest(classes = { MoneynoteApplication.class })
public class HelloControllerTest {

    @Autowired
    HelloController helloController;

    @Test
    public void testHelloReturnExpectedString() {
        final String expected = "hello moneynote";
        final String actual = helloController.hello();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testHelloReturnUnexceptedString() {
        final String expected = "hello";
        final String actual = helloController.hello();
        Assertions.assertNotEquals(expected, actual);
    }

}
