public class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> target = new HashMap<Character, Integer>(); // Target string
        HashMap<Character, Integer> found = new HashMap<Character, Integer>(); // Found character map
        int i = 0;
        char c,ch;
        for(i = 0; i< t.length(); i++){
            c = t.charAt(i);
            if(target.containsKey(c)){
                target.put(c, target.get(c) + 1); // if already exists we remember the frequency because there could be duplicate characters
            }
            else {
                target.put(c,1);
            }
        }
        
        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        String result = "";
        
        while( end < s.length() ){
            c = s.charAt(end);
            if(target.containsKey(c)){
                if(found.containsKey(c)){ // means there are duplicate characters in target
                    if(found.get(c) < target.get(c)){ 
                        count++; // character count of target
                    }
                    found.put(c, found.get(c)+1); // remembering frequency of the duplicate character
                }
                else {
                    count++;
                    found.put(c,1);
                }
            }
            
            if( count == t.length() ) {
                ch = s.charAt(start);
                while(!found.containsKey(ch) || found.get(ch) > target.get(ch)){ // either character got removed while removing duplicate or new window started
                    if(found.containsKey(ch) && found.get(ch) > target.get(ch)){
                        found.put(ch, found.get(ch) - 1);
                    }
                    start++;
                    ch = s.charAt(start);
                }
                if(end - start + 1 < minLen){
                    result = s.substring(start,end+1);
                    minLen = end - start + 1;
                }
            }
            end++;
        }
        
        return result;
        
        
    }
}
