package com.kerimsamimi.ticketingforairline.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kerimsamimi.ticketingforairline.utils.GeneralEnums;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {

    @JsonIgnore
    @Column(name = "UPDATE_DATE",insertable = false, updatable = true)
    private Date updateDate;

    @Column(name = "CREATE_DATE" ,insertable = true, updatable = false)
    @JsonIgnore
    private Date createDate;

    @Column(name = "STATUS")
    private Integer status = GeneralEnums.ACTIVE_STATUS;

    @PrePersist
    public void onCreate(){
        if (status == null) {
            status = GeneralEnums.ACTIVE_STATUS;
        }
        createDate = new Date();
    }

    @PreUpdate
    public void onUpdate(){
        updateDate = new Date();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
