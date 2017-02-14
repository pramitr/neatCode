/**

Find shortest unique prefix to represent each word in the list.

Example:

Input: [zebra, dog, duck, dove]
Output: {z, dog, du, dov}
where we can see that
zebra = z
dog = dog
duck = du
dove = dov

///////////

We are using a Trie tree for prefix.

1) Construct a Trie of all words. Also maintain frequency of every node (Here frequency is number of times node is visited 
during insertion). Time complexity of this step is O(N) where N is total number of characters in all words.

2) Now, for every word, we find the character nearest to the root with frequency as 1. The prefix of the word is path from root 
to this character. To do this, we can traverse Trie starting from root. For every node being traversed, we check its frequency.
If frequency is one, we print all characters from root to this node and don’t traverse down this node.

Time complexity if this step also is O(N) where N is total number of characters in all words.

                root
                / \
         (d, 3)/   \(z, 1)
              /     \
          Node1     Node2
           / \          \
     (o,2)/   \(u,1)     \(e,1)
         /     \          \
   Node1.1    Node1.2     Node2.1
      /  \         \            \
(g,1)/    \ (t,1)   \(c,1)       \(b,1)
    /      \         \            \ 
   Leaf   Leaf       Node1.2.1     Node2.1.1
   (dog)  (dot)        \               \
                         \(k, 1)          \(r, 1)
                          \                \   
                          Leaf           Node2.1.1.1
                          (duck)              \
                                                \(a,1)
                                                 \
                                                 Leaf
                                                 (zebra)

*/



public class Solution {
	public ArrayList<String> prefix(ArrayList<String> a) {
	    TrieNode root = new TrieNode();
		for(String s : a) {
			root.insert(s, 0);
		}
		ArrayList<String> prefixes = new ArrayList<String>();
		for(String s : a) {
			String shortestUniquePrefix = root.search(s, 0);
			prefixes.add(shortestUniquePrefix);
		}
		return prefixes;
	}
	
	private static final class TrieNode {
		private Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		private int count = 0;
		
		public void insert(String s, int i) {
			count++;
			if(i < s.length()) {
				Character current = s.charAt(i);
				if(!children.containsKey(current)) {
					children.put(current, new TrieNode());
				}
				TrieNode child = children.get(current);
				child.insert(s, i + 1);
			}
		}
		
		public String search(String s, int i) {
			String prefix = null;
			if(i > 0 && count == 1) {
				prefix = s.substring(0, i);
			} else {
				Character ch = s.charAt(i);
				TrieNode child = children.get(ch);
				prefix = child.search(s, i + 1);
			}
			return prefix;
		}
	}
}


