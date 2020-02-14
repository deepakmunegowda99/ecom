package com.ecom.ecommerce.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.ecom.ecommerce.model.audit.DateAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "user_token")
public class UserToken extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    @NotBlank
    private Long sentTime;

    @NotBlank
    private Long expirationTime;

    @NotBlank
    private String tokenType;

    public UserToken() {
    }

    public UserToken(Long tokenId, User user, Long sentTime, Long expirationTime, String tokenType) {
        this.tokenId = tokenId;
        this.user = user;
        this.sentTime = sentTime;
        this.expirationTime = expirationTime;
        this.tokenType = tokenType;
    }

    public Long getTokenId() {
        return this.tokenId;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getSentTime() {
        return this.sentTime;
    }

    public void setSentTime(Long sentTime) {
        this.sentTime = sentTime;
    }

    public Long getExpirationTime() {
        return this.expirationTime;
    }

    public void setExpirationTime(Long expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getTokenType() {
        return this.tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public UserToken tokenId(Long tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    public UserToken user(User user) {
        this.user = user;
        return this;
    }

    public UserToken sentTime(Long sentTime) {
        this.sentTime = sentTime;
        return this;
    }

    public UserToken expirationTime(Long expirationTime) {
        this.expirationTime = expirationTime;
        return this;
    }

    public UserToken tokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }

}