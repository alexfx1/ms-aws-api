package com.business.aws.studs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "USUARIO", schema = "pedidos")
@Getter
@Setter
@ToString
public class User {

    @Id
    @Column(name = "usuario_id")
    private Integer userId;

    @Column(name = "login")
    private String login;

    @Column(name = "admin")
    private Boolean admin;

    @Column(name = "email")
    private String email;

}
