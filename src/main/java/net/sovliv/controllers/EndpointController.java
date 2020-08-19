package net.sovliv.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/endpoint")
public class EndpointController {
    private static Logger logger = LoggerFactory.getLogger(EndpointController.class);
    private List<Integer> result = new ArrayList<>();

    @GetMapping("/endpointA")
    public ResponseEntity endpointA(@RequestParam(value = "number", required = false) String str) {
        List<Integer> response = new ArrayList<>();
        List<Integer> inputNumbers = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            int i = Character.getNumericValue(c);
            inputNumbers.add(i);
            response.add(++i);
        }
        result = response;

        if (result.isEmpty()) {
            logger.warn("result is empty!");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } else
        logger.info("***LOGGER: all numbers got: " + inputNumbers + ", and changed to: " + result + " ***");
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/endpointB")
    public ResponseEntity endpointB(@RequestParam(value = "number", required = false) Integer n) {
        List<Integer> response = new ArrayList<>();
        logger.info("**LOGGER: all numbers is: " + result + " ***");
        response.add(n);
        result = response;
        logger.info("**LOGGER: all numbers changed to new: " + result + " ***");
        return new ResponseEntity(HttpStatus.OK);
    }
}
