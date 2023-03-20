package cn.geekhall.problems.p00200.p00211;

import java.util.*;

/**
 * ID: 00211
 * Title: Design Add and Search Words Data Structure
 * Difficulty: Medium
 * Description: Design a data structure that supports adding new words and
 * finding if a string matches any previously added string.
 *
 * Implement the WordDictionary class:
 *
 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure
 * that matches word or false otherwise. word may contain dots '.' where dots
 * can be matched with any letter.
 *
 * Example:
 *
 * Input
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]] Output
 * [null,null,null,null,false,true,true,true] Explanation WordDictionary
 * wordDictionary = new WordDictionary(); wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad"); wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False wordDictionary.search("bad");
 * // return True wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *
 * Constraints:
 *
 * 1 <= word.length <= 25
 * word in addWord consists of lowercase English letters.
 * word in search consist of '.' or lowercase English letters.
 * There will be at most 3 dots in word for search queries.
 * At most 10 4 calls will be made to addWord and search.
 */
class TrieNode {
  private TrieNode[] children;
  private boolean isEnd;

  public TrieNode() {
    children = new TrieNode[26];
    isEnd = false;
  }

  public void insert(String word) {
    TrieNode node = this;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (node.children[c - 'a'] == null) {
        node.children[c - 'a'] = new TrieNode();
      }
      node = node.children[c - 'a'];
    }
    node.isEnd = true;
  }

  public boolean search(String word) {
    TrieNode node = this;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (c == '.') {
        for (int j = 0; j < 26; j++) {
          if (node.children[j] != null && node.children[j].search(word.substring(i + 1))) {
            return true;
          }
        }
        return false;
      } else {
        if (node.children[c - 'a'] == null) {
          return false;
        }
        node = node.children[c - 'a'];
      }
    }
    return node.isEnd;
  }
}

class WordDictionary {

  // save the words in a trie
  private TrieNode root;

  public WordDictionary() {
    root = new TrieNode();
  }

  public void addWord(String word) {
    root.insert(word);
  }

  public boolean search(String word) {
    return root.search(word);
  }

  public static void main(String[] args) {
    WordDictionary wordDictionary = new WordDictionary();
    wordDictionary.addWord("bad");
    wordDictionary.addWord("dad");
    wordDictionary.addWord("mad");
    System.out.println(wordDictionary.search("pad")); // return False
    System.out.println(wordDictionary.search("bad")); // return True
    System.out.println(wordDictionary.search(".ad")); // return True
    System.out.println(wordDictionary.search("b..")); // return True
  }
}
