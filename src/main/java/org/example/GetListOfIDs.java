package org.example;

import java.util.ArrayList;

public class GetListOfIDs {
    public boolean isSuccess;
    public int errorCode;
    public String errorMessage;
    public ArrayList idList;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Object getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ArrayList getIdList() {
        return idList;
    }

    public void setIdList(ArrayList<Integer> idList) {
        this.idList = idList;
    }

    public GetListOfIDs(boolean isSuccess, int errorCode, String errorMessage, ArrayList idList) {
        this.isSuccess = isSuccess;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.idList = idList;
    }

    public GetListOfIDs() {

    }
}
