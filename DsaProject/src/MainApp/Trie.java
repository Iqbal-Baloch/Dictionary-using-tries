package MainApp;

public class Trie 
{
	private class Trie_Node // node for trie
	{
		String description ;
		Trie_Node[] children = new Trie_Node[26] ;
		boolean isWord ;
		Trie_Node()
		{
			description = "None..." ;
			isWord = false ;
			for(int i =0 ; i < 26 ; i++)
				children[i] = null ;
		}
	}
	
	Trie_Node root ; // root of Trie
	Trie()
	{
		root = new Trie_Node() ;
	}
	
	public void insert(String word , String des)
	{
		word = word.toLowerCase() ;
		int length = word.length() ;
		int index ;
		Trie_Node curr = root ;
		for(int i = 0 ; i<length ; i++)
		{
			index = word.charAt(i) - 'a' ;
			if(curr.children[index] == null)
				curr.children[index] = new Trie_Node() ;
			curr = curr.children[index] ;
		}
		curr.isWord = true ;
		curr.description =" "+word +"\n "+des ;
	}
	public String search(String word)
	{
		word = word.toLowerCase() ;
		int index ;
		int length = word.length();
		Trie_Node curr = root ;
		
		for(int i = 0 ; i<length ; i++)
		{
			index = word.charAt(i) - 'a' ;
			if(curr.children[index] == null)
				return "None" ;
			curr = curr.children[index] ;
		}
		if(curr.isWord)
			return curr.description ;
		return "None" ;
	}
	public boolean isLastNode(Trie_Node node)
	{
		for(int i = 0; i<26 ; i++)
		{
			if(node.children[i] != null)
				return false ;
		}
		return true ;
	}
	public ArrayList autoComplete(String prefix) 
	{
		if (prefix == null)
			return null ;
		ArrayList a = new ArrayList() ;
		return autoComplete(this.root , prefix , a) ;
	}
	public ArrayList autoComplete(Trie_Node node , String prefix, ArrayList a)
	{
		if(!search(prefix).equals("None"))
		{
			a.add(prefix);
			if(a.size() == 7)
				return a ;
		}
			
		if(isLastNode(node))
			return a ;
		for(int i = 0 ; i < 26 ; i++)
		{
			if(node.children[i]!= null)
			{
				char c = (char)(i+97) ;
				if(a.size() == 7) return a ;
				autoComplete(node.children[i] , prefix+c , a) ;
			}
		}
		return a ;
		
	}
}
