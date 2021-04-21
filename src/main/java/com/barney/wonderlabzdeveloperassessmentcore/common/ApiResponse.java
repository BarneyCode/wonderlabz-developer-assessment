package com.barney.wonderlabzdeveloperassessmentcore.common;

import lombok.Data;

/**
 * Project Name: wonderlabz-developer-assessment-core
 * Developer   : bkatakwa
 * Date        : 21/4/2021
 * Time        : 22:12
 */
@Data
public class ApiResponse<T> {
    private int status;
    private ApiMessage message;
    private T body;
    public ApiResponse(int status, ApiMessage message) {
        this.status = status;
        this.message = message;
    }

    public ApiResponse(int status, ApiMessage message, T body) {
        this.status = status;
        this.message = message;
        this.body = body;
    }

    public ApiResponse(int status, T body) {
        this.status = status;
        this.body = body;
    }
}
