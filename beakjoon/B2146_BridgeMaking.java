package beakjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2146_BridgeMaking {
	 
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Pairs> q = new LinkedList<>();
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int mark = 2;
    static int min = Integer.MAX_VALUE;
    
    public static void main (String[] args)  {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        
        map = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        
        mark();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 0 || !isEdge(i, j))
                    continue;
                visited = new boolean[N][N];
                
                int cnt = 0;
                int idx = map[i][j];
                
                visited[i][j] = true;
                q.add(new Pairs(i, j));
                
                loop: while(!q.isEmpty()) {
                    int size = q.size();
                    
                    for (int s = 0; s < size; s++) {
                        
                        Pairs cur = q.poll();
                        
                        if(map[cur.x][cur.y] != idx && map[cur.x][cur.y] > 0) {
                            q.clear();
                            break loop;
                        }
                        
                        for (int k = 0; k < 4; k++) {
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];
                            
                            if(!isRange(nx, ny) || visited[nx][ny] || map[nx][ny] == idx) 
                                continue;
                            
                            visited[nx][ny] = true;
                            q.add(new Pairs(nx, ny));
                        }
                        
                    }
                    cnt++;
                }
                min = Math.min(min, cnt-1);
            }
        }
        System.out.println(min);
        sc.close();
    }
    
    static boolean isEdge(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(!isRange(nx,ny) || map[nx][ny] != 0) continue;
            return true;
        }
        return false;
    }
    
    static void mark() {
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] != 1) continue;
                
                map[i][j] = mark;
                q.add(new Pairs(i, j));
                
                while(!q.isEmpty()) {
                    Pairs cur = q.poll();
                    
                    for (int k = 0; k < 4; k++) {
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];
                        
                        if(!isRange(nx, ny) || map[nx][ny] != 1) continue;
                        
                        map[nx][ny] = mark;
                        q.add(new Pairs(nx, ny));
                    }
                }
                mark++;
            }
        }
    }
    
    static boolean isRange(int x, int y) {
        if( x < 0 || x >= N || y < 0 || y >= N) return false;
        return true;
    }
 
}