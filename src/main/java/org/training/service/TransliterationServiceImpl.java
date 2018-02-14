package org.training.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class TransliterationServiceImpl implements TransliterationService {

    private static final String UKRAINIAN_TO_ENGLISH_TRANSLITERATION = "ukrainian_to_english";
    private static final Pattern NON_ALPHABETIC_SYMBOLS_PATTERN = Pattern.compile("[^А-Яа-яїіє]");

    @Override
    public Map<String, String> convertUkrainianToEnglish(String wordsToConvert) {
        String[] words = wordsToConvert.split(" ");
        return Arrays.stream(words)
                .collect(Collectors.toMap(word -> word,
                        this::convertUkrainianToEnglishWord));
    }

    private String convertUkrainianToEnglishWord(String name) {
        ResourceBundle bundle = PropertyResourceBundle.getBundle(UKRAINIAN_TO_ENGLISH_TRANSLITERATION);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            String currentSymbol = name.substring(i, i + 1);
            Matcher matcher = NON_ALPHABETIC_SYMBOLS_PATTERN.matcher(currentSymbol);
            result.append(matcher.matches() ? currentSymbol : bundle.getString(currentSymbol));
        }
        return result.toString();
    }
}
