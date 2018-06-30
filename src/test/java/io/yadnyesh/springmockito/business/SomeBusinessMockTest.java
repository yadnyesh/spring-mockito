package io.yadnyesh.springmockito.business;

import io.yadnyesh.springmockito.data.SomeDataService;
import org.junit.Test;
import static org.mockito.Mockito.mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class SomeBusinessMockTest {
	
	SomeBusinessImpl someBusiness = new SomeBusinessImpl();
	SomeDataService someDataServiceMock = mock(SomeDataService.class);
	
	@Test
	public void calculateSumUsingDataService_basic() {
		when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
		someBusiness.setSomeDataService(someDataServiceMock);
		int actualResult = someBusiness.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSumUsingDataService_emptyArray() {
		when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		someBusiness.setSomeDataService(someDataServiceMock);
		int actualResult = someBusiness.calculateSumUsingDataService();
		assertEquals(0, actualResult);
	}
	
	@Test
	public void calculateSumUsingDataService_oneValue() {
		when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {5});
		someBusiness.setSomeDataService(someDataServiceMock);
		int actualResult = someBusiness.calculateSumUsingDataService();
		assertEquals(5, actualResult);
	}
	
	

}
