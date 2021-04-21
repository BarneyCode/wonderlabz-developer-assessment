package com.barney.wonderlabzdeveloperassessmentcore.exceptions;

/**
 * Project Name: wonderlabz-developer-assessment-core
 * Developer   : bkatakwa
 * Date        : 21/4/2021
 * Time        : 23:32
 */
public class AccountCreationException extends  RuntimeException{

    public AccountCreationException() {
    }

    public AccountCreationException(String message) {
        super(message);
    }

    public AccountCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountCreationException(Throwable cause) {
        super(cause);
    }

    public AccountCreationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
