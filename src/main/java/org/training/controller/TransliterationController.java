package org.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.training.service.TransliterationService;

import java.util.Map;

@RestController
public class TransliterationController {

    private final TransliterationService transliterationService;
    private static final String PARAMETER_NAME = "names";

    @Autowired
    public TransliterationController(TransliterationService transliterationService) {
        this.transliterationService = transliterationService;
    }

    @PostMapping(params = PARAMETER_NAME)
    Map<String, String> transliterateFormData(@RequestParam String names) {
        return transliterationService.convertUkrainianToEnglish(names);
    }

    @PostMapping
    Map<String, String> transliterateJsonData(@RequestBody Map<String, String> names) {
        return transliterationService.convertUkrainianToEnglish(names.get(PARAMETER_NAME));
    }

    @RequestMapping(method = RequestMethod.GET)
    String greet() {
        return "Welcome to transliteration service";
    }

}
