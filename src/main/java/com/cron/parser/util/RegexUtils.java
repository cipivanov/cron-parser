package com.cron.parser.util;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

    private RegexUtils() {
    }

    public static Optional<String> getFirstMatch(final String input, final String regexPattern) {
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(input);

        return matcher.find() ? Optional.of(matcher.group()) : Optional.empty();
    }

    public static Optional<String> getMatchGroup(final String input, final String regexPattern,
                                                 final Integer matchGroup) {
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(input);

        return matcher.find() ? Optional.of(matcher.group(matchGroup)) : Optional.empty();
    }
}