package com.example.demoWebmvcObservation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

/**
 * The type Decoupled controller.
 */
@RestController
@RequestMapping("observation")
public class WebMvcController {

    private static final Logger LOG = LoggerFactory.getLogger(WebMvcController.class);

    @PreAuthorize("hasRole('ROLE')")
    @GetMapping(path = "/unauthorized")
    public String unauthorized() {
        return "hello!";
    }

    @PreAuthorize("hasRole('ROLE1')")
    @GetMapping(path = "/accessOK")
    public String accessOK() {
        return "hello!";
    }

    @GetMapping(path = "/error500")
    public void error500() {
        throw new HttpServerErrorException(HttpStatusCode.valueOf(500));
    }
}
