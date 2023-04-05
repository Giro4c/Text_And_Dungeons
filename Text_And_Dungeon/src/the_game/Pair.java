package the_game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
/**
 * Class that represents a pair of value from two types U and V
 * @author Camille (HorsCo)
 *
 * @param <U> the type of the first field of the pair
 * @param <V> the type of the second field of the pair
 */
class Pair<U, V>
{
    public final U first;       // the first field of a pair
    public final V second;      // the second field of a pair
 
    // Builds a new pair with the specified values
    private Pair(U first, V second)
    {
        this.first = first;
        this.second = second;
    }
 
    @Override
    // Verifies that the object is equal to the current object or not
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
 
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
 
        Pair<?, ?> pair = (Pair<?, ?>) o;
 
        // call method "equals()" of underlying objects
        if (!first.equals(pair.first)) {
            return false;
        }
        return second.equals(pair.second);
    }
 
    @Override
    // Calculate the hash code of an object to support hash tables
    public int hashCode()
    {
        // use the hash codes of the underlying objects
        return 31 * first.hashCode() + second.hashCode();
    }
 
    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
 
    // Method to create an immutable instance of type Pair
//    public static <U, V> Pair <U, V> of(U a, V b)
//    {
//        // call the private constructor
//        return new Pair<>(a, b);
//    }
}