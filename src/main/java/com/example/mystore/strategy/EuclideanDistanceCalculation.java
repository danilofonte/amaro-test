package com.example.mystore.strategy;

import org.springframework.stereotype.Service;

@Service
public class EuclideanDistanceCalculation {
	
	public double calculateDistance(int[] array1, int[] array2) {
	    double Sum = 0.0;

	    for (int i = 0; i < array1.length; i++) {
	        Sum = Sum + Math.pow((array1[i] - array2[i]), 2.0);
	    }

	    return Math.sqrt(Sum);
	}

}
