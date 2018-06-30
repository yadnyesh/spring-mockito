package io.yadnyesh.springmockito.business;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ListMockTest {
	
	List<String> mock = mock(List.class);
	
	@Test
	public void basicWithSize() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}
	
	@Test
	public void returnDifferentValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10,mock.size());
	}
	
	@Test
	public void returnWithParameters() {
		when(mock.get(0)).thenReturn("yadnyesh");
		assertEquals("yadnyesh", mock.get(0));
	}
	
	@Test
	public void returnWithGenericParameters() {
		when(mock.get(anyInt())).thenReturn("yadnyesh"); ///anyInt() --> argument matcher
		assertEquals("yadnyesh", mock.get(0));
	}
	
	@Test
	public void verificationBasics() {
		String value = mock.get(0);
		String value1 = mock.get(1);
		verify(mock).get(0);
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, times(2)).get(anyInt());
	}
}
