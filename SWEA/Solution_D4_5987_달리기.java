package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_D4_5987_달리기 {
    static int N,M;
    static int[] needs;
    static long[] memo;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int f,s;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; ++t) {
            st = new StringTokenizer(br.readLine(), " ");
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
 
            needs=new int[N];
            memo=new long[(1<<N)];
            for(int m=0; m<M; ++m) {
                st = new StringTokenizer(br.readLine(), " ");
                f=Integer.parseInt(st.nextToken())-1;
                s=Integer.parseInt(st.nextToken())-1;
                needs[f] |=(1<<s); 
            }
            System.out.println("#"+t+" "+dfs(0));
        }
    }
     
    static long dfs(int flag) {
    
        if(flag == (1<<N)-1){
            return 1;
        }
        //memoi
        if(memo[flag]>0){
            return memo[flag];
        }
        // 순열 1 
        for(int i=0; i<N;++i) {
        	// 순열 2
            if((flag &1<<i)==0 ) {
            	// 주어진순서대로 진행한다. 
            	if((flag & needs[i])==needs[i]){
            		// 순열 3 +  memoi
            		memo[flag]+=dfs(flag | 1<<i);
            	}
            }
        }
        return memo[flag];
    }
}
/*

3
3 2
1 2
1 3
5 5
1 2
2 5
1 3
3 4
4 5
16 1
5 9

 */



