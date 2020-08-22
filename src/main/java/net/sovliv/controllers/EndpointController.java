package net.sovliv.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/endpoint")
public class EndpointController {
    /**
     * Logger
     */
    private static Logger logger = LoggerFactory.getLogger(EndpointController.class);

    /**
     * HashMap для хранения текущего состояния результата
     */
    private Map<Integer, String> result = new HashMap<>();

    /**
     * Метод, принимающий get-запрос, в параметре запроса
     * передается на вход строка, парсит ее поэлементно и увеличивает каждое значение на еденицу
     * @param str входящяя строка
     * @return ResponseEntity, которая содержит тело и http status code
     */
    @GetMapping("/endpointA")
    public ResponseEntity endpointA(@RequestParam(value = "number", required = false) String str) {
        Map<Integer, String> response = new HashMap<>();
        Map<Integer, String> inputNumbers = new HashMap<>();
        int key = 1;
        char[] chars = str.toCharArray();
        for (char c : chars) {
            int x = Character.getNumericValue(c);
            inputNumbers.put(key, String.valueOf(x));
            response.put(key, String.valueOf(++x));
            key++;
        }
        result = response;
        if (result.isEmpty()) {
            logger.warn("*** LOGGER: result is empty! ***");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } else {
            logger.info("*** LOGGER: all numbers got: " + inputNumbers + ", and changed to: " + result + " ***");
            return new ResponseEntity(result, HttpStatus.OK);
        }
    }

    /**
     * Принимает на вход post-запрос
     * @param n в теле запроса передается на вход целое число
     * @return ResponseEntity, которая содержит тело и http status code
     */
    @PostMapping("/endpointB")
    public ResponseEntity endpointB(@RequestParam(value = "number", required = false) Integer n) {
        logger.info("*** LOGGER: first number is: " + result.get(1) + ", all numbers is: " + result + " ***");
        result.put(1, String.valueOf(n));
        logger.info("*** LOGGER: first number changed to new: " + result.get(1) + ", all numbers is: " + result + " ***");
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
