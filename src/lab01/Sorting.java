package lab01;

/**
 * Non-instantiatable class with the purpose of sorting the elements of an 
 * instance of {@code SimpleSet}. Requires the type, parameterized in the 
 * instance of that {@code SimpleSet}, to implement the {@code Comparable<E>}
 * interface.
 * 
 * @author  Jesus R. Mendoza
 * @see     SimpleSet
 */
public final class Sorting
{
    /**
     * Prohibits the instantiation of an instance of this class.
     */
    private Sorting() {
    }
    
    /**
     * Sorts the elements of a {@code SimpleSet}, if the element type implements
     * the {@code Comparable<E>} interface.
     * 
     * @param <T>  the specified type of the elements contained within an 
     *             instance of the parameterized type of {@code SimpleSet}
     * @param list an instance of {@code SimpleSet} 
     */
    public static <T extends Comparable<T>> void sort(SimpleSet<T> list)
    {
        boolean sorted = false;
        
        if(list.size() == 0 || list.size() == 1)
            sorted = true;
        
        while(!sorted)
        {
            T temp1;
            T temp2;
            sorted = true;
            for(int i = 0; i < list.size()-1; i++) 
            {
                if(list.get(i).compareTo(list.get(1+i)) > 0)
                {
                    temp1 = list.get(i);
                    temp2 = list.get(i+1);
                    list.put(i, null);
                    list.put(i+1, null);
                    list.put(i, temp2);
                    list.put(i+1, temp1);
                    sorted = false;
                } 
            }
        }
        
    }
}
