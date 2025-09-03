package com.wackstr.leetcode;

public class PlacePeople_3027 {
    public int numberOfPairs(int[][] points) {
        int cnt = 0;
        Arrays.sort(points, (a,b)-> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        for(int i = 0; i < points.length; i++){
            int[] basePoint = points[i];
            for(int j = i+1; j < points.length;j++){
                int[] targetPoint = points[j];
                if(targetPoint[1] >= basePoint[1]){
                    boolean collision = false;
                    for(int k = i + 1; k < j; k++){
                        int currPointY = points[k][1];
                        if(currPointY <= targetPoint[1] && currPointY >= basePoint[1]){
                            collision = true;
                            break;
                        }
                    }
                    if(!collision) cnt++;
                }
            }
        }
        return cnt;
    }
}
