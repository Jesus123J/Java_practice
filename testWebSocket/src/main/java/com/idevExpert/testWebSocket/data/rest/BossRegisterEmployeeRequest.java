package com.idevExpert.testWebSocket.data.rest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BossRegisterEmployeeRequest {

    private String name;
    private String lastname;
    private String motherLastname;
    private String email;
    private String cellphone;
    private String dni;
    private Integer role;

}
