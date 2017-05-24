package com.studybook.DateJsonFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by HealerJean on 2017/4/18.
 */
@Entity
@Table(name = "jsonformat")
public class JsonFormatTestDomain {

    //个人资料筛选器ID
    @Id
    @GenericGenerator(name = "IdGenerator", strategy = "uuid")
    @GeneratedValue(generator = "IdGenerator")
    private String id;

    //创建时间
    @CreationTimestamp
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    private LocalDateTime createdOn;

    //修改时间
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    @UpdateTimestamp
    private LocalDateTime updatedOn;

    //修改时间
    private LocalDateTime jsonFormatDate;



    public JsonFormatTestDomain() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public LocalDateTime getJsonFormatDate() {
        return jsonFormatDate;
    }

    public void setJsonFormatDate(LocalDateTime jsonFormatDate) {
        this.jsonFormatDate = jsonFormatDate;
    }
}
