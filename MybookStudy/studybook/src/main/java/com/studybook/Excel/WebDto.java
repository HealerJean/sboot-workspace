package com.studybook.Excel;

import java.util.Date;

/**
 * Created by HealerJean on 2017/4/12.
 */
public class WebDto {
    private String id;
    private String description;
    private String currentdate;


    public WebDto() {}

    public WebDto(String id, String description, String currentdate) {
        this.id = id;
        this.description = description;
        this.currentdate = currentdate;
    }

    @Override
    public String toString() {
        return "WebDto{" +
            "id='" + id + '\'' +
            ", description='" + description + '\'' +
            ", currentdate=" + currentdate +
            '}';
    }
}
