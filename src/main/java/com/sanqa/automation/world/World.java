package com.sanqa.automation.world;

import java.util.HashMap;

public class World {

    private HashMap<String, Object> container = new HashMap<String, Object>();

    public void putValue(String key, Object object) {
        container.put(key, object);
    }

    public <Type> Type getObject(String key, Class<Type> type) {
        return type.cast(container.get(key));
    }

    public Object getObject(String key) {
        return container.get(key);
    }

    public String getString(String key) {
        Object value = container.get(key);
        return null != value ? String.valueOf(value) : null;
    }

}
