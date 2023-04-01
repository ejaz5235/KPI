package net.ejazcurd.springbootcurd.model;

import lombok.Data;

import java.util.Date;


@Data
public class Kpireport {

    private String JobName;
    private int targetAge;
    Date executeddate;
    private int age;//current date - executeddate
    private int delta;//taget age - age
    private String status;

}
