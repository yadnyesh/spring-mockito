package io.yadnyesh.springmockito.business;

import io.yadnyesh.springmockito.data.SomeDataService;

import java.util.Arrays;

public class SomeBusinessImpl {
	
	
	SomeDataService someDataService;
	
	public int calculateSum(int[] data) {
		return Arrays.stream(data).sum();
	}
	
	public int calculateSumUsingDataService() {
		return Arrays.stream(someDataService.retrieveAllData()).sum();
	}
}
