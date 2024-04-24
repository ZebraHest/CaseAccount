package com.malteneve.caseaccount.handlers;

import com.malteneve.caseaccount.exception.ValidationException;
import com.malteneve.caseaccount.requestData.RequestData;
import com.malteneve.caseaccount.returnData.ErrorReturnData;
import com.malteneve.caseaccount.returnData.ReturnData;

public abstract class Handler<T extends RequestData, R extends ReturnData> {

    protected abstract void simpleValidation(T data) throws ValidationException;

    protected abstract void complexValidation(T data) throws ValidationException;

    public R handle(T data) {

        try {
            simpleValidation(data);
            complexValidation(data);
        } catch (ValidationException e) {
            return (R) new ErrorReturnData(e.getMessage());
        }
        
        return handleRequest(data);
    }

    protected abstract R handleRequest(T data);

    protected void isNotNull(Object object) throws ValidationException {
        if (object == null) {
            throw new ValidationException("Value can not be null");
        }
    }

    protected void isPositive(Double d) throws ValidationException {
        if (d < 0) {
            throw new ValidationException("Value can not be negative. Found " + d);
        }
    }
}
