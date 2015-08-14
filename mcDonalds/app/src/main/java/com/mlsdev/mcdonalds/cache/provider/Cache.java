package com.mlsdev.mcdonalds.cache.provider;

import com.mlsdev.mcdonalds.model.Timer;

/**
 * Created by roma on 29.05.15.
 */
public interface Cache {

    Timer getTimer();
    void saveTimer(Timer time);
    boolean isCached();
    void clear();

}
