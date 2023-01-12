package isa.projekat.projektniZadatak.Enums;

public enum BloodType {
  APOS("A+"),
  ANEG("A-"),
  BPOS("B+"),
  BNEG("B-"),
  ABPOS("AB+"),
  ABNEG("AB-"),
  OPOS("0+"),
  ONEG("0-");

  private final String bloodType;

  BloodType(String bloodType) {
    this.bloodType = bloodType;
  }
}
