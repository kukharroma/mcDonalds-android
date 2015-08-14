package com.mlsdev.mcdonalds.cache.serializer;

/**
 * Created by roma on 29.05.15.
 */
public interface Serializer<T> {

    String serialize(T t);
    T deserialize(String json);
}
