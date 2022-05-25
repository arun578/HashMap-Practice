package src.learning.java11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class HashMapBasics {
	public static void main(String[] args) {
		
		Map<String, String> bike =  new HashMap<>();  // creates a hashMap inside memory
		
		//1. Add element
		bike.put("Bajaj1", "Discover"); 
		//Turn off logical structure than you would be able to see local variables with name
		//O/p: table: [null, null, null, null, null, null, null, null, null, null, null, null, null, null, Bike=Discover, null]
		// Every entry in a table is in a a form of key,value pairs
		bike.put("Hero1", "CBZ");
		bike.put("Hero2", "Splinder");
		bike.put("Hero3", "Splinder Plus");
		bike.put("Bajaj2", "Platina");
		bike.put("TVS1", "Star City");
		bike.put("TVS2", "Apache");
		bike.put("Bajaj3", "Pulsar");
		bike.put("Royal Enfield", "Bullet");
		bike.put("Ideal Jawa", "Yezdi");
		bike.put("Yamaha", "FZ");
		//bike.put("Bajaj4", "Dominar");
		bike.put(null, "No Bike");
		
		//O/P: [null, Hero1=CBZ, null, null, null, Bajaj1=Discover, Bajaj2=Platina, TVS1=Star City, Bajaj4=Dominar, Royal Enfield=Bullet, null, null, Yamaha=FZ, Ideal Jawa=Yezdi, Hero2=Splinder, Hero3=Splinder Plus]
		
		//2. You cannot store duplicate keys in HashMap. However, if you try to store duplicate key with another value, it will replace the value.
		String updatedBikeField = bike.put("Bajaj4", "CT100");
		System.out.println("Put returned value: "+ updatedBikeField);
		
		System.out.println("Current Map Value: "+bike.get("Bajaj4"));
		//3. Remove elements
		//On the basis of key=value
		bike.remove("Hero1","asd"); //delete entry if key=value pair is present(Optional)
		//On key basis
		bike.remove("Hero1"); //removed Hero1 key=value
		
		
		
		//4. Replace
		//Parameters:
		//key key with which the specified value is associated
		//value value to be associated with the specified key
		bike.replace("Bajaj4", "Dominar");
		
		//boolean java.util.Map.replace(String key, String oldValue, String newValue)
		bike.replace("Bajaj4", "Dominar", "CT100");
		
		//ReplaceAll
		// replaceAll(BiFunction<? super String,? super String,? extends String>)
		//Bifunction: function to do the operation on value for each entry
		//ReturnValue: function to do the operation on value for each entry
		bike.replaceAll((K,V)-> bike.get(K)+" Top");
		//O/P: {Bajaj1=Discover Top, Bajaj2=Platina Top, TVS2=Apache Top, TVS1=Star City Top, Bajaj3=Pulsar Top, Bajaj4=CT100 Top, Royal Enfield=Bullet Top, Yamaha=FZ Top, Ideal Jawa=Yezdi Top, Hero2=Splinder Top, Hero3=Splinder Plus Top}
		
		
		 //Ways to iterate over hashMap
		
		
		//1. Iterate over the keys using KeySet
		
		System.out.println("---------Iterate over the keys using KeySet-----------");
		
		Iterator<String> it = bike.keySet().iterator();
		
		/* Returns an iterator over the elements in this set. 
		 *  Iterator<E> iterator();*/
		while(it.hasNext()) {
			String key = it.next();
			System.out.println("Key: "+ key + "   Value: "+ bike.get(key));
		}
		
		
		//2. By Using EntrySet and iterator
		
		System.out.println("---------By Using EntrySet and iterator------------------");
		
		Iterator<Entry<String, String>> it1 = bike.entrySet().iterator();
		/*return a set view of the mappings contained in this map
         *  Set<Map.Entry<K, V>> entrySet();*/
		
		while(it1.hasNext()) {
			Entry<String,String> entry = it1.next();
			System.out.println("Key: "+ entry.getKey() + "    Value "+ entry.getValue());
		}
		
		
		//3. By Using EntrySet and Enhanced for Loop
		
		System.out.println("----------By Using EntrySet and Enhanced for Loop-----------");
		
		for(Entry<String, String> entry : bike.entrySet()) {
			System.out.println("Key: "+ entry.getKey() + "    Value "+ entry.getValue());
		}
		
		
		//4. Using keySet and enhanced for loop
		
		System.out.println("---------Using keySet and enhanced for loop---------------");
		
		Set<String> bikeSet =  bike.keySet();
		for(String choosingBike : bikeSet) {
			System.out.println("Key: "+ choosingBike + "    Value: "+ bike.get("choosingBike"));
		}
		
		//5. Iterate HashMap using Java8 for Each method and Lambda Expression
		
		System.out.println("---------Iterate HashMap using Java8 for Each method and Lambda Expression----------");
		
		bike.forEach((K,V) -> System.out.println("Key: "+ K + "      Value: "+ V));
	}
}
