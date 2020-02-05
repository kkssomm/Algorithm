package line2019;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class sol2 {
	public static String solution(String[] ar, int k) {
		StringBuffer answer = new StringBuffer();
		int num = ar.length;
		Arrays.sort(ar);
		LinkedList<String> list = new LinkedList<String>();
		for(String i:ar) {
			list.add(i);
		}
				
		k--;
		for (int i = 0; i < ar.length; i++) {
			int m = func(num-1);
			int index=k;
			if(m!=0) {
				index=k/m;
				k%=m;
			}
			
			//System.out.println("ind "+index);
			//System.out.println("k "+k);
			answer.append(list.get(index));
			list.remove(list.get(index));
			//System.out.println(list);
			num--;
		}
		return answer.toString();
	}

	static int func(int n) {
		if (n <= 1) {
			return n;
		} else {
			return func(n - 1) * n;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String[] ar = s.split(" ");
		int k = sc.nextInt();

		sc.close();

		System.out.println(solution(ar, k));
	}

}
