package com.accolite.app.BowlingAssignment;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AppTest {

	@Test
	public void testDoCountNoScore() {
		assertArrayEquals(App.doCount( 0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,
				 0 ,  0 ,  0 ),  new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
	}

	@Test
	public void testDoCountOnlyTens() {
		assertArrayEquals(App.doCount( 10 ,  10 ,  10 ,  10 ,  10 ,  10 ,  10 ,  10 ,  10 ,  10 ,  10 ,  10 ),
				 new int[] { 30, 60, 90, 120, 150, 180, 210, 240, 270, 300 });
	}

	@Test
	public void testDoCountLastFrameWithoutStrike() {
		assertArrayEquals(App.doCount( 0 ,  0 ,  0 ,  1 ,  0 ,  0 ,  0 ,  6 ,  10 ,  0 ,  5 ,  0 ,  0 ,  0 ,  3 ,  5 ,  0 ,
				 6 ,  0 ),  new int[] { 0, 1, 1, 7, 22, 27, 27, 30, 35, 41 });
	}

	@Test
	public void testDoCountLastFrameWithStrike() {
		assertArrayEquals(App.doCount( 5 ,  0 ,  7 ,  3 ,  3 ,  3 ,  9 ,  0 ,  1 ,  7 ,  7 ,  2 ,  3 ,  0 ,  10 ,  10 ,
				 10 ,  1 ,  9 ),  new int[] { 5, 18, 24, 33, 41, 50, 53, 83, 104, 124 });
	}

	@Test
	public void testDoCountLastFrameWithSpare() {
		assertArrayEquals(App.doCount( 5 ,  0 ,  7 ,  3 ,  3 ,  3 ,  9 ,  0 ,  1 ,  7 ,  7 ,  2 ,  3 ,  0 ,  10 ,  10 ,
				 9 ,  1 ,  10 ),  new int[] { 5, 18, 24, 33, 41, 50, 53, 82, 102, 122 });
	}

	@Test
	public void testNumberOfStrikesOk() {
		App.doCount( 5 ,  0 ,  7 ,  3 ,  3 ,  3 ,  9 ,  0 ,  1 ,  7 ,  7 ,  2 ,  3 ,  0 ,  10 ,  10 ,  9 ,  1 ,
				 10 );
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNoArguments() {
		App.doCount();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMinimumInput() {
		App.doCount( 0 ,  0 ,  0 );
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMaximumInput() {
		App.doCount( 0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,
				 0 ,  0 ,  0 );
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBigSumInOneFrame() {
		App.doCount( 9 ,  2 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,
				 0 );
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBigSumInLastFrame() {
		App.doCount( 9 ,  1 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  5 ,
				 6 );
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInputSize() {
		App.doCount( 11 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 );
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInputType() {
		App.doCount( 0 ,  -2 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 );
	}

	@Test
	public void testFirstStrikeOnWrongPosition() {
		App.doCount( 0 ,  10 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,
				 0 );
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegativeValue() {
		App.doCount( 9 ,  -3 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,
				 0 );
	}

	@Test(expected = IllegalArgumentException.class)
	public void testStrikeOnWrongPosition() {
		App.doCount( 10 ,  0 ,  10 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,  0 ,
				 0 );
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLastFrameSizeTwoSpare() {
		App.doCount( 0 ,  0 ,  0 ,  1 ,  0 ,  0 ,  0 ,  6 ,  10 ,  0 ,  5 ,  0 ,  0 ,  0 ,  3 ,  5 ,  0 ,  6 ,  4 );
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLastFrameSizeTwoStrike() {
		App.doCount( 0 ,  0 ,  0 ,  1 ,  0 ,  0 ,  0 ,  6 ,  10 ,  0 ,  5 ,  0 ,  0 ,  0 ,  3 ,  5 ,  0 ,  10 ,
				 0 );
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLastFrameSizeThreeNoSpare() {
		App.doCount( 0 ,  0 ,  0 ,  1 ,  0 ,  0 ,  0 ,  6 ,  10 ,  0 ,  5 ,  0 ,  0 ,  0 ,  3 ,  5 ,  0 ,  6 ,  2 ,
				 4 );
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLastFrameSizeThreeNoStrike() {
		App.doCount( 0 ,  0 ,  0 ,  1 ,  0 ,  0 ,  0 ,  6 ,  10 ,  0 ,  5 ,  0 ,  0 ,  0 ,  3 ,  5 ,  0 ,  1 ,  0 ,
				 4 );
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNumberOfStrikes() {
		App.doCount( 10 ,  1 ,  0 ,  1 ,  0 ,  1 ,  0 ,  9 ,  0 ,  1 ,  1 ,  0 ,  2 ,  5 ,  4 ,  10 ,  4 ,  1 ,  2 ,
				 3 ,  0 );
	}
}
