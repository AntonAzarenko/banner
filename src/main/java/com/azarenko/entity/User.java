package com.azarenko.entity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "users_id"))
    @Column(name = "roles")
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> role;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Banner> bannerList;

    public User() {
    }

    public User(Long id) {
        super(id);
    }

    public User(Long id, String name, String login, String password, boolean enabled, Role roleUser) {
        super(id);
        this.name = name;
        this.login = login;
        this.password = password;
        this.enabled = enabled;
        this.role = Collections.singleton(roleUser);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }
}
