package com.mycompany.app.model.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "personnes")
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "born")
    private LocalDate born;

    @Column(name = "born_at")
    private String bornAt;

    @Column(name = "gender")
    private char gender;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Personne(String firstName, String lastName, LocalDate born, String bornAt, char gender, User user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.born = born;
        this.bornAt = bornAt;
        this.gender = gender;
        this.user = user;
    }

    public Personne() {

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBorn() {
        return this.born;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    public String getBornAt() {
        return this.bornAt;
    }

    public void setBornAt(String bornAt) {
        this.bornAt = bornAt;
    }

    public char getGender() {
        return this.gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", born='" + getBorn() + "'" +
            ", bornAt='" + getBornAt() + "'" +
            ", gender='" + getGender() + "'" +
            "}";
    }

}
