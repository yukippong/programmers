package best.hash;

//����Ʈ�ٹ�
//���� ����
//��Ʈ���� ����Ʈ���� �帣 ���� ���� ���� ����� �뷡�� �� ���� ��� ����Ʈ �ٹ��� ����Ϸ� �մϴ�. �뷡�� ���� ��ȣ�� �����ϸ�, �뷡�� �����ϴ� ������ ������ �����ϴ�.
//
//���� �뷡�� ���� ����� �帣�� ���� �����մϴ�.
//�帣 ������ ���� ����� �뷡�� ���� �����մϴ�.
//�帣 ������ ��� Ƚ���� ���� �뷡 �߿����� ���� ��ȣ�� ���� �뷡�� ���� �����մϴ�.
//�뷡�� �帣�� ��Ÿ���� ���ڿ� �迭 genres�� �뷡�� ��� Ƚ���� ��Ÿ���� ���� �迭 plays�� �־��� ��, ����Ʈ �ٹ��� �� �뷡�� ���� ��ȣ�� ������� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
//
//���ѻ���
//genres[i]�� ������ȣ�� i�� �뷡�� �帣�Դϴ�.
//plays[i]�� ������ȣ�� i�� �뷡�� ����� Ƚ���Դϴ�.
//genres�� plays�� ���̴� ������, �̴� 1 �̻� 10,000 �����Դϴ�.
//�帣 ������ 100�� �̸��Դϴ�.
//�帣�� ���� ���� �ϳ����, �ϳ��� � �����մϴ�.
//��� �帣�� ����� Ƚ���� �ٸ��ϴ�.
//����� ��
//genres	plays	return
//[classic, pop, classic, classic, pop]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
//����� �� ����
//classic �帣�� 1,450ȸ ����Ǿ�����, classic �뷡�� ������ �����ϴ�.
//
//���� ��ȣ 3: 800ȸ ���
//���� ��ȣ 0: 500ȸ ���
//���� ��ȣ 2: 150ȸ ���
//pop �帣�� 3,100ȸ ����Ǿ�����, pop �뷡�� ������ �����ϴ�.
//
//���� ��ȣ 4: 2,500ȸ ���
//���� ��ȣ 1: 600ȸ ���
//���� pop �帣�� [4, 1]�� �뷡�� ����, classic �帣�� [3, 0]�� �뷡�� �״����� �����մϴ�.
//
//�� ���� - 2019�� 2�� 28�� �׽�Ʈ���̽��� �߰��Ǿ����ϴ�.

import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BestAlbumn {
	public static int[] solution(String[] genres, int[] plays) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		Map<String, Map<Integer, Integer>> playsMap = new HashMap<String, Map<Integer, Integer>>();

		for (int i = 0; i < genres.length; i++) {
			String key = genres[i];
			map.put(key, map.getOrDefault(key, 0) + plays[i]);

			///////////
			if (null == playsMap.get(key)) {
				playsMap.put(key, new HashMap<Integer, Integer>());
			}
			Map<Integer, Integer> subMap = playsMap.get(key);
			subMap.put(i, plays[i]);
			playsMap.put(key, subMap);
		}

		List<String> keySetList = new ArrayList<>(map.keySet());
		Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
		List<Integer> selectedList = new ArrayList<Integer>();

		for (String key : keySetList) {
			System.out.println("key : " + key + " / " + "value : " + map.get(key));

			Map<Integer, Integer> playSubMap = playsMap.get(key);

			List<Integer> subKeySetList = new ArrayList<>(playSubMap.keySet());
			Collections.sort(subKeySetList, (o1, o2) -> (playSubMap.get(o2).compareTo(playSubMap.get(o1))));

			int cnt = 0;
			for (Integer subKey : subKeySetList) {
				if (cnt >= 2) {
					break;
				}
				selectedList.add(subKey);
				cnt++;
				System.out.println("subKey : " + subKey + " / " + "value : " + playSubMap.get(subKey) + " cnt:" + cnt);

			}
		}

		int[] answer = selectedList.parallelStream().mapToInt(Integer::intValue).toArray();

		return answer;
	}

	public static void main(String[] args) {

		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };

		int[] answer = solution(genres, plays);
		for (int a : answer) {
			System.out.println(a);
		}

	}

}
