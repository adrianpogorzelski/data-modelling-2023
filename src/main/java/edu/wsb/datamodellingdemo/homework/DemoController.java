package edu.wsb.datamodellingdemo.homework;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/demo")
public class DemoController {

    // Zadanie 1
    @GetMapping("/time")
    LocalDateTime currentTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        return currentTime;
    }

    // Zadanie 2
    @GetMapping("/capitalize")
    String capitalize(@RequestParam String word) {
        return word.toUpperCase();
    }
}
