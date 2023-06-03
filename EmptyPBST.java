package pbst;

//mku1, Minsoo Ku, 118994239, 0104
//I pledge on my honor that I have not given or received any unauthorized 
//assistance on this assignment.

import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings({"unchecked", "rawtypes"})
public class EmptyPBST<K extends Comparable<K>, V> extends PBST<K, V> {

  // This is a constructor for the empty list. 
  private EmptyPBST() {
  }

  // This returns a reference to the unique instance of this class. 
  public static EmptyPBST getInstance() {
     return new EmptyPBST<>();
  }

  // If the parameters are not null, this will return a non empty list with 
  // K newKey and V newValue.
  public NonemptyPBST<K, V> addKeyValuePair(K newKey, V newValue) {
     return new NonemptyPBST<K, V>(newKey, newValue, left, right);
  }

  // This method returns 0 when the polymorphic list is at empty list. 
  public int numPairs() {
     return 0;
  }

  // If the parameter key does not exist in the list, the method returns null.
  public V getValueByKey(K keyToLookUp) {
    return null;
  }

  // Throws EmptyPBSTException once it reaches the empty list while finding
  // the largest key of the tree.
  public K largestKey() throws EmptyPBSTException {
    throw new EmptyPBSTException();
  }

  // Throws EmptyPBSTException once it reaches the empty list while finding
  // the smallest key of the tree.
  public K smallestKey() throws EmptyPBSTException {
    throw new EmptyPBSTException();
  }

  // Throws IllegalArgumentException when the parameter key does not exist
  // in the tree.
  public int pathBalance(K keyToFind) {
    throw new IllegalArgumentException();
  }

  // Returns an empty collection when the method reaches the empty list.
  public Collection<K> collectionOfKeys() {
     return new ArrayList<>();
  }

  // Returns a reference to the current unmodified tree. 
  public PBST<K, V> removeKeyValuePair(K keyToRemove) {
    return this;
  }

  // Returns an empty string since it's an empty tree.
  public String toString() {
     return "";
  }
  
}
