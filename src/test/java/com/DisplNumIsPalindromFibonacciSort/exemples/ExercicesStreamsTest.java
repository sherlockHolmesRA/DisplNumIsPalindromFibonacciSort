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

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ExercicesStreams.class)
public class ExercicesStreamsTest {

	static final PrintStream standardOut = System.out;

	static final ByteArrayOutputStream output = new ByteArrayOutputStream();
/**/
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
		ExercicesStreams.displayNumbers(5);
		assertEquals("0 1 2 3 4", output.toString().trim());
		output.reset();
	}

	/*
	 * @Test
	 * 
	 * @DisplayName("testDisplayNumbers") void testDisplayNumbers() {
	 * displayNumbers(0); assertEquals("", outputStream.toString().trim());
	 * displayNumbers(5); assertEquals("0 1 2 3 4", outputStream.toString().trim());
	 * outputStream.reset(); }
	 */
	@ParameterizedTest
	@ValueSource(strings = { "", "a", "radar", "java avaj" })
	void testIsPalindrome(String word) {
		assertTrue(ExercicesStreams.isPalindrome(word));
	}

	@ParameterizedTest
	@CsvSource(value = { "1,0", "2,1", "3,1", "4,2", "5,3", "6,5", "7,8" })
	@DisplayName("test Fibo1")
	void testFibonacci(int in, int out) {
		assertEquals(ExercicesStreams.fibonacci(in), out);
	}
	/*
	 * @ParameterizedTest
	 * 
	 * @CsvSource(value = {"1,0", "2,1", "3,1", "4,2", "5,3", "6,5", "7,8"})
	 * 
	 * @DisplayName("test fibo 1") void testFibonacci(int in, int out) {
	 * assertEquals(fibonacci(in), out); }
	 * 
	 * @Test
	 * 
	 * @DisplayName("test fibo 2") void testFibonacci() {
	 * assertThrows(IllegalArgumentException.class, () -> fibonacci(-1)); }
	 */

	@Test
	@DisplayName("test Fibo2")
	void testFibonacci() {
		assertThrows(IllegalArgumentException.class, () -> ExercicesStreams.fibonacci(-1));
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
		assertEquals(ExercicesStreams.sortTab(t, c), list);
	}

	/*
	 * static Stream<Arguments> generateData() { Comparator<Integer> c1 = (n1, n2)
	 * -> n1 - n2; Comparator<String> c2 = (s1, s2) -> s1.compareTo(s2); return
	 * Stream.of(Arguments.of(Arrays.asList(5, 2, 4, 3, 1).toArray(), c1,
	 * Arrays.asList(1, 2, 3, 4, 5)), Arguments.of(Arrays.asList("John", "Alan",
	 * "Kurt").toArray(), c2, Arrays.asList("Alan", "John", "Kurt"))); }
	 * 
	 * @ParameterizedTest
	 * 
	 * @MethodSource("generateData") <T> void testSortTab(T[] t, Comparator<T> c,
	 * List<T> list) { assertEquals(sortTab(t, c), list); }
	 */

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**/

	@Test
	@DisplayName("testDisplayAlphabet")
	void testDisplayAlphabet() {
		ExercicesStreams.displayAlphabet();
		assertEquals("abcdefghijklmnopqrstuvwxyz", output.toString().trim());
		output.reset();
	}

	@Test
	@DisplayName("testMyAbs")
	void testMyAbs() {
		assertTrue(ExercicesStreams.myAbs(7) == 7);
		assertTrue(ExercicesStreams.myAbs(-7) == 7);
		assertTrue(ExercicesStreams.myAbs(0) == 0);
	}

	@Test
	@DisplayName("testDisplayTab")
	void testDisplayTab() {
		int[] t1 = { 1, 2, 3, 4 };

		ExercicesStreams.displayTab(t1);
		assertEquals("1234", output.toString().trim());
		output.reset();

		int[] t2 = {};

		ExercicesStreams.displayTab(t2);
		assertEquals("", output.toString().trim());
		output.reset();
	}

	@Test
	@DisplayName("testMaxTab")
	void testMaxTab() {
		int[] t1 = { 5, 2, 8, -6, 0, 7 };
		assertTrue(ExercicesStreams.maxTab(t1) == 8);

		int[] t2 = { 1 };
		assertTrue(ExercicesStreams.maxTab(t2) == 1);
	}

	@Test
	@DisplayName("testMean")
	void testMean() {
		assertTrue(ExercicesStreams.mean(1) == 1);
		assertTrue(ExercicesStreams.mean(10, 20, 30) == 20);
		assertTrue(ExercicesStreams.mean(10, 15, 25, 45) == 23.75);
	}

	@Test
	@DisplayName("testCountVowels")
	void testCountVowels() {
		assertAll("Test countVowels", () -> assertTrue(ExercicesStreams.countVowels("") == 0, ""),
				() -> assertTrue(ExercicesStreams.countVowels("a") == 1, ""), () -> assertTrue(ExercicesStreams.countVowels("Charles") == 2, ""),
				() -> assertTrue(ExercicesStreams.countVowels("testeur_") == 3, ""));
	}

	@Test
	@DisplayName("testCountConsonants")
	void testCountConsonants() {
		assertAll("Test countConsonants", () -> assertTrue(ExercicesStreams.countConsonants("") == 0, ""),
				() -> assertTrue(ExercicesStreams.countConsonants("z") == 1, ""),
				() -> assertTrue(ExercicesStreams.countConsonants("Archimède") == 5, ""),
				() -> assertTrue(ExercicesStreams.countConsonants("testeur_") == 4, ""));
	}

	@Test
	@DisplayName("testContainsUpperCase")
	void testContainsUpperCase() {
		assertAll("Test containsUpperCase", () -> assertFalse(ExercicesStreams.containsUpperCase(""), ""),
				() -> assertFalse(ExercicesStreams.containsUpperCase("hello"), ""), () -> assertTrue(ExercicesStreams.containsUpperCase("charleS"), ""),
				() -> assertTrue(ExercicesStreams.containsUpperCase("TesTeur_"), ""));
	}

	@Test
	@DisplayName("testFactorial")
	void testFactorial() {
		assertAll("Test factorial", () -> assertTrue(ExercicesStreams.factorial(-1) == 1, ""), () -> assertTrue(ExercicesStreams.factorial(0) == 1, ""),
				() -> assertTrue(ExercicesStreams.factorial(1) == 1, ""), () -> assertTrue(ExercicesStreams.factorial(2) == 2, ""),
				() -> assertTrue(ExercicesStreams.factorial(5) == 120, ""), () -> assertTrue(ExercicesStreams.factorial(10) == 3628800, ""));
	}

	@Test
	@DisplayName("testFilterList")
	void testFilterList() {
		var l1 = Arrays.asList("a", "aa", "aaa", "aaaa");
		var l2 = Arrays.asList("b", "bb", "bbb", "bbbb", "", "z");
		var l3 = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

		assertAll("Test filterList",
				() -> assertEquals(ExercicesStreams.filterList(l1, s -> s.length() >= 3), Arrays.asList("aaa", "aaaa")),
				() -> assertEquals(ExercicesStreams.filterList(l2, s -> s.length() <= 2), Arrays.asList("b", "bb", "", "z")),
				() -> assertEquals(ExercicesStreams.filterList(l3, n -> n % 3 == 0), Arrays.asList(0, 3, 6, 9)));
	}

	@Test
	@DisplayName("sumSquare")
	void testsumSquare() {
		assertAll("Test sumSquare", () -> assertTrue(ExercicesStreams.sumSquare(-1) == 0, ""), () -> assertTrue(ExercicesStreams.sumSquare(0) == 0, ""),
				() -> assertTrue(ExercicesStreams.sumSquare(1) == 0, ""), () -> assertTrue(ExercicesStreams.sumSquare(2) == 4, ""),
				() -> assertTrue(ExercicesStreams.sumSquare(3) == 4, ""), () -> assertTrue(ExercicesStreams.sumSquare(6) == 56, ""),
				() -> assertTrue(ExercicesStreams.sumSquare(10) == 220, ""));
	}

	@Test
	@DisplayName("partitioningList")
	void testpartitioningList() {
		assertAll("Test partitioningList",
				() -> assertEquals(ExercicesStreams.partitioningList(Arrays.asList(2, 3, 1, 5, 4), e -> e > 2),
						Map.of(false, Arrays.asList(2, 1), true, Arrays.asList(3, 5, 4))),
				() -> assertEquals(ExercicesStreams.partitioningList(Arrays.asList(2, 3, 1, 5, 4), e -> e > 0),
						Map.of(false, Arrays.asList(), true, Arrays.asList(2, 3, 1, 5, 4))));
	}

	@Test
	@DisplayName("testGroupByFunction")
	void testGroupByFunction() {
		var map1 = Map.of(7, 1L, 5, 2L, 8, 1L);
		var map2 = Map.of(true, 1L, false, 3L);
		var s1 = Stream.of("charles", "lancelot", "maeva", "laure");
		var s2 = Stream.of("", "a", "ab", "abc");

		assertAll("Test groupByFunction",
				() -> assertTrue(ExercicesStreams.groupByFunction(s1, String::length).entrySet().stream()
						.allMatch(e -> e.getValue().equals(map1.get(e.getKey())))),
				() -> assertTrue(ExercicesStreams.groupByFunction(s2, s -> s.matches("a")).entrySet().stream()
						.allMatch(e -> e.getValue().equals(map2.get(e.getKey())))));
	}

	@Test
	@DisplayName("testPrimeFactors")
	void testPrimeFactors() {
		assertAll("Test primeFactors",
				() -> assertEquals(ExercicesStreams.primeFactors(8).boxed().collect(Collectors.toList()), IntStream.of(2, 2, 2).boxed().collect(Collectors.toList())),
				() -> assertEquals(ExercicesStreams.primeFactors(13).boxed().collect(Collectors.toList()), IntStream.of(13).boxed().collect(Collectors.toList())),
				() -> assertEquals(ExercicesStreams.primeFactors(2500).boxed().collect(Collectors.toList()),
						IntStream.of(2, 2, 5, 5, 5, 5).boxed().collect(Collectors.toList())));
	}

}
