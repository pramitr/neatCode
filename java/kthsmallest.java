/**
* This solution is using QuickSelect method which means 
* run QuickSort till the point where pivot 
* is same as kth smallest element
*/

public class Solution {
	public int getKthSmallest(List<Integer> a, int k) {
	    int size = a.size();
	    return kth(a,0,size-1,k);
	    
	}
	
	public int kth(List<Integer> a, int left, int right, int k){
	    int pos;
	    if(k > 0 && k <= right - left + 1){ //if k lies within the range
	        pos = partition(a,left,right);
	        if(k == pos - left + 1){
	            return a.get(pos);
	        }
	        else if(k < pos - left + 1){
	            return kth(a,left,pos-1,k);
	        }
	        else {
	            return kth(a,pos+1,right,k-pos+left-1);
	        }
	    }
	    return Integer.MAX_VALUE;
	}
	
	public int partition(List<Integer> a, int left, int right){
	    int i,j,pivot,temp;
	    pivot = a.get(right); // I am using last element as pivot, can be changed to random or first
	    i = left;
	    for(j = left; j < right; j++){
	        if(a.get(j) <= pivot){
	            temp = a.get(i);
	            a.set(i,a.get(j));
	            a.set(j,temp);
	            i++;
	        }
	    }
	    temp = a.get(i);
	    a.set(i,a.get(j));
	    a.set(j,temp);
	    return i;
	}
}
