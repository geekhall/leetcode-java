package net.geekhour.problems.p00200.p00208;

import java.util.*;

/**
 * ID: 00208
 * Title: Implement Trie (Prefix Tree)
 * Difficulty: Medium
 * Description: A trie (pronounced as "try") or prefix tree is a tree data
 * structure used to efficiently store and retrieve keys in a dataset of
 * strings. There are various applications of this data structure, such as
 * autocomplete and spellchecker.
 *
 * Implement the Trie class:
 *
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie
 * (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously
 * inserted string word that has the prefix prefix, and false otherwise.
 *
 * Example 1:
 *
 * Input ["Trie", "insert", "search", "search", "startsWith", "insert",
 * "search"] [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output [null, null, true, false, true, null, true] Explanation Trie trie =
 * new Trie(); trie.insert("apple"); trie.search("apple"); // return True
 * trie.search("app"); // return False trie.startsWith("app"); // return True
 * trie.insert("app"); trie.search("app"); // return True
 *
 * Constraints:
 *
 * 1 <= word.length, prefix.length <= 2000
 * word and prefix consist only of lowercase English letters.
 * At most 3 * 10 4 calls in total will be made to insert, search, and
 * startsWith.
 */

class Trie {
  private HashMap<Character, Trie> children;

  public Trie() {
    children = new HashMap<>();
  }

  /**
   * 将字符串word插入到前缀树中。
   *
   * @param word
   */
  public void insert(String word) {
    if (word == null)
      return;
    char[] chars = word.toCharArray();
    Trie node = this;
    for (int i = 0; i < chars.length; i++) {
      if (!node.children.containsKey(chars[i])) {
        node.children.put(chars[i], new Trie());
      }
      node = node.children.get(chars[i]);
    }
    node.children.put('\0', null);
  }

  public boolean search(String word) {
    if (word == null)
      return false;
    char[] chars = word.toCharArray();
    Trie node = this;
    for (int i = 0; i < chars.length; i++) {
      if (!node.children.containsKey(chars[i])) {
        return false;
      }
      node = node.children.get(chars[i]);
    }
    return node.children.containsKey('\0');
  }

  /**
   * 搜索前缀树中是否有以prefix为前缀的字符串。
   *
   * @param pre
   * @return
   */
  public boolean startsWith(String prefix) {
    if (prefix == null)
      return false;
    char[] chars = prefix.toCharArray();
    Trie node = this;
    for (int i = 0; i < chars.length; i++) {
      if (!node.children.containsKey(chars[i])) {
        return false;
      }
      node = node.children.get(chars[i]);
    }
    return true;
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("apple");
    System.out.println(trie.search("apple")); // return True
    System.out.println(trie.search("app")); // return False
    System.out.println(trie.startsWith("app")); // return True
    trie.insert("app");
    System.out.println(trie.search("app")); // return True

  }
}
