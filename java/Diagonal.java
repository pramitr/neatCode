/**

Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.

Example:

		
Input: 	

1 2 3
4 5 6
7 8 9

Return the following :

[ 
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]


Input : 
1 2
3 4

Return the following  : 

[
  [1],
  [2, 3],
  [4]
]


*/




public class Solution {
	public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
	    int len = a.get(0).size();
	    int i = 0;
	    int j = 0;
	    int l = 0;
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    for(l=0; l < len; l++){
	        ArrayList<Integer> iR = new ArrayList<Integer>();
	        for(i=l;i>=0;i--){
	            iR.add(a.get(l-i).get(i));
	        }
	        res.add(iR);
	    }
	    
	    l = len - 1 ;
	    for(i=0;i<l;i++){
	        ArrayList<Integer> iR = new ArrayList<Integer>();
	        for(j=0;j+i<l;j++){
	            iR.add(a.get(i+j+1).get(l-j));
	        }
	        res.add(iR);
	    }
	    return res;
	}
}
