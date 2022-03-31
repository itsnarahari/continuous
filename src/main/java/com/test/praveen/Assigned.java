package com.test.praveen;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Assigned {

    private String eventName;
    private String date;
    private String marketCode;
    private String destCounty;
    private String codeSales;
}
