package programmers;

public class DfsBfs03_WordChange {
	static boolean visited[];
	static int answer = 0;

	public int solution(String begin, String target, String[] words) {
		visited = new boolean[words.length];
		dfs(begin, target, words, 0);

		return answer;
	}
	
	// 단어변환
	public static void dfs(String begin, String target, String[] words, int count) {
		//System.out.println(begin + "->"+target +" "+ count);		
		
		// 단어 변환이 완료된 경우
		if(begin.equals(target)) {
			answer = count;
			//System.out.println(answer);
			return;
		}
		
		// 단어 변환이 진행 중인 경우
		for(int i=0;i<words.length;i++) {
			if(!visited[i]) {
				if(diff(begin,words[i])) {
					visited[i]=true;
//					System.out.println(Arrays.toString(visited));

					// begin <- word / count <- count+1
					dfs(words[i],target,words,count+1);
					visited[i]=false;
				}
			}
		}
	}
	
	// word가 변환 가능한 단어인지 체크
	public static boolean diff(String begin, String word) {
		int diffCount = 0;
		for(int i=0;i<word.length();i++) {
			if(begin.charAt(i)!=word.charAt(i)){
				diffCount++;
			}
		}
		if(diffCount==1) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log","cog"};

		DfsBfs03_WordChange s = new DfsBfs03_WordChange();
		int result = s.solution(begin, target, words);
		System.out.println(result);
	}

}
