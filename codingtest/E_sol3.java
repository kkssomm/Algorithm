package codingtest;

public class E_sol3 {
	public static int solution(int[] A) {
		int answer = 0;
		int[] tree = new int[A.length];
		boolean flag = false;
		if (A[0] < A[1])
			tree[0] = 0;
		if (A[0] > A[1])
			tree[0] = 1;

		for (int i = 1; i < tree.length; i++) {
			if (A[i - 1] == A[i])
				tree[i] = tree[i - 1];
			if (A[i] > A[i - 1])
				tree[i] = 1;
			if (A[i] < A[i - 1])
				tree[i] = 0;
		}
		for (int i : tree) {
			System.out.print(" " + i);
		}
		System.out.println();

		int check = tree[0];
		int count = 1;
		for (int i = 1; i < tree.length; i++) {
			if (tree[i] == check) {
				if (flag == true)
					return -1;

				flag = true;
				count++;
				/////
				if (i <= 1) {
					if (tree[i] < tree[i + 1]) {
						if (tree[i + 1] < tree[i + 2]) {
							continue;
						} else {
							answer++;
						}
					} else {
						if (tree[i + 1] > tree[i + 2]) {
							continue;
						} else {
							answer++;
						}
					}

				} else if (i <= 2) {
					if (tree[i - 1] < tree[i]) {
						if (tree[i] < tree[i + 1]) {
							continue;
						} else {
							answer++;
						}
					} else {
						if (tree[i] > tree[i + 1]) {
							answer++;
							System.out.println("g");
						}
					}
					
					if(tree[i-2]<tree[i] || tree[i-2]>tree[i]) {
						answer++;
						System.out.println("gg");
					}
					
					if(tree[i-1]<tree[i+1] || tree[i-1] > tree[i+1]) {
						answer++;
						System.out.println("ggg");
					}
				}
				/////
			}
			check = tree[i];
		}

		return answer;

	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 7 };
		int answer = solution(A);
		System.out.println(answer);
	}

}
