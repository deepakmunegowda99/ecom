package com.ecom.ecommerce.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.ecom.ecommerce.model.audit.DateAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "sessions")
public class Session extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    @NotBlank
    private String usersystemid;

    @NotNull
    private Integer loggedin;

    @NotNull
    private Long loggedintime;

    @NotNull
    private Long loggedouttime;

    public Session() {
    }

    public Session(User user, String usersystemid, Integer loggedin, Long loggedintime, Long loggedouttime) {
        this.user = user;
        this.usersystemid = usersystemid;
        this.loggedin = loggedin;
        this.loggedintime = loggedintime;
        this.loggedouttime = loggedouttime;
    }

    public Session(Long sessionId, User user, String usersystemid, Integer loggedin, Long loggedintime,
            Long loggedouttime) {
        this.sessionId = sessionId;
        this.user = user;
        this.usersystemid = usersystemid;
        this.loggedin = loggedin;
        this.loggedintime = loggedintime;
        this.loggedouttime = loggedouttime;
    }

    public Long getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getusersystemid() {
        return this.usersystemid;
    }

    public void setusersystemid(String usersystemid) {
        this.usersystemid = usersystemid;
    }

    public Integer getloggedin() {
        return this.loggedin;
    }

    public void setloggedin(Integer loggedin) {
        this.loggedin = loggedin;
    }

    public Long getloggedintime() {
        return this.loggedintime;
    }

    public void setloggedintime(Long loggedintime) {
        this.loggedintime = loggedintime;
    }

    public Long getloggedouttime() {
        return this.loggedouttime;
    }

    public void setloggedouttime(Long loggedouttime) {
        this.loggedouttime = loggedouttime;
    }

    public Session sessionId(Long sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    public Session user(User user) {
        this.user = user;
        return this;
    }

    public Session usersystemid(String usersystemid) {
        this.usersystemid = usersystemid;
        return this;
    }

    public Session loggedin(Integer loggedin) {
        this.loggedin = loggedin;
        return this;
    }

    public Session loggedintime(Long loggedintime) {
        this.loggedintime = loggedintime;
        return this;
    }

    public Session loggedouttime(Long loggedouttime) {
        this.loggedouttime = loggedouttime;
        return this;
    }

}