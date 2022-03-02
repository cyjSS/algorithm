import java.util.*;
import java.lang.*;

class Lv2_카카오프렌즈컬러링북 {
    static boolean visited[][];
    static int dr[]={-1,1,0,0}, dc[]={0,0,-1,1};
    static int maxSizeOfOneArea;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        
        visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j]!=0 && !visited[i][j]){
                    numberOfArea++;
                    bfs(m, n, i, j, picture);
                }
            }
        }
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    private static void bfs(int m, int n, int r, int c, int[][] picture){
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[] {r,c});
        visited[r][c] = true;
        int cnt = 1;
        while(!queue.isEmpty()){
            int cur[] = queue.poll();
            for(int i=0; i<4; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n && !visited[nr][nc]){
                    if(picture[nr][nc] != picture[r][c]) continue;
                    cnt++;
                    queue.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
        
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
    }
}