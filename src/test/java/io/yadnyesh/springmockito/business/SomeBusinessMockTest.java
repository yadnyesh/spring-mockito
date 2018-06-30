package io.yadnyesh.springmockito.business;

import io.yadnyesh.springmockito.data.SomeDataService;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class SomeBusinessMockTest {
	
	SomeBusinessImpl someBusiness = new SomeBusinessImpl();
	SomeDataService someDataServiceMock = mock(SomeDataService.class);
	
	@Before
	public void before() {
		someBusiness.setSomeDataService(someDataServiceMock);
	}
	
	@Test
	public void calculateSumUsingDataService_basic() {
		when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
		assertEquals(6, someBusiness.calculateSumUsingDataService());
	}
	
	@Test
	public void calculateSumUsingDataService_emptyArray() {
		when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(0, someBusiness.calculateSumUsingDataService());
	}
	
	@Test
	public void calculateSumUsingDataService_oneValue() {
		when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {5});
		assertEquals(5, someBusiness.calculateSumUsingDataService());
	}
	
	

}
