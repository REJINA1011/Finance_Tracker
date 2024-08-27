package com.internship.users.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataResponse {

    private String message;
    private Object data;
}
