package com.abede.model;

import org.graalvm.nativeimage.c.struct.UniqueLocationIdentity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.*;
import java.util.Date;


@Entity
public class User {
    @Id
    @SequenceGenerator(name = "sequenceUserId",
    sequenceName = "user_generator",
    initialValue = 1)
    @GeneratedValue(generator = "sequenceUserId", strategy = GenerationType.SEQUENCE)
    private Integer user_id;

    private String name;

    private String placeBd;

    private String email;

    private Date dateBd;

    private String password;

    private String role;

    private Boolean status;

    private Integer createdBy;

    private Date createdDate;

    private Integer updateBy;

    private Date updateDate;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceBd() {
        return placeBd;
    }

    public void setPlaceBd(String placeBd) {
        this.placeBd = placeBd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateBd() {
        return dateBd;
    }

    public void setDateBd(Date dateBd) {
        this.dateBd = dateBd;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
