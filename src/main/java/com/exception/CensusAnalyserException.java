package com.exception;

public class CensusAnalyserException extends Throwable {
    public ExceptionType exceptionType;

    public CensusAnalyserException(ExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    public enum ExceptionType {
        FILE_NOT_FOUND
    }
}

