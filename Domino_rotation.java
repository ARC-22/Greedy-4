// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if(tops.length != bottoms.length){
            return -1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int target = -1;

        for(int i = 0; i< tops.length; i++){
            int top = tops[i];
            map.put(top, map.getOrDefault(top, 0) + 1);
            if(map.get(top) == tops.length){
                target = top;
                break;
            } 
            int bottom = bottoms[i];
            map.put(bottom, map.getOrDefault(bottom, 0) + 1);
            if(map.get(bottom) == tops.length){
                target = bottom;
                break;
            } 
        }

        if(target == -1){ // never be able to swap completely
            return -1;
        }

        return findMinRotation(tops, bottoms, target);
    }
    private int findMinRotation(int [] tops, int [] bottoms, int target){

        int topRotation =0 , bottomRotation = 0;
        for(int i =0; i<tops.length; i++){
            if(tops[i] != target && bottoms[i] != target){
                return -1;
            }
            if(tops[i] != target){
                topRotation++;
            }    
            if(bottoms[i] != target){
                bottomRotation++;
            }
        }
        return Math.min(topRotation, bottomRotation);
    } 
}
