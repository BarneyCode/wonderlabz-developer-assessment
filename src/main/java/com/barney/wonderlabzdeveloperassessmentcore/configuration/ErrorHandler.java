package com.barney.wonderlabzdeveloperassessmentcore.configuration;

import com.barney.wonderlabzdeveloperassessmentcore.WonderlabzDeveloperAssessmentCoreApplication;
import com.barney.wonderlabzdeveloperassessmentcore.common.ApiMessage;
import com.barney.wonderlabzdeveloperassessmentcore.common.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Project Name: wonderlabz-developer-assessment-core
 * Developer   : bkatakwa
 * Date        : 21/4/2021
 * Time        : 22:11
 */
@ControllerAdvice(basePackageClasses = WonderlabzDeveloperAssessmentCoreApplication.class)
@Slf4j
public class ErrorHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> exceptionHandler(Exception e) {
        log.error("Error:", e);
        ApiResponse<String> response = new ApiResponse<>(200,ApiMessage.FAILED);
        response.setBody(e.getMessage());
        return ResponseEntity.ok(response);
    }
}
