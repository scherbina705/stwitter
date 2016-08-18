package com.stwitter.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.LocalDate;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by A.Shcherbina
 * on 24.07.2016.
 */
public class PersonDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;
    private String birthday;
    private Set<Long> hobbiesId = new HashSet<>();

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Set<Long> getHobbiesId() {
        return hobbiesId;
    }

    public void setHobbiesId(Set<Long> hobbiesId) {
        this.hobbiesId = hobbiesId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PersonDto personDto = (PersonDto) o;

        return new EqualsBuilder()
                .append(id, personDto.id)
                .append(firstName, personDto.firstName)
                .append(lastName, personDto.lastName)
                .append(email, personDto.email)
                .append(login, personDto.login)
                .append(password, personDto.password)
                .append(birthday, personDto.birthday)
                .append(hobbiesId, personDto.hobbiesId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(firstName)
                .append(lastName)
                .append(email)
                .append(login)
                .append(password)
                .append(birthday)
                .append(hobbiesId)
                .toHashCode();
    }
}
