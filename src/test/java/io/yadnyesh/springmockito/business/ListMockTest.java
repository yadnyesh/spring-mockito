package io.yadnyesh.springmockito.business;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListMockTest {
	
	@Test
	public void Test() {
		List mock = mock(List.class);
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}
}
