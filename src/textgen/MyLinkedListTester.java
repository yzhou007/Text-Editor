/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
	

		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			//System.out.println(e.getMessage());
		}
		
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		try {
			emptyList.remove(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		
		try {
			shortList.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
		
		try {
			longerList.remove(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		
		try {
			shortList.remove(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		String eleToRemove=shortList.get(1);
		String eleRemove = shortList.remove(1);
		assertEquals("Check first", eleRemove, eleToRemove);
		
		
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{	

		try {
			shortList.add(null);
			fail("Null Element");
		}
		catch (NullPointerException e) {
		}
		
		
		shortList.add("B");
		int nl = shortList.size()-1;
		assertEquals("Set element at end", "B", shortList.get(nl));
		
        // TODO: implement this test
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		assertEquals("Check size method ", 0, emptyList.size());
		assertEquals("Check size method ", LONG_LIST_LENGTH, longerList.size());
		// TODO: implement this test
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{	
		
		try {
			emptyList.add(-1,0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
		
		try{
			int j = shortList.size();
			shortList.add(j+1, "J");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		try{
			int z = shortList.size();
			shortList.add(z, null);
			fail("Add null element");
			
		}
		catch (NullPointerException e) {			
		}
		
		
		shortList.add(0, "C");
		assertEquals("Add at index", "C", shortList.get(0));
		
        // TODO: implement this test
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{	
		try {
			shortList.set(-1, "T");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		
		try {
			int len = shortList.size();
			shortList.set(len, "T");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
		
		try {
			int len = shortList.size();
			shortList.set(len-1, null);
			fail("Null Element");
		}
		catch (NullPointerException e) {
		}
		
		
		int len = shortList.size();
		shortList.set(len-1, "T");
		assertEquals("Set at index", "T", shortList.get(len-1));
		
	    // TODO: implement this test
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
