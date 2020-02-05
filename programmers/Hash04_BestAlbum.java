package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class Hash04_BestAlbum {
	public int[] solution(String[] genres, int[] plays) {

		TreeMap<Integer, String> tmap = new TreeMap<>();
		HashMap<Integer, String> gmap = new HashMap<>();
		HashMap<String, Integer> smap = new HashMap<>();
		int size = 0;

		for (int i = 0; i < genres.length; i++) {
			boolean check = false;
			for (Integer key : tmap.keySet()) {
				if (genres[i].equals(tmap.get(key))) {
					tmap.put(key + plays[i], tmap.get(key));
					tmap.remove(key);
					check = true;
					break;
				}
			}
			if (!check) {
				tmap.put(plays[i], genres[i]);
				size = size + 2;
			}
			gmap.put(i, genres[i]);
			smap.put(genres[i], smap.getOrDefault(genres[i], 0) + 1);
//			System.out.println(gmap);
//			System.out.println(tmap);
//			System.out.println(smap);
		}

		int[] answer = new int[size];
		for (Integer key : tmap.keySet()) {
			String genre = tmap.get(key);
			int len = smap.get(genre);
			int[][] playArr = new int[len][2];
			int index = 0;
			// System.out.println(smap.get(genre));
			for (Integer num : gmap.keySet()) {
				if (genre.equals(gmap.get(num))) {
					playArr[index][0] = plays[num];
					playArr[index][1] = num;
//					System.out.println(playArr[index][0] + " " + playArr[index][1]);
					index++;
				}
			}
			Arrays.sort(playArr, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[0] == o2[0]) {
						return Integer.compare(o1[1], o2[1]);
					} else
						return Integer.compare(o1[0], o2[0]);
				}

			});
//			for(int i = 0 ;i<len;i++) {
//				System.out.println(playArr[i][0] + " " + playArr[i][1]);
//			}
			len = len - 2;
			answer[--size] = playArr[len][1];
			len++;
			answer[--size] = playArr[len][1];
		}
		for(int i: answer) {
			System.out.println(i);
		}
		return answer;
	}

	public static void main(String[] args) {
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };
		int answer[];
		Hash04_BestAlbum s = new Hash04_BestAlbum();
		answer = s.solution(genres, plays);

		for (int i = 0; i < answer.length; i++)
			System.out.print(answer[i] + " ");
	}

}
