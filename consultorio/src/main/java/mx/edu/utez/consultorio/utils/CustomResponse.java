package mx.edu.utez.consultorio.utils;

public class CustomResponse<T> {
    T data;
    boolean error;
    int statusCode;
    String message;

    public CustomResponse(T data, boolean error, int statusCode, String message) {
        this.data = data;
        this.error = error;
        this.statusCode = statusCode;
        this.message = message;
    }

    public CustomResponse() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
