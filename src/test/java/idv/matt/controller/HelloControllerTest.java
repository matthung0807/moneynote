package idv.matt.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import idv.matt.application.MoneynoteApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { MoneynoteApplication.class })
public class HelloControllerTest {

  @Autowired
  HelloController helloController;

  @Test
  public void testHelloReturnExpectedString() {
    final String expected = "hello moneynote";
    final String actual = helloController.hello();
    assertEquals(expected, actual);
  }

  @Test
  public void testHelloReturnUnexceptedString() {
    final String expected = "hello";
    final String actual = helloController.hello();
    assertNotEquals(expected, actual);
  }

}
