package lab01;

/**
 * Thrown to indicate that an instance of {@code SimpleSet} has reached its
 * maximum capacity of 10 elements.
 * 
 * @author  Jesus R. Mendoza
 * @see     SimpleSet
 */
public class NotEnoughSpaceException extends RuntimeException 
{   
    /**
     * Constructs a {@code NotEnoughSpaceException} without a detail message. 
     */
    public NotEnoughSpaceException() {
        super();
    }
    
    /**
     * Constructs a {@code NotEnoughSpaceException} with a detail message.
     * 
     * @param msg the detail message
     */
    public NotEnoughSpaceException(String msg) {
        super(msg);
    }     
}
