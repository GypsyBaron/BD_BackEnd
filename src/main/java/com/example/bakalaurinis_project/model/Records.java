package com.example.bakalaurinis_project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Records {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer userid;
    private Integer foodid;
    private String type;
    private Date date;

    public Records(Integer userid, Integer foodid, String type, Date date) {
        this.userid = userid;
        this.foodid = foodid;
        this.type = type;
        this.date = date;
    }

    public Records() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userId) {
        this.userid = userId;
    }

    public Integer getFoodid() {
        return foodid;
    }

    public void setFoodid(Integer foodId) {
        this.foodid = foodId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
