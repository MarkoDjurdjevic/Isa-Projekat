package isa.projekat.projektniZadatak.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class MedicalUsers extends Users{

   @ManyToOne
   @JoinColumn(name = "terms_id")
   private Terms medicalTerms;
}
