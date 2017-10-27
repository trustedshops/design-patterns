package com.trustedshops.examples.javaDesignPatterns.utils.statistics;

import java.util.*;

public class MeasureGroup {
    private final Map<String, Long> values = new HashMap<>();

    public void add(String key) {
        if(values.containsKey(key)) {
            Long count = values.get(key);
            values.put(key, count + 1);
        }
        else {
            values.put(key, 1L);
        }
    }

    public Collection<String> getKeys() {
        List<String> result = new ArrayList<>(values.keySet()); // return only a newClone of the values;
        Collections.sort(result);
        return result;
    }

    public long getCount(String key) {
        Long count = values.get(key);
        if(count == null) {
            return 0;
        }
        return count;
    }

    @Override
    public String toString() {
        return "MeasureGroup{" +
                "values=" + values +
                '}';
    }
}
