package best.greedy;

//ü����

//���� ����
//���ɽð��� ������ ���, �Ϻ� �л��� ü������ �������߽��ϴ�. ������ ���� ü������ �ִ� �л��� �̵鿡�� ü������ �����ַ� �մϴ�. �л����� ��ȣ�� ü�� ������ �Ű��� �־�, �ٷ� �չ�ȣ�� �л��̳� �ٷ� �޹�ȣ�� �л����Ը� ü������ ������ �� �ֽ��ϴ�. ���� ���, 4�� �л��� 3�� �л��̳� 5�� �л����Ը� ü������ ������ �� �ֽ��ϴ�. ü������ ������ ������ ���� �� ���� ������ ü������ ������ ���� �ִ��� ���� �л��� ü�������� ���� �մϴ�.
//
//��ü �л��� �� n, ü������ �������� �л����� ��ȣ�� ��� �迭 lost, ������ ü������ ������ �л����� ��ȣ�� ��� �迭 reserve�� �Ű������� �־��� ��, ü�������� ���� �� �ִ� �л��� �ִ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
//
//���ѻ���
//��ü �л��� ���� 2�� �̻� 30�� �����Դϴ�.
//ü������ �������� �л��� ���� 1�� �̻� n�� �����̰� �ߺ��Ǵ� ��ȣ�� �����ϴ�.
//������ ü������ ������ �л��� ���� 1�� �̻� n�� �����̰� �ߺ��Ǵ� ��ȣ�� �����ϴ�.
//���� ü������ �ִ� �л��� �ٸ� �л����� ü������ ������ �� �ֽ��ϴ�.
//���� ü������ ������ �л��� ü������ ���������� �� �ֽ��ϴ�. �̶� �� �л��� ü������ �ϳ��� �������ߴٰ� �����ϸ�, ���� ü������ �ϳ��̱⿡ �ٸ� �л����Դ� ü������ ������ �� �����ϴ�.
//����� ��
//n	lost	reserve	return
//5	[2, 4]	[1, 3, 5]	5
//5	[2, 4]	[3]	4
//3	[3]	[1]	2
//����� �� ����
//���� #1
//1�� �л��� 2�� �л����� ü������ �����ְ�, 3�� �л��̳� 5�� �л��� 4�� �л����� ü������ �����ָ� �л� 5���� ü�������� ���� �� �ֽ��ϴ�.
//
//���� #2
//3�� �л��� 2�� �л��̳� 4�� �л����� ü������ �����ָ� �л� 4���� ü�������� ���� �� �ֽ��ϴ�.
//
//��ó
//
//�� ���� - 2019�� 2�� 18�� ������ ������Ǿ����ϴ�.
//�� ���� - 2019�� 2�� 27��, 28�� �׽�Ʈ���̽��� �߰��Ǿ����ϴ�.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Sports {
	int n;
	int[] lost;
	int[] reverse;

	Sports(int n, int[] lost, int[] reserve) {
		this.n = n;
		this.lost = lost;
		this.reverse = reserve;
	}
}

public class SportsWear {
	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 1; i <= n; i++) {
			map.put(i, 1);
		}

		for (int i = 0; i < lost.length; i++) {
			int key = lost[i];
			map.replace(key, map.get(key) - 1);
		}

		for (int i = 0; i < reserve.length; i++) {
			int key = reserve[i];
			map.replace(key, map.get(key) + 1);
		}

		for (int key : map.keySet()) {
			int value = map.get(key);
			if (value == 0) {
				if (null != map.get(key - 1) && map.get(key - 1) >= 2) {
					map.replace(key, map.get(key) + 1);
					map.replace(key - 1, map.get(key - 1) - 1);
				} else if (null != map.get(key + 1) && map.get(key + 1) >= 2) {
					map.replace(key, map.get(key) + 1);
					map.replace(key + 1, map.get(key + 1) - 1);
				}
			}
		}

		for (int key : map.keySet()) {
			System.out.println(String.format("key:%d,value:%d", key, map.get(key)));
		}

		for (int key : map.keySet()) {
			int value = map.get(key);
			if (value >= 1) {
				answer++;
			}
		}

		return answer;
	}

	public static void main(String[] args) {

//		n	lost	reserve	return
//		5	[2, 4]	[1, 3, 5]	5
//		5	[2, 4]	[3]			4
//		3	[3]		[1]			2

		List<Sports> testCase = new ArrayList<Sports>();
		testCase.add(new Sports(5, new int[] { 2, 4 }, new int[] { 1, 3, 5 }));
		testCase.add(new Sports(5, new int[] { 2, 4 }, new int[] { 3 }));
		testCase.add(new Sports(3, new int[] { 3 }, new int[] { 1 }));

		for (Sports ele : testCase) {
			int answer = solution(ele.n, ele.lost, ele.reverse);
			System.out.println(String.format("-------------- ANSWER: %s ----------------", answer));
		}
	}

}
