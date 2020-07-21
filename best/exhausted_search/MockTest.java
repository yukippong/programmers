package best.exhausted_search;

//https://programmers.co.kr/learn/courses/30/lessons/42840
//문제 설명
//수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
//
//1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
//2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
//3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
//
//1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
//
//제한 조건
//시험은 최대 10,000 문제로 구성되어있습니다.
//문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
//가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
//입출력 예
//answers	return
//[1,2,3,4,5]	[1]
//[1,3,2,4,2]	[1,2,3]
//입출력 예 설명
//입출력 예 #1
//
//수포자 1은 모든 문제를 맞혔습니다.
//수포자 2는 모든 문제를 틀렸습니다.
//수포자 3은 모든 문제를 틀렸습니다.
//따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
//
//입출력 예 #2
//
//모든 사람이 2문제씩을 맞췄습니다.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockTest {
	public static int[] solution(int[] answers) {
		int[] result = {};

		/////////////
		int[] s1Ans = new int[answers.length];
		for (int i = 0; i <= answers.length; i = i + 5) {
			for (int k = 1; k <= 5; k++) {
				if ((i + k) - 1 >= answers.length) {
					break;
				}
				s1Ans[(i + k) - 1] = k;
			}
		}

		/////////////
		int[] s2Ans = new int[answers.length];
		int[] s2Pattern = { 2, 1, 2, 3, 2, 4, 2, 5 };
		for (int i = 0; i <= answers.length; i = i + s2Pattern.length) {
			for (int k = 0; k < s2Pattern.length; k++) {
				if (i + k >= answers.length) {
					break;
				}

				s2Ans[i + k] = s2Pattern[k];
			}
		}

		//////////////
		int[] s3Ans = new int[answers.length];
		int[] s3Pattern = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		for (int i = 0; i <= answers.length; i = i + s3Pattern.length) {
			for (int k = 0; k < s3Pattern.length; k++) {
				if (i + k >= answers.length) {
					break;
				}
				s3Ans[i + k] = s3Pattern[k];
			}
		}

		int[] correctCnt = new int[] { 0, 0, 0 };

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == s1Ans[i]) {
				correctCnt[0]++;
			}
			if (answers[i] == s2Ans[i]) {
				correctCnt[1]++;
			}
			if (answers[i] == s3Ans[i]) {
				correctCnt[2]++;
			}
		}

		int max = 0;
		for (int i = 0; i < correctCnt.length; i++) {
			if (correctCnt[i] > max) {
				max = correctCnt[i];
			}
		}

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < correctCnt.length; i++) {
			if (max == correctCnt[i]) {
				list.add(i + 1);
			}
		}

		result = list.stream().mapToInt(i -> i).toArray();

		return result;
	}

	public static void main(String[] args) {
//		answers	return
//		[1,2,3,4,5]	[1]
//		[1,3,2,4,2]	[1,2,3]

		List<int[]> testCase = new ArrayList();
		testCase.add(new int[] { 1, 2, 3, 4, 5 });
		testCase.add(new int[] { 1, 3, 2, 4, 2 });

		for (int[] answers : testCase) {
			int[] resultArr = solution(answers);
			System.out.println(Arrays.toString(resultArr));
		}
	}

}
