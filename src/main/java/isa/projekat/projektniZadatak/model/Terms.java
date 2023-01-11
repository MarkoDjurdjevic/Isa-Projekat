package isa.projekat.projektniZadatak.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table
public class Terms {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(columnDefinition = "text")
    private Long id;

    private String date,time;

    private int during;

//    private String users;

    public Terms(Long id, String date, String time, int during, String users) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.during = during;
        //this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getDuring() {
        return during;
    }

    public void setDuring(int during) {
        this.during = during;
    }
//
//    public String getUsers() {
//        return users;
//    }
//
//    public void setUsers(String users) {
//        this.users = users;
//    }





}
