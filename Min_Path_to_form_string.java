// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NO // premium question
// Any problem you faced while coding this : No

public int shortestWay(String source, String target) {
    if(source.equals(target)){
        return 0;
    }

    int sp = 0;
    int tp = 0;
    int result = 1;
    HashSet<Character> set = new HashSet<>();

    for(int i =0; i<source.length(); i++){
        set.add(source.charAt(i));
    } 

    while(tp < target.length()){
        char c = target.charAt(tp);
        if(!set.contains(c)){
            return -1;
        }
        if(source.charAt(sp) == c){
            sp++;
            tp++;
        }
        else{
            sp++;
        }
        if(sp == source.length() && tp < target.length()){
            sp = 0;
            result++;
        }
    }
    return result;
}