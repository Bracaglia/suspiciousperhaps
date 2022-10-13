package com.samanthabracaglia.bundleofjoy.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "babynames")
public class BabyName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 3, max = 200, message = "Name must be at least 3 characters long and must not exceed 200 characters")
    private String name;
    //////////////////////////////////////////////////////////////////////////////
    private String gender;
    //////////////////////////////////////////////////////////////////////////////


    @NotNull
    @Size(min = 3, max = 200, message = "Origin must be at least 3 characters long and must not exceed 200 characters")
    private String origin;
    @NotNull
    @Size(min = 3, max = 200, message = "Meaning must be at least 3 characters long and must not exceed 200 characters")
    private String meaning;

    //RELATIONSHIP

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name="user_id")
    private User user;
    /////////////////////////////////!NO ARGUMENT CONSTRUCTORS!////////////////////////////////////////////////////////
    public BabyName(){}
    /////////////////////////////////!GETTERS AND SETTERS!////////////////////////////////////////////////////////

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//////////////////////////////////////////////////////////////////////////////
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
//////////////////////////////////////////////////////////////////////////////
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
