package com.wisdom.dataSource;

public enum DataSourceEnum {

    eipsupplier("eipsupplier");


    private String value;

    DataSourceEnum(String value) {
            this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
