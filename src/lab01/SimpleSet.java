package lab01;

/**
 * Non-resizable set that can hold a maximum of 10 like objects. Elements are 
 * contained in a back-end array that can hold up to 10 elements. Implements set
 * operations to add, change, or retrieve data from the set. However, the set 
 * does not re-shift the elements (within the array). The {@code put} method is 
 * the only method that can use a <tt>null</tt> value in place of an Object, 
 * since this method is used in the {@code sort} method (from the 
 * {@code Sorting} class) to sort the elements.
 * 
 * @author    Jesus R. Mendoza
 * @param <E> Specified type of Object contained in this {@code SimpleSet}. 
 * @see       Sorting
 */

public class SimpleSet<E> 
{
    /** 
     * Back-end array to store the elements of this SimpleSet.
     */
    private Object[] elements;
    
    /**
     * The size of the SimpleSet (the number of elements it contains).
     */
    private int size;
    
    /**
     * Constructs an empty SimpleSet (with maximum capacity of 10). 
     */    
    public SimpleSet() 
    {
        this.elements = new Object[10];
        size = 0;
    }
    
    /**
     * Constructs a SimpleSet with the specified elements, in the order they are
     * listed.
     * 
     * @param   elems  coma separated elements that are to be placed in the set
     * @throws  NotEnoughSpaceException if more than 10 elements are used to
     *          instantiate a set
     * @throws  DuplicateItemException if duplicate(s) of an element is/are 
     *          found in  he set during instantiation
     */
    public SimpleSet(E ... elems)
    {
        if(elems.length > 10) 
            throw new NotEnoughSpaceException("Cannot instantiate with more than 10 elements");
        
        for(int i = 0; i < elems.length; i++) {
            for(int j = 0; j != i && j < elems.length; j++) {
                if(elems[i].equals(elems[j]))
                    throw new DuplicateItemException("Duplicate(s) was/were found during instantiation");
            } 
        }
        
        this.elements = new Object[10];
        
        System.arraycopy(elems, 0, this.elements, 0, elems.length);
                
        size = elems.length;
    }
    
    /**
     * Appends a non-{@code null} value to the end of the set. Does not accept 
     * {@code null} values, since the last elements (if the set is not yet full)
     * are already {@code null} and the element must be checked for duplicates 
     * (which requires non-{@code null} values). Increments {@code size} by one, 
     * if element is added.
     * 
     * @param   other  element to be appended to the end of this set
     * @throws  NullPointerException if the element being added is {@code null}
     * @throws  NotEnoughSpaceException if adding to a set that is already full 
     * @throws  DuplicateItemException if the element to be added is already in 
     *          the set
     */    
    public void add(E other) 
    {
        if(other == null)
            throw new NullPointerException();
        
        if(size == 10)
            throw new NotEnoughSpaceException("Set is already full");
        
        if(this.contains(other)) 
            throw new DuplicateItemException("Item already exists in the set");
        
        this.elements[size] = other;
        size++;
    }
    
    /**
     * Checks if specified element already exists in this set.
     * 
     * @param   other  element to be checked
     * @return  {@code true} if the specified element is already in this set
     */
    public boolean contains(E other) 
    {        
        if(size > 0) 
        {
            for(int i = 0; i < size; i++) 
            {
                if(other.equals(elements[i]))
                    return true;
            }
        }
        return false;
    }
    
    /**
     * Retrieves the element at the specified index.
     * 
     * @param   index  the index of the element to be retrieved
     * @return  the element at the specified index 
     * @throws  IndexOutOfBoundsException if the specified index is outside the 
     *          bounds of zero and the {@code size} of this set
     */ 
    public E get(int index) 
    {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return (E) elements[index];
    }
    
    /**
     * Overwrites the existing element, at the specified index, with the 
     * specified element. Allows the placement and replacement of {@code null} 
     * values to simplify the {@code sort} method in the {@code Sorting} class.
     * 
     * @param  index  the index of the element that will be overwritten
     * @param  other  the element that will replace the existing element
     * @throws IndexOutOfBoundsException if the specified index is outside the 
     *         bounds of zero and the {@code size} of this set
     * @throws DuplicateItemException if the element to be added is already in 
     *         the set
     * @see    Sorting#sort(lab01.SimpleSet) 
     */
    public void put(int index, E other) 
    {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        
        if(other == null) 
            elements[index] = null;
        else if(this.contains(other)) 
        {
            if(!this.get(index).equals(other))
                throw new DuplicateItemException("Item already exists in the set");
        }
        elements[index] = other;
    }
    
    /**
     * Returns the number of elements in this {@code SimpleSet}.
     * 
     * @return  the {@code size} of this {@code SimpleSet}
     */
    public int size() {
        return size;
    }
    
    /**
     * Returns a {@code String} representation of the elements in this 
     * {@code SimpleSet}.
     * 
     * @return  the String representation of the elements in this set
     */    
    @Override
    public String toString()
    {
        if(size == 0)
            return "~ Set is Empty ~";
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < size; i++) 
        {
            if(i == size-1)
                sb.append(elements[i].toString());
            else
                sb.append(elements[i].toString()).append(", ");
        }
        return sb.toString();
    }
} 
