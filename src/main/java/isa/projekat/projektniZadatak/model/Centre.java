package isa.projekat.projektniZadatak.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor

@Entity
@Table
public class Centre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;

    private String name;

    private String street;
    private String city;
    private String country;
    private int number;
    private double longitude;
    private double latitude;
    private String description;

    private ArrayList<Terms>terms;

    private double avgGrade;

    private ArrayList<Users>administrators;

    public Centre(long id, String name, String street, String city, String country, int number, double longitude, double latitude, String description, ArrayList<Terms> terms, double avgGrade, ArrayList<Users> administrators) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.country = country;
        this.number = number;
        this.longitude = longitude;
        this.latitude = latitude;
        this.description = description;
        this.terms = terms;
        this.avgGrade = avgGrade;
        this.administrators = administrators;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Terms> getTerms() {
        return terms;
    }

    public void setTerms(ArrayList<Terms> terms) {
        this.terms = terms;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    public ArrayList<Users> getAdministrators() {
        return administrators;
    }

    public void setAdministrators(ArrayList<Users> administrators) {
        this.administrators = administrators;
    }



    //
//    @Override
//    public String toString() {
//        return "Centre{" +
//                "id=" + id +
//                ", adress='" + adress + '\'' +
//                ", description='" + description + '\'' +
//                ", avgGrade=" + avgGrade +
//                '}';
//    }


}
