package net.sovliv.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/endpoint")
public class EndpointController {
    private static Logger logger = LoggerFactory.getLogger(EndpointController.class);
    private List<Integer> result = new ArrayList<>();

    @GetMapping("/endpointA")
    public ResponseEntity endpointA(@RequestParam("number") String str) {
        List<Integer> response = new ArrayList<>();
        List<Integer> inputNumbers = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            int i = Character.getNumericValue(c);
            inputNumbers.add(i);
            response.add(++i);
        }
        result = response;
        logger.info("all numbers got: " + inputNumbers + ", and changed to: " + result);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/endpointB")
    public ResponseEntity endpointB(@RequestParam("number") Integer n) {
        List<Integer> response = new ArrayList<>();
        response.add(n);
        result = response;
        logger.info("all numbers changed to new: " + result);
        return new ResponseEntity(HttpStatus.OK);
    }
}
