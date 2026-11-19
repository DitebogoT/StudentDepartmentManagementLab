package org.ditebogo.practical2springboot.Exceptions;

public class ResourceNotFoundException extends RuntimeException {

    //Whenever a service throws ResourceNotFoundException, Spring will return HTTP 404 Not Found
    public ResourceNotFoundException(String message) {
        super(message);
    }
}