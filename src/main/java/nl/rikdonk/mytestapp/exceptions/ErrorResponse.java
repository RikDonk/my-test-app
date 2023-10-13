package nl.rikdonk.mytestapp.exceptions;

import java.time.LocalDateTime;

public class ErrorResponse {
    private int status;
    private String message;

    private LocalDateTime timeStamp;

    public ErrorResponse() {
    }

    public ErrorResponse(int status, String message, LocalDateTime timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }


}
