package com.internship.user_income.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponse {
    private String message;
}
