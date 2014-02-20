package set;

import java.util.NoSuchElementException;
import java.util.Iterator;


public class MaxSet<E extends Comparable<E>> extends ArraySet<E> {
	private E maxElement;
	
	/**
	 * Constructs a new empty set.
	 */
	public MaxSet() {
		super();
	}
	
	/** Returns the currently largest element in this set. 
	pre: the set is not empty 
	post: the set is unchanged 
	@return the currently largest element in this set 
	@throws NoSuchElementException if this set is empty 
	*/ 
	public E getMax() {
		if(isEmpty()){
			throw new NoSuchElementException();
		}
		return maxElement;
	}
	
	/** 
	 * Adds the specified element to this set, if it is not already present.
	 * post: x is added to the set if it is not already present
	 * @param  x the element to be added
	 * @return true if the specified element was added
	 */
	public boolean add(E x) {
		if( isEmpty() ){
			maxElement = x;
		} else if ( x.compareTo(maxElement) > 0) {
			maxElement = x;
		}
		
		if( super.add(x) ){
			return true;
		}
		
		return false;
	}
	
	/** 
	 * Removes the specified element from this set if it is present. 
	 * post: 	x is removed if it was present
	 * @param 	x the element to remove - if present
	 * @return true if the set contained the specified element
	 */
	public boolean remove(Object x) {
		boolean rv = super.remove(x);
		
		// If the max value was removed, find a new one
		if(!isEmpty()){
			E maxValue = set.get(0);
			Iterator<? extends E> itr = set.iterator();
			
			while(itr.hasNext()){
				E value = itr.next();
				if(value.compareTo(maxValue) > 0){
					maxValue = value;
				}
			}
			maxElement = maxValue;
		} 
		
		//return
		if( rv ){
			return true;
		}
		return false;
	}
	
	/** Adds all of the elements in the specified set, for which it is 
	possible, to this set. 
	post: all elements, for which it is possible, in the 
	specified set are added to this set. 
	@return true if this set changed as a result of the call 
	*/
	public boolean addAll(SimpleSet<? extends E> c) {
		if(super.addAll(c)){
			return true;
		}
		return false;
	}
	
}