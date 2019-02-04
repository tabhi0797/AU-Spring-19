package com.accolite.app.BowlingAssignment;

public class App {
//	public static void main(String[] pinsFallen) {
//		try {
//			Integer[] arr = { 5, 0, 7, 3, 3, 3, 9, 0, 1, 7, 7, 2, 3, 0, 10, 10, 9, 1, 10 };
//			for (Integer integer : arr) {
//
//				System.out.println(integer);
//			}
//		} catch (Exception e) {
//		}
//	}


	public static int[] doCount(Integer... pinsFallen) {
		try {
			int[] result = new int[10];

			int i = 0;
			int frame = 0;
			int score;
			int previousScore = 0;

			for (int j = 0; j < pinsFallen.length; j++) {
				if (pinsFallen[j] < 0 || pinsFallen[j] > 10) {
					throw new Exception("incorrect value for pins fallen");
				}
			}

			while (frame < 10) {

				// strike case
				if (pinsFallen[i] == 10) {
					score = previousScore + 10 + pinsFallen[i + 1] + pinsFallen[i + 2];
					result[frame] = score;
					if (frame == 9) {
						if (pinsFallen[i + 1] < 10 && ((pinsFallen[i + 1] + pinsFallen[i + 2]) > 10)) {
							throw new Exception("incorrect values in last frame");
						}
						i += 2;
					}
					i++;
				} else {

					// spare
					if (pinsFallen[i] + pinsFallen[i + 1] == 10) {
						score = previousScore + 10 + pinsFallen[i + 2];
						result[frame] = score;
						if (frame == 9) {
							i++;
						}
					}
					// frame with total score < 10
					else if (pinsFallen[i] + pinsFallen[i + 1] < 10) {
						score = previousScore + pinsFallen[i] + pinsFallen[i + 1];
						result[frame] = score;
					}
					// frame with sum > 10
					else {
						throw new Exception("incorrect sum of pins >10");
					}
					i += 2;
				}
				previousScore = score;
				frame++;
			}
			if (i != pinsFallen.length) {
				throw new Exception("incorrect frame");
			}
			return result;
		} catch (Exception ex) {
			throw new IllegalArgumentException(ex);
		}
	}

}
