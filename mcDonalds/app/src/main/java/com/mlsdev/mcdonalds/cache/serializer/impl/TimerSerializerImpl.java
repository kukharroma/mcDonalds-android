package com.mlsdev.mcdonalds.cache.serializer.impl;

import com.google.gson.Gson;
import com.mlsdev.mcdonalds.cache.serializer.Serializer;
import com.mlsdev.mcdonalds.model.Timer;

/**
 * Created by roma on 29.05.15.
 */
public class TimerSerializerImpl implements Serializer<Timer> {

    private Gson gson = new Gson();

    @Override
    public String serialize(Timer timer) {
        return  gson.toJson(timer, Timer.class);
    }

    @Override
    public Timer deserialize(String json) {
        return gson.fromJson(json, Timer.class);
    }
}
