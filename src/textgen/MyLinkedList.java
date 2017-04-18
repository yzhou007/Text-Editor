package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		size = 0;
		head.next = tail;
		tail.prev = head;
				
		// TODO: Implement this method
	}
	
	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{	
		if (element==null){
			throw new NullPointerException ("Element is null");
		}

		LLNode<E> llNode = new LLNode<E>(element);
		llNode.next = tail;
		llNode.prev = tail.prev;
		tail.prev.next=llNode;
		tail.prev = llNode;
		size++;
		// TODO: Implement this method
		return true;
		
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{	
		if (index > size-1 || index < 0) {
			
			throw new IndexOutOfBoundsException("The getting index out of bound");
		}
		

		LLNode<E> temp = head;		
		for(int i=0; i<=index; i++){
			temp=temp.next;
		}

		// TODO: Implement this method.
		return temp.data;
		
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		if (index > size || index < 0) {

			throw new IndexOutOfBoundsException("The adding index out of bound");
		}
		
		if (element==null){
			throw new NullPointerException ("Element is null");
		}


		LLNode<E> llNode = new LLNode<E>(element);
		LLNode<E> temp = head;		
		for(int i=0; i<index; i++){
			temp=temp.next;
		}
		llNode.next = temp.next;
		llNode.prev = temp;
		temp.next.prev = llNode;
		temp.next = llNode;
		size++;
		
		// TODO: Implement this method
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{	
		if (index > size-1 || index < 0) {

			throw new IndexOutOfBoundsException ("The removing index out of bound");
		}
		
		
		LLNode<E> temp = head;		
		for(int i=0; i<index; i++){
			temp=temp.next;
		}

		E nodeData = temp.next.data;
		temp.next.next.prev = temp;
		temp.next = temp.next.next;
		//temp.next.prev = null;
		size--;
		// TODO: Implement this method
		return nodeData;
		
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{	
		if (index > size-1 || index < 0) {

			throw new IndexOutOfBoundsException ("The removing index out of bound");
		}
		
		if (element==null){
			throw new NullPointerException ("Element is null");
		}
		
		LLNode<E> temp = head;		
		for(int i=0; i<=index; i++){
			temp=temp.next;
		}

		E nodeData = temp.data;

		temp.data = element;

		// TODO: Implement this method
		return nodeData;
		
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
