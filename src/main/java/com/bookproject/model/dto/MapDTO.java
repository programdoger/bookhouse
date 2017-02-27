package com.bookproject.model.dto;

/**
 * Created by Administrator on 2017/2/26.
 */
public class MapDTO {
    private String key;
    private String value;

    public MapDTO() {
    }

    public MapDTO(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "章节名："+key+"\tURL："+value;
    }
}
