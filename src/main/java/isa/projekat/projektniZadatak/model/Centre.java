package isa.projekat.projektniZadatak.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Centre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;

    private String name;
    private String adress;
    private String description;

    @OneToMany(mappedBy = "centre")
    private List<Users> users;


    private Integer avgGrade;

    public Centre() {
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

//    public Centre(long id, String name, String adress, String description, Integer avgGrade) {
//        this.id = id;
//        this.name = name;
//        this.adress = adress;
//        this.description = description;
//        this.avgGrade = avgGrade;
//    }

    public Centre(long id, String name, String adress, String description, List<Users> users, Integer avgGrade) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.description = description;
        this.users = users;
        this.avgGrade = avgGrade;
    }

    public Centre(String name, String adress, String description) {
        this.name = name;
        this.adress = adress;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(Integer avgGrade) {
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "Centre{" +
                "id=" + id +
                ", adress='" + adress + '\'' +
                ", description='" + description + '\'' +
                ", avgGrade=" + avgGrade +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
