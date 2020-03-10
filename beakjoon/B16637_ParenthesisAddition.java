package beakjoon;

import java.util.Scanner;

public class B16637_ParenthesisAddition {
	
	static int answer;
	static int n;
	static int[] operation;
	static char[] operator;
	
	public static void dfs(int idx, int result) {
		// System.out.println("idx"+idx+" res"+result);
		
		// �������� �ε����� �ʰ��ϸ� Ż��
		if(idx>=n/2) {
			// �ִ��� ������Ʈ
			if(answer<result) {
				answer=result;
			}
			//System.out.println("ans"+answer);
			return;
		}
		
		// ������ ���
		//System.out.println("1");
		int ret = cal(result,operator[idx], operation[idx+1]);
		dfs(idx+1, ret);
		// System.out.println("idx"+idx);
		
		// �ε��� +2�� ���Ͽ� ��ȣ ���
		if(idx+1<n/2) {
			//System.out.println("2");
			ret = cal(result,operator[idx],cal(operation[idx+1],operator[idx+1],operation[idx+2]));
			System.out.println(ret);
			dfs(idx+2,ret);
		}
	}
	
	public static int cal(int a, char op, int b) {
		switch(op) {
		case '+':
			return a+b;
		case '-':
			return a-b;
		case '*':
			return a*b;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		operation = new int[n/2+1];
		operator = new char[n/2];
		int idx1 = 0;
		int idx2 = 0;
		
		// input�� ������, �ǿ����ڸ� ������ ����
		String in = sc.next();
		for(int i =0;i<in.length();i++) {
			if(in.charAt(i)=='+'||in.charAt(i)=='-'||in.charAt(i)=='*') {
				operator[idx2++] = in.charAt(i);
			}
			else {
				operation[idx1++] = Integer.parseInt(in.charAt(i)+"");
			}
		}
	
		answer = Integer.MIN_VALUE;
		dfs(0, operation[0]);
		System.out.println(answer);
	}

}
