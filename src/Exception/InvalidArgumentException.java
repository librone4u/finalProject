package Exception;

import SupportClasses.Runner;

public class InvalidArgumentException extends RuntimeException {
    public InvalidArgumentException(String message){
        super(message);
    }
}
