package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1406_Editor {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		 
		String s = st.nextToken();
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		
		Stack<String> left = new Stack<String>();
		Stack<String> right = new Stack<String>();

		 for(int i = 0; i<s.length(); i++) {
		        left.push(String.valueOf(s.charAt(i)));
		    }

		// System.out.println(left);

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

	        String ex = st.nextToken();


			if (ex.equals("L")) {
				if (!left.isEmpty()) {
					right.add(left.pop());
					// System.out.print(left);
					// System.out.println(right);
				}
			} else if (ex.equals("D")) {
				if (!right.isEmpty()) {
					left.add(right.pop());
					// System.out.print(left);
					// System.out.println(right);
				}
			} else if (ex.equals("B")) {
				if (!left.isEmpty()) {
					left.pop();
					// System.out.print(left);
					// System.out.println(right);
				}
			} else if (ex.equals("P")) {
				left.add(st.nextToken());
				// System.out.print(left);
				// System.out.println(right);
				// System.out.println(c);
			}
		}

		Stack<String> temp = new Stack<>();

		int l = left.size();
		int r = right.size();

		for (int i = 0; i < l; i++) {
			temp.add(left.pop());
		}
		for (int i = 0; i < l; i++) {
			System.out.print(temp.pop());
		}
		for (int i = 0; i < r; i++) {
			System.out.print(right.pop());
		}
	}

}
