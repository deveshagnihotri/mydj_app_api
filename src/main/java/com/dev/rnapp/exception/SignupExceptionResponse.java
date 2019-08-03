package com.dev.rnapp.exception;

public class SignupExceptionResponse {

    private String signupIdentifier;

    public String getSignupIdentifier() {
        return signupIdentifier;
    }

    public void setSignupIdentifier(String signupIdentifier) {
        this.signupIdentifier = signupIdentifier;
    }

    public SignupExceptionResponse(String signupIdentifier){
        this.signupIdentifier = signupIdentifier;
    }

}
