package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B3653_FilmCollection {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] films = new int[m];
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				films[j] = Integer.parseInt(st.nextToken());
			}

			ArrayList<Integer> list = new ArrayList<>();
			int idx = 0;

			for (int j = n; j >= 1; j--) {
				list.add(j);
			}

			for (int j = 0; j < m; j++) {
				int film = films[j];

				idx = list.indexOf(film);
				System.out.print(n - 1 - idx + " ");

				list.remove(idx);
				list.add(film);
//				System.out.println(list);
			}
			list.clear();
		}
		br.close();

	}

}
