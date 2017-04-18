package spelling;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/** 
 * An trie data structure that implements the Dictionary and the AutoComplete ADT
 * @author You
 *
 */
public class AutoCompleteDictionaryTrie implements  Dictionary, AutoComplete {

    private TrieNode root;
    private int size;
    

    public AutoCompleteDictionaryTrie()
	{
		root = new TrieNode();
	}
	
	
	/** Insert a word into the trie.
	 * For the basic part of the assignment (part 2), you should ignore the word's case.
	 * That is, you should convert the string to all lower case as you insert it. */
	public boolean addWord(String word)
	{	
		
		TrieNode trace = root;
		String wd = word.toLowerCase();
		int i = 0;
		while(i<=word.length()-2){
			if (trace.getValidNextCharacters().contains(wd.charAt(i))){
				trace = trace.getChild(wd.charAt(i));
				i++;
			}	
			
			else{
				trace=trace.insert(wd.charAt(i));
				i++;
			}
		}
		

		if (trace.getValidNextCharacters().contains(wd.charAt(i))){
			trace=trace.getChild(wd.charAt(i));
			if (!trace.endsWord()){
				size=size+1;
				trace.setEndsWord(true);
			}
		    //System.out.println("No need to add " + trace.getText());
			return false;
		}	
		
		trace=trace.insert(wd.charAt(i));
		trace.setEndsWord(true);
		
		size=size+1;

		return true;
	    
	    //TODO: Implement this method.
	

	    
	}
	
	/** 
	 * Return the number of words in the dictionary.  This is NOT necessarily the same
	 * as the number of TrieNodes in the trie.
	 */
	public int size()
	{	
		return size;
		
	}
	

	
	/** Returns whether the string is a word in the trie */
	@Override
	public boolean isWord(String s) 
	{	
		if (s.isEmpty()){
			return false;
		}
		
		TrieNode trace = root;
		String wd = s.toLowerCase();
		int i = 0;
		while(i<=s.length()-1){
			
			if (trace.getValidNextCharacters().contains(wd.charAt(i))){
				trace = trace.getChild(wd.charAt(i));
				i++;
			}	
			
			else{
					return false;
			}
		}
	   	
		if(trace.endsWord()){
			return true;
		}
		return false;
		
	    // TODO: Implement this method
		
	}

	/** 
	 *  * Returns up to the n "best" predictions, including the word itself,
     * in terms of length
     * If this string is not in the trie, it returns null.
     * @param text The text to use at the word stem
     * @param n The maximum number of predictions desired.
     * @return A list containing the up to n best predictions
     */@Override
     public List<String> predictCompletions(String prefix, int numCompletions) 
     {
    	 // TODO: Implement this method
    	 // This method should implement the following algorithm:
    	 // 1. Find the stem in the trie.  If the stem does not appear in the trie, return an
    	 //    empty list
    	 // 2. Once the stem is found, perform a breadth first search to generate completions
    	 //    using the following algorithm:
    	 //    Create a queue (LinkedList) and add the node that completes the stem to the back
    	 //       of the list.
    	 //    Create a list of completions to return (initially empty)
    	 //    While the queue is not empty and you don't have enough completions:
    	 //       remove the first Node from the queue
    	 //       If it is a word, add it to the completions list
    	 //       Add all of its child nodes to the back of the queue
    	 // Return the list of completions
     	List<String> compList = new ArrayList<String>(numCompletions);
  
    	TrieNode trace = root;
 		String wd = prefix.toLowerCase();
 		int i = 0;
		while(i<=prefix.length()-1){
			
			if (trace.getValidNextCharacters().contains(wd.charAt(i))){
				trace = trace.getChild(wd.charAt(i));
				i++;
			}	
			
			else{
					return compList;
			}
		}
	   	if(numCompletions==0){
	   		return compList;
	   	}
	   		
		LinkedList<TrieNode> q = new LinkedList<TrieNode>();
		q.add(trace);
		while(!q.isEmpty() && compList.size()<numCompletions){
			TrieNode curr = q.remove();
			if (curr.endsWord()){
				compList.add(curr.getText());
			}
			if(!curr.getValidNextCharacters().isEmpty()){
				for(Character ch : curr.getValidNextCharacters()){
					q.add(curr.getChild(ch));
				}
			}
			
		}
    	 
        return compList;
     }
     
     
 	// For debugging
 	public void printTree()
 	{
 		printNode(root);
 	}
 	
 	/** Do a pre-order traversal from this node down */
 	public void printNode(TrieNode curr)
 	{
 		if (curr == null) 
 			return;
 		
 		System.out.println(curr.getText());
 		
 		TrieNode next = null;
 		for (Character c : curr.getValidNextCharacters()) {
 			next = curr.getChild(c);
 			printNode(next);
 		}
 	}
 	

	
}