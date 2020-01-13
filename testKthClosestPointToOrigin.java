package com.test.proj;


import java.util.PriorityQueue;
import java.util.stream.Stream;

/**
 * 
 * @author : Kamakshi
 * @date : 12/13/2019
 * Used to find the kth Closest Point to Origin from (0,0)
 * This has used the Euclidean Distance.
 *
 */
public class testKthClosestPointToOrigin {
	
public int[][] kClosest(int[][] points, int K) {
	
	// This priorityQueue will use the Points Class which calculates the
	 // distance based on the Euclidean Distance and prioritize it using Comparator Interface.	
	PriorityQueue<Points> list = new PriorityQueue<Points>();
	
	for(int[] pointVal : points) {
		Points pts = new Points(pointVal);
		list.add(pts);
	}
	
	
	int count = 0;
	int[][] arrResult = new int[K][points[0].length];
	Points ptsVal = list.poll();
	
	// This will retrieve the K closest points from the priority queue.
	while(ptsVal != null) {
		if(count < K) {
			arrResult[count] = ptsVal.getPoints();
			count++;
		}
		
		else
			break;
		ptsVal = list.poll();
	}
	
	return arrResult;
}
        
    
    public int dist(int[] val){
        return val[0] * val[0] + val[1] * val[1];
    }

    
    public static void main(String str[]) {

    	int points[][] = {{3,3},{5,-1},{-2,4}};
    	
    	testKthClosestPointToOrigin obj = new testKthClosestPointToOrigin();
    	
    	Stream.of(obj.kClosest(points, 2)).forEach(x-> {
    		System.out.print("{ ");
    		for(int i=0 ;i<x.length;i++)
    		System.out.print(x[i] + " ");
    		System.out.println("}");
    	});
    }
}


class Points implements Comparable<Points> {
	private int[] points;
	private int distance;
	public int[] getPoints() {
		return points;
	}
	public void setPoints(int[] points) {
		this.points = points;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public Points(int[] points) {
		this.points = points;
		this.distance = points[0] * points[0] + points[1] * points[1];
	}
	@Override
	public int compareTo(Points o) {
		return Integer.compare(this.distance, o.getDistance());
	}
	
	
	
	
	/*
	 * public int[] getPointsArray(int distance){ return this.points; }
	 */
}
