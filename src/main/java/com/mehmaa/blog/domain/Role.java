package com.mehmaa.blog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

/**
 * <p>
 * Role entity class
 * </p>
 */
@Entity
@Table(name = "ROLE")
public class Role {

    @Id
    @Column(name = "id", nullable = false, unique = true, length = 20)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private Long id;

    @Size(max = 100)
    @Column(name = "roleName", nullable = false, unique = true)
    private String roleName;

    public Role() {
    }

    /** GETTERS/SETTERS **/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
