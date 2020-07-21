package best.exhausted_search;

//https://programmers.co.kr/learn/courses/30/lessons/42840
//���� ����
//�����ڴ� ������ ������ ����� �ظ��Դϴ�. ������ ���ι��� ���ǰ�翡 ���� ������ ���� ������ �մϴ�. �����ڴ� 1�� �������� ������ �������� ������ ���� ����ϴ�.
//
//1�� �����ڰ� ��� ���: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
//2�� �����ڰ� ��� ���: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
//3�� �����ڰ� ��� ���: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
//
//1�� �������� ������ ���������� ������ ������� ���� �迭 answers�� �־����� ��, ���� ���� ������ ���� ����� �������� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
//
//���� ����
//������ �ִ� 10,000 ������ �����Ǿ��ֽ��ϴ�.
//������ ������ 1, 2, 3, 4, 5�� �ϳ��Դϴ�.
//���� ���� ������ ���� ����� ������ ���, return�ϴ� ���� �������� �������ּ���.
//����� ��
//answers	return
//[1,2,3,4,5]	[1]
//[1,3,2,4,2]	[1,2,3]
//����� �� ����
//����� �� #1
//
//������ 1�� ��� ������ �������ϴ�.
//������ 2�� ��� ������ Ʋ�Ƚ��ϴ�.
//������ 3�� ��� ������ Ʋ�Ƚ��ϴ�.
//���� ���� ������ ���� ���� ����� ������ 1�Դϴ�.
//
//����� �� #2
//
//��� ����� 2�������� ������ϴ�.

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
