package kakao2019;

import java.util.*;

public class failureRate {
	
	static class Node{
		int stage;
		double rate;
		Node(int stage,double rate){
			this.stage = stage;
			this.rate =rate;
		}
	}
	
	public static int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		int players = stages.length;
		int index=0;
		int[] success = new int[N+1];
		List<Node> node = new ArrayList<Node>();
		
		//Arrays.sort(stages);		
		for(int i=0;i<stages.length;i++) {
			success[stages[i]-1]++;
		}
		
		for(int i=0;i<N;i++) {
			node.add(new Node(i+1,success[i]==0? 0:(double)success[i]/players));
			players=players-success[i];
		}
//		for(Node i:node) {
//			System.out.print(" "+i.rate);
//		}
//		System.out.println();
		
		Comparator<Node> comparator = new Comparator<Node>() {
			@Override
			public int compare(Node a, Node b) {
				if(a.rate <b.rate) {
					return 1;
				}
				else if(a.rate >b.rate) {
					return -1;
				}
				else {
					if(a.stage>b.stage) {
						return 1;
					}
					else if(a.stage<b.stage) {
						return -1;
					}
				}
				return 0;
			}
		};
		Collections.sort(node,comparator);
		for(int i=0;i<N;i++) {
			answer[i]=node.get(i).stage;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		int N = 5;
		int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };
		int[] answer = solution(N, stages);
		System.out.println("ans");
		for (int s : answer) {
			System.out.print(" "+s);
		}
	}
}
