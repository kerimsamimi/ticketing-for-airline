package com.kerimsamimi.ticketingforairline.dto;

import java.io.Serializable;

public class BaseDto implements Serializable {
    private static final long serialVersionUID = 9216107700514073589L;

    private String updateDate;

    private String createDate;

    private Integer status;

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
