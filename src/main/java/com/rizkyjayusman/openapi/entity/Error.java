package com.rizkyjayusman.openapi.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Error {
    private String status;
    private String message;
}
