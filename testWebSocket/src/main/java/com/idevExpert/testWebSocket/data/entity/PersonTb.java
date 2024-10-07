package com.idevExpert.testWebSocket.data.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "people")
@ToString
public class PersonTb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "mother_lastname")
    private String motherLastname;

    @Column(name = "email")
    private String email;

    @Column(name = "cellphone")
    private String cellphone;

    @Column(name = "dni")
    private String dni;

    @Column(name = "id_account")
    private Long idAccount;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;


}
