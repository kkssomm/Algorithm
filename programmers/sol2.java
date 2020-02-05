package programmers;

import java.util.LinkedList;
import java.util.Scanner;

//class Node {
//	int num;
//	int val;
//
//	Node(int val, int num) {
//		this.val = val;
//		this.num = num;
//	}
//}

public class sol2 {
	public static void solution(int n, String[] s) {
		int[] answer = new int[n];
		int len=0;
		LinkedList<Node> list = new LinkedList<Node>();

		l : for (int i = 0; i < n; i++) {
			String[] ar = s[i].split(" ");
			// enqueue
			if (ar[0].equals("e")) {
				int put = Integer.parseInt(ar[1]);
				if (!list.isEmpty()) {
					for (int j = 0; j < list.size(); j++) {
						if (list.get(j).val == put) {
							list.get(j).num++;
							//System.out.println(list.get(j).num);
							continue l;
						}
					}
				}
				list.add(new Node(put, 1));
			
			}
			// dequeue
			else {
				if(list.isEmpty()) {
					System.out.print("-1");
					return;
				}
				int remove=0;
				int index =0;
				for(int j=list.size()-1;j>=0;j--) {
					if(remove<=list.get(j).num) {
						remove=list.get(j).num;
						index=j;
					}
				}
//				//System.out.println("num="+remove+" val="+list.get(index).val);
//				answer[len++]=list.get(index).val;
//				list.get(index).num--;
//				if(list.get(index).num==0) {
//					list.remove(index);
//				}
			}
		}
		for(int i=0;i<len;i++) {
			if(i==len-1) System.out.println(answer[i]);
			else System.out.print(answer[i]+" ");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String s[] = new String[n];
		for (int i = 0; i < n; i++) {
			s[i] = sc.nextLine();
		}
		solution(n, s);
		
		sc.close();
	}
}
