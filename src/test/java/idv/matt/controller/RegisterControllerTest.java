package idv.matt.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import idv.matt.application.MoneynoteApplication;
import idv.matt.dto.RegisterDto;

@SpringBootTest(classes = { MoneynoteApplication.class })
public class RegisterControllerTest {

    @Autowired
    private RegisterController regsiterController;
    
    @Test
    public void testRegisterApi_200() throws JsonProcessingException {
        
        RegisterDto registerMemberDto = new RegisterDto();
        registerMemberDto.setMemberName("John");
        registerMemberDto.setMemberAccount("john@abc.com");
        registerMemberDto.setMemberPassword("12345");
        
        ResponseEntity<String> responseEntity = regsiterController.registerApi(registerMemberDto);
        
        String actualJsonString = responseEntity.getBody();
        HttpStatus actualHttpStatus = responseEntity.getStatusCode();
        String expectedJsonString = new ObjectMapper().writeValueAsString(registerMemberDto);
        HttpStatus expectedHttpStatus = HttpStatus.OK;
        
        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedHttpStatus, actualHttpStatus),
                () -> Assertions.assertEquals(expectedJsonString, actualJsonString));
    }
    
    @Test
    public void testRegisterApi_400() throws JsonProcessingException {
        
        RegisterDto registerMemberDto = new RegisterDto();
        registerMemberDto.setMemberName("John");
        ResponseEntity<String> responseEntity = regsiterController.registerApi(registerMemberDto);
        
        String actualJsonString = responseEntity.getBody();
        
        HttpStatus actualHttpStatus = responseEntity.getStatusCode();
        String expectedJsonString = new ObjectMapper().writeValueAsString(registerMemberDto);
        HttpStatus expectedHttpStatus = HttpStatus.BAD_REQUEST;
        
        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedHttpStatus, actualHttpStatus),
                () -> Assertions.assertEquals(expectedJsonString, actualJsonString));
    }
    
}
