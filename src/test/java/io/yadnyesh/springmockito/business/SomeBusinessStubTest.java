package io.yadnyesh.springmockito.business;

import io.yadnyesh.springmockito.data.SomeDataService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


class SomeDataServiceStub implements SomeDataService {
	
	@Override
	public int[] retrieveAllData() {
		return new int[] {1,2,3};
	}
}

class SomeDataServiceEmptyStub implements SomeDataService {
	
	@Override
	public int[] retrieveAllData() {
		return new int[] {};
	}
}

class SomeDataServiceOneElementStub implements SomeDataService {
	
	@Override
	public int[] retrieveAllData() {
		return new int[] {5};
	}
}



public class SomeBusinessStubTest {
	
	@Test
	public void calculateSumUsingDataService_basic() {
		SomeBusinessImpl someBusiness = new SomeBusinessImpl();
		someBusiness.setSomeDataService(new SomeDataServiceStub());
		int actualResult = someBusiness.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSumUsingDataService_emptyArray() {
		SomeBusinessImpl someBusiness = new SomeBusinessImpl();
		someBusiness.setSomeDataService(new SomeDataServiceEmptyStub());
		int actualResult = someBusiness.calculateSumUsingDataService();
		assertEquals(0, actualResult);
	}
	
	@Test
	public void calculateSumUsingDataService_oneValue() {
		SomeBusinessImpl someBusiness = new SomeBusinessImpl();
		someBusiness.setSomeDataService(new SomeDataServiceOneElementStub());
		int actualResult = someBusiness.calculateSumUsingDataService();
		assertEquals(5, actualResult);
	}
	
	

}
