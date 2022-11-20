package isa.projekat.projektniZadatak.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table
public class Survey {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable=false,updatable=false)
    private Long id;
    @ManyToOne
    private Users users;
    private boolean one;
    private boolean two;
    private boolean three;
    private boolean four;
    private boolean five;
    private boolean six;
    private boolean seven;
    private boolean eight;
    private boolean nine;
    private boolean ten;
    private boolean eleven;
    private boolean twelve;
    private boolean thirteen;
    private boolean fourteen;
    private boolean fifteen;

}
