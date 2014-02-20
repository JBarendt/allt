package set;

import java.util.ArrayList;

public class D5 {

	public static int[] uniqueElements(int[] ints){
		//Create a MaxSet
		MaxSet<Integer> maxS = new MaxSet<Integer>();
		//Fill maxSet with ints
		for(int i : ints){
			maxS.add(i);
		}
		
		//Create arraylist to store sorted ints
		ArraySet<Integer> set = new ArraySet<Integer>();
		//"Empty" maxS into list
		while(!maxS.isEmpty()){
			set.add(maxS.getMax());
			maxS.remove(maxS.getMax());
		}
		
		//The vector to return
		int[] returnInts = new int[set.size()];
		//Reverse the order 
		int index = 0;
		for(int i = set.size() - 1; i >= 0; i--){
			returnInts[index] = set.get(i);
			index++;
		}
		
		return returnInts;
	}
	public static void main(String[] args){
		int[] ints = {7, 5, 3, 5, 2, 2, 7};
		
		ints  = uniqueElements(ints);
		for(int i : ints){
			System.out.println(i);
		}
	}
}
