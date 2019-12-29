package junit.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.StringCalculator;

public class StringCalculatorTest {
	
	StringCalculator cal;
	
	@Before
	public void setup() {
		cal = new StringCalculator();
	}
	
	@Test
	public void nulltoZero() {
		assertEquals(0, cal.add(""));
	}
	
	@Test
	public void numAdd() {
		assertEquals(6, cal.add("4,2"));
	}
	
	@Test
	public void splitRestMarkAdd() {
		assertEquals(6, cal.add("1,2,3"));
	}
	
	@Test
	public void splitMultiMarkAdd() {
		assertEquals(6, cal.add("1,2:3"));
	}
	
	@Test
	public void splitCustomMarkAdd() {
		assertEquals(6, cal.add("//;\n1;2;3"));
	}
	
	@Test(expected = RuntimeException.class)
	public void isNegativeChk() throws Exception{
		cal.add("-1:2:3");
	}

}
