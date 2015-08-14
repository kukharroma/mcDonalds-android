package com.mlsdev.mcdonalds.cache.provider.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.mlsdev.mcdonalds.cache.provider.Cache;
import com.mlsdev.mcdonalds.cache.serializer.Serializer;
import com.mlsdev.mcdonalds.cache.serializer.impl.TimerSerializerImpl;
import com.mlsdev.mcdonalds.model.Timer;

/**
 * Created by roma on 29.05.15.
 */
public class TimerCacheImpl implements Cache {

    private static final String TIMER_CACHE_PREFS_KEY = "com.mlsdev.mcdonalds.cache.provider.impl.TimeCacheImpl";
    private static final String TIMER_PREFS_KEY = "timer_pref_key";

    private SharedPreferences preferences;
    private Serializer<Timer> serializer = new TimerSerializerImpl();

    public TimerCacheImpl(Context context) {
        this.preferences = context.getSharedPreferences(TIMER_CACHE_PREFS_KEY, Context.MODE_PRIVATE);
    }

    @Override
    public void saveTimer(Timer timer) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(TIMER_PREFS_KEY, serializer.serialize(timer));
        editor.apply();
    }

    @Override
    public Timer getTimer() {
        return serializer.deserialize(preferences.getString(TIMER_PREFS_KEY, null));
    }

    @Override
    public boolean isCached() {
        return preferences.getString(TIMER_PREFS_KEY, null) != null;
    }

    @Override
    public void clear() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(TIMER_PREFS_KEY).apply();
        Log.i(this.getClass().getName(), "clear()");
    }
}
