package io.yadnyesh.springmockito.business;

import io.yadnyesh.springmockito.data.SomeDataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {
	
	@InjectMocks
	SomeBusinessImpl someBusiness;
	
	@Mock
	SomeDataService someDataServiceMock = mock(SomeDataService.class);
	
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
