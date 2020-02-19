package beakjun;

import java.util.Scanner;

public class B16637_ParenthesisAddition {
	
	static int answer;
	static int n;
	static int[] operation;
	static char[] operator;
	
	public static void dfs(int idx, int result) {
		// System.out.println("idx"+idx+" res"+result);
		
		// 연산자의 인덱스를 초과하면 탈출
		if(idx>=n/2) {
			// 최댓값을 업데이트
			if(answer<result) {
				answer=result;
			}
			//System.out.println("ans"+answer);
			return;
		}
		
		// 순차적 계산
		//System.out.println("1");
		int ret = cal(result,operator[idx], operation[idx+1]);
		dfs(idx+1, ret);
		// System.out.println("idx"+idx);
		
		// 인덱스 +2에 대하여 괄호 계산
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
		
		// input의 연산자, 피연산자를 나누어 저장
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
