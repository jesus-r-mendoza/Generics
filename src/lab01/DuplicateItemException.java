package lab01;

/**
 * Thrown to indicate that there exists a duplicate element in an instance of 
 * {@code SimpleSet}.
 * 
 * @author  Jesus R. Mendoza
 * @see     SimpleSet
 */
public class DuplicateItemException extends RuntimeException 
{
    /**
     * Constructs a {@code DuplicateItemException} without a detail message.
     */
    public DuplicateItemException() {
        super();
    }
    
    /**
     * Constructs a {@code DuplicateItemException} with a detail message.
     * 
     * @param msg the detail message 
     */
    public DuplicateItemException(String msg) {
        super(msg);
    }    
}
