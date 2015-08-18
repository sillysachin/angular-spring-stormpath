package com.ausya.rcore.account;

public class CustomDataFieldBean {
    private String key;
    private Object value;
    public CustomDataFieldBean(String aKey, Object aValue) {
        if (aKey == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        this.key = aKey;
        this.value = aValue;
    }
    public String getKey() {
        return key;
    }
    public Object getValue() {
        return value;
    }
}
