package idv.matt.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import idv.matt.dto.RegisterDto;

@RestController
public class RegisterController {

    private static final Logger log = LoggerFactory.getLogger(RegisterController.class.getName());

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> registerApi(@RequestBody RegisterDto registerDto) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(registerDto);

        if (StringUtils.isAnyBlank(registerDto.getMemberAccount(), registerDto.getMemberPassword())) {
            return ResponseEntity.badRequest().body(jsonString);
        }
        
        return ResponseEntity.ok().body(jsonString);
    }
}
