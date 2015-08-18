package com.ausya.rcore.account;

import java.util.ArrayList;
import java.util.List;

public class CustomDataBean {
    private List<CustomDataFieldBean> customDataFields = new ArrayList<CustomDataFieldBean>();
    public List<CustomDataFieldBean> getCustomDataFields() {
        return customDataFields;
    }
    public void setCustomDataFields(List<CustomDataFieldBean> customDataFields) {
        if (customDataFields == null) {
            throw new IllegalArgumentException("customDataFields cannot be null");
        }
        this.customDataFields = customDataFields;
    }
}
