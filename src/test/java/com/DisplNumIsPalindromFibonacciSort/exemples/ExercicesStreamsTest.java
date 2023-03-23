package com.DisplNumIsPalindromFibonacciSort.exemples;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.DisplNumIsPalindromFibonacciSort.exemples.ExercicesStreams.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ExercicesStreams.class)
public class ExercicesStreamsTest {

	static final PrintStream standardOut = System.out;

	static final ByteArrayOutputStream output = new ByteArrayOutputStream();

	@BeforeAll
	static void setU() throws Exception {
		System.setOut(new PrintStream(output));
	}

	@AfterAll
	static void tearDown() {
		System.setOut(standardOut);
	}

	@Test
	void testDisplayNumbers() {
		displayNumbers(0);
		assertEquals("", output.toString().trim());
		displayNumbers(5);
		assertEquals("0 1 2 3 4", output.toString().trim());
		output.reset();
	}

	@ParameterizedTest
	@ValueSource(strings = { "", "a", "radar", "java avaj" })
	void testIsPalindrome(String word) {
		assertTrue(isPalindrome(word));
	}

	@ParameterizedTest
	@CsvSource(value = { "1,0", "2,1", "3,1", "4,2", "5,3", "6,5", "7,8" })
	@DisplayName("test Fibo1")
	void testFibonacci(int in, int out) {
		assertEquals(fibonacci(in), out);
	}
	

	@Test
	@DisplayName("test Fibo2")
	void testFibonacci() {
		assertThrows(IllegalArgumentException.class, () -> fibonacci(5));
	}

	static Stream<Arguments> generateData() {
		Comparator<Integer> c1 = (n1, n2) -> n1 - n2;
		Comparator<String> c2 = (s1, s2) -> s1.compareTo(s2);
		return Stream.of(Arguments.of(Arrays.asList(5, 2, 4, 3, 1).toArray(), c1, Arrays.asList(1, 2, 3, 4, 5)),
				Arguments.of(Arrays.asList("John", "Alan", "Kurt").toArray(), c2,
						Arrays.asList("Alan", "John", "Kurt")));
	}

	@ParameterizedTest
	@MethodSource("generateData")
	<T> void testSortTab(T[] t, Comparator<T> c, List<T> list) {
		assertEquals(sortTab(t, c), list);
	}

	/////////////////////////////////////////////

	
}
