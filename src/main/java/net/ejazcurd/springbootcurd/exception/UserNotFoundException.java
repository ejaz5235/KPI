package net.ejazcurd.springbootcurd.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id)
    {
        super("could not find the user with ID "+id);
    }
}
