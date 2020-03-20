package com.cron.parser.util;

public class Range<T> {

    private T minimum;
    private T maximum;

    public static <T> Range<T> between(T minimum, T maximum) {
        return new Range<>(minimum, maximum);
    }

    private Range(T minimum, T maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public T getMinimum() {
        return minimum;
    }

    public T getMaximum() {
        return maximum;
    }
}