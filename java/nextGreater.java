/**
* Given an array, find the next greater element G[i] for 
* every element A[i] in the array. 
* The Next greater Element for an element A[i] is the first 
* greater element on the right side of A[i] in array.
*/


import java.util.*;
// Doing this as I need to have the index of the pushed item from the given array
class item {
    int index;
    Integer value;
    item(int i, Integer v){index = i; value = v;}
}
public class Solution {
	public ArrayList<Integer> nextGreater(ArrayList<Integer> a) {
	    int i,s;
	    Integer element,next;
	    item I,It;
	    
	    Stack st = new Stack();
	    s = a.size();
	    ArrayList<Integer> result = a;
	    I = new item(0,new Integer(a.get(0)));
	    st.push(I);
	    for(i=1; i < s; i++){
	        next = a.get(i);
	        if(!st.empty()){
	            It = (item) st.pop();
	            element = It.value;
	            while(element < next){
	               result.set(It.index,next);
	               if(st.empty()) break;
	               It = (item) st.pop();
	               element = It.value;
	            }
	            if(element >= next){
	                st.push(It);
	            }
	        }
	        I = new item(i,next);
	        st.push(I);
	    }
	    while(!st.empty()){
	        It = (item) st.pop();
	        element = It.value;
	        result.set(It.index, new Integer(-1));
	    }
	    
	    return result;
	}
}

