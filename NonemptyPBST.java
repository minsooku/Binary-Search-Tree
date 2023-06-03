package pbst;

//mku1, Minsoo Ku, 118994239, 0104
//I pledge on my honor that I have not given or received any unauthorized 
//assistance on this assignment.

import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("unchecked")
public class NonemptyPBST<K extends Comparable<K>, V> extends PBST<K, V> {

   private K key;
   private V value;
   private PBST<K, V> left, right;

   // This is a constructor for the non-empty PBST. 
   public NonemptyPBST(K key, V value, PBST<K, V> left, PBST<K, V> right) {
      this.key = key;
      this.value = value;
      this.left = EmptyPBST.getInstance();
      this.right = EmptyPBST.getInstance();
   }

   // This method adds key and value to the PBST based on whether the key is 
   // larger than the key that is being compared. If the current key is larger
   // than the parameter key, the key will go to the left side of the current 
   // key and will be checked again, and vice versa. If the left or right side
   // of the current key is empty, the parameter key will be added. 
   public NonemptyPBST<K, V> addKeyValuePair(K key, V value) {
      if (key == null || value == null) {
         throw new IllegalArgumentException();
      }

      if (key.compareTo(this.key) == 0) {
         this.value = value;
      } else if (key.compareTo(this.key) > 0) {
         right = right.addKeyValuePair(key, value);
      } else if (key.compareTo(this.key) < 0) {
         left = left.addKeyValuePair(key, value);
      }
      
      return this;
   }

   // This method will return the total number of keys/values present in the 
   // current tree. If the tree is empty, it will return 0. 
   public int numPairs() {
      int sum = 0;

      if (key != null) {
         sum++;
         sum += left.numPairs() + right.numPairs();
      }
      
      return sum;
   }

   // This method will return a value that is paired with the parameter key. 
   // It will search through the tree and once it finds the parameter key, it 
   // will return the value that is paired with key. 
   public V getValueByKey(K keyToLookUp) {
      if (keyToLookUp == null) {
         throw new IllegalArgumentException();
      }
      
      if (keyToLookUp.compareTo(this.key) > 0) {
         return right.getValueByKey(keyToLookUp);
      } else if (keyToLookUp.compareTo(this.key) < 0) {
         return left.getValueByKey(keyToLookUp);
      } else {
         return value;
      }
   }

   // This will return the largest key of the tree by returning the right-most
   // key of the tree. 
   public K largestKey() throws EmptyPBSTException {
      try {
         return right.largestKey();
      } catch (EmptyPBSTException e) {
         return key;
      }
   }

   // This will return the smallest key of the tree by returning the left-most
   // key of the tree. 
   public K smallestKey() throws EmptyPBSTException {
      try {
         return left.smallestKey();
      } catch (EmptyPBSTException e) {
         return key;
      }
   }

   // test this method, with a student test. 
   // Public test does not test this method.
   public int pathBalance(K keyToFind) {
      if (keyToFind == null) {
         throw new IllegalArgumentException();
      }
      
      if (keyToFind.compareTo(key) > 0) {
         return 1 + right.pathBalance(keyToFind);
      } else if (keyToFind.compareTo(key) < 0){
         return -1 + left.pathBalance(keyToFind);
      } else {
         return 0;
      }
   }

   // This method will return a collection of keys by combining keys of the 
   // left of roof and keys of the right of the roof and the roof itself. 
   public Collection<K> collectionOfKeys() {
      Collection<K> allKeys = new ArrayList<>();
      Collection<K> leftList = new ArrayList<>();
      Collection<K> rightList = new ArrayList<>();

      leftList = left.collectionOfKeys();
      rightList = right.collectionOfKeys();

      for (K leftKey : leftList) {
         allKeys.add(leftKey);
      }

      for (K rightKey : rightList) {
         allKeys.add(rightKey);
      }

      allKeys.add(key);
      return allKeys;
   }

   // This method will remove a pair of parameter key and value from the tree,
   // by replacing it with the largest key in the left tree and returning an
   // empty PBST.
   public PBST<K, V> removeKeyValuePair(K keyToRemove) {
      if (keyToRemove == null) {
         throw new IllegalArgumentException();
      }
      
      if (keyToRemove.compareTo(key) > 0) {
         right = right.removeKeyValuePair(keyToRemove);
      } else if (keyToRemove.compareTo(key) < 0) {
         left = left.removeKeyValuePair(keyToRemove);
      } else {
         try {
            K leftMax = left.largestKey();
            value = getValueByKey(leftMax);
            key = leftMax;
            left = left.removeKeyValuePair(key);
         } catch (EmptyPBSTException e) {
            return EmptyPBST.getInstance();
         }
      }
      
      return this;
   }

   // This method will transfer keys and values of the tree into String. 
   public String toString() {
      return left.toString() + key + "/" + value + " " + right.toString();
   }

}
