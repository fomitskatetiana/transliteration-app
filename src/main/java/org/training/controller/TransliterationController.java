package org.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.training.service.TransliterationService;

import java.util.Map;

@RestController
public class TransliterationController {
    private final TransliterationService transliterationService;

    @Autowired
    public TransliterationController (TransliterationService transliterationService) {
        this.transliterationService = transliterationService;
    }

    @RequestMapping(method = RequestMethod.POST)
    Map<String, String> transliterate(@RequestParam String names) {
        return transliterationService.convertUkrainianToEnglish(names);
    }

    @RequestMapping(method = RequestMethod.GET)
    String greet() {
        return "Welcome to transliteration service";
    }

}
