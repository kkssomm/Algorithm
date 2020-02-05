package kakaoIntern2019winter;

import java.util.Stack;

public class solution2 {
	
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int len = board.length;
        int[][] board2 = new int[len][len];
        Stack<Integer> s = new Stack<>();
        
        // 배열 만들기
        for(int i=0;i<len;i++) {
        	for(int j=0;j<len;j++) {
        		board2[j][i]=board[i][j];
        	}
        }
        
        // 뽑기
        for(int i=0;i<moves.length;i++) {
        	int index = moves[i]-1;
        	int[] arr = board2[index];
        	int pick = 0;
        	
        	//
        	for(int j=0;j<len;j++) {
        		if(arr[j]!=0) {
        			pick=arr[j];
        			board2[index][j]=0;
        			break;
        		}
        	}
        	
        	// 뽑힌 인형이 있을 때 
        	if(pick!=0) {
        		if(!s.isEmpty()) {
        			// 터뜨린다
        			if(s.peek()==pick) {
        				s.pop();
        				answer=answer+2;
        			}
        			// 넣는다
        			else {
        				s.add(pick);
        			}
        		}
        		// 넣는다
        		else {
        			s.add(pick);
        		}
        	}
        	
        }
        
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[][] board =  {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int [] moves = {1,5,3,5,1,2,1,4};
	
		int answer = solution(board,moves);
		System.out.println(answer);
	}
}
