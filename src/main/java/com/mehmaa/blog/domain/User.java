package com.mehmaa.blog.domain;

import static javax.persistence.CascadeType.PERSIST;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.google.common.base.Objects;

/**
 * <p>
 * User entity class
 * </p>
 */
@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "id", nullable = false, unique = true, length = 20)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private Long id;

    @Size(max = 100)
    @Column(name = "firstName", nullable = true, unique = false)
    private String firstName;

    @Size(max = 100)
    @Column(name = "lastName", nullable = true, unique = false)
    private String lastName;

    @Size(max = 100)
    @Column(name = "password", nullable = false, unique = false)
    private String password;

    @Size(max = 100)
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "isEnabled", nullable = true, unique = false)
    private Boolean isEnabled;

    @JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_role"))
    @ManyToMany(cascade = PERSIST)
    private List<Role> roles = new ArrayList<Role>();

    public User() {
    }

    /** GETTERS/SETTERS **/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    // -------------- //
    // Support method //
    // -------------- //

    @Override
    public String toString() {
        return Objects.toStringHelper(this) //
                .add("id", getId()) //
                .add("firstName", getFirstName()) //
                .add("lastName", getLastName()) //
                .add("email", getEmail()) //
                .add("password", getPassword()) //
                .add("isEnabled", getIsEnabled()) //
                .toString();
    }

    @Transient
    public List<String> getRoleNames() {
        List<String> roleNames = new ArrayList<String>();

        for (Role role : getRoles()) {
            roleNames.add(role.getRoleName());
        }

        return roleNames;
    }

}
