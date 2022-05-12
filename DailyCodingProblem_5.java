/**
mplement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.

For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].

Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.
*/








import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class dailycodingproblem5{
	public class trienode {
		Map<Character, trienode > children;
		char c;
		boolean isWord;

		public trienode (char c) {
			this.c = c;
			children = new HashMap<>();
		}

		public trienode () {
			children = new HashMap<>();
		}

		public void insert(String word) {
			if (word == null || word.isEmpty())
				return;
			char firstChar = word.charAt(0);
			trienode  child = children.get(firstChar);
			if (child == null) {
				child = new trienode (firstChar);
				children.put(firstChar, child);
			}

			if (word.length() > 1)
				child.insert(word.substring(1));
			else
				child.isWord = true;
		}
	}
	trienode  root;
	public dailycodingproblem5(List<String> words) {
		root = new trienode ();
		for (String word : words)
			root.insert(word);
	}

	public boolean find(String prefix, boolean exact) {
		trienode  lastNode = root;
		for (char c : prefix.toCharArray()) {
			lastNode = lastNode.children.get(c);
			if (lastNode == null)
				return false;
		}
		return !exact || lastNode.isWord;
	}

	public boolean find(String prefix) {
		return find(prefix, false);
	}

	public void suggestHelper(trienode  root, List<String> list, StringBuffer curr) {
		if (root.isWord) {
			list.add(curr.toString());
		}

		if (root.children == null || root.children.isEmpty())
			return;

		for (trienode child : root.children.values()) {
			suggestHelper(child, list, curr.append(child.c));
			curr.setLength(curr.length() - 1);
		}
	}

	public List<String> suggest(String prefix) {
		List<String> list = new ArrayList<>();
	trienode  lastNode = root;
		StringBuffer curr = new StringBuffer();
		for (char c : prefix.toCharArray()) {
			lastNode = lastNode.children.get(c);
			if (lastNode == null)
				return list;
			curr.append(c);
		}
		suggestHelper(lastNode, list, curr);
		return list;
	}
	public static void main(String[] args) {
		List<String> words = List.of("dog", "deer", "deal");
		dailycodingproblem5 trie = new dailycodingproblem5(words);
		System.out.println(trie.suggest("de"));
	}

}

