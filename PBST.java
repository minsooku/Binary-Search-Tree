package pbst;

//mku1, Minsoo Ku, 118994239, 0104
//I pledge on my honor that I have not given or received any unauthorized 
//assistance on this assignment.

// (c) Larry Herman, 2022.  You are allowed to use this code yourself, but
// not to provide it to anyone else.

import java.util.Collection;

abstract public class PBST<K extends Comparable<K>, V> {
   
   // Fields and constructor.
   protected K key;
   protected V data;
   protected PBST<K,V> left, right;

   public PBST() { 
   }

  abstract public NonemptyPBST<K, V> addKeyValuePair(K newKey, V newValue);
  abstract public int numPairs();
  abstract public V getValueByKey(K keyToLookUp);
  abstract public K largestKey() throws EmptyPBSTException;
  abstract public K smallestKey() throws EmptyPBSTException;
  abstract public int pathBalance(K keyToFind);
  abstract public Collection<K> collectionOfKeys();
  abstract public PBST<K, V> removeKeyValuePair(K keyToRemove);

  
}
