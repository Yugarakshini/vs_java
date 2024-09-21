import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] mat = new int[r][c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                mat[i][j] = s.nextInt();
            }
        }
        for(int i=0;i<r;i++){
            int j = i;

            while(j>0 && getEvenCount(mat,j) < getEvenCount(mat,j-1)){
                swapRows(mat,j,j-1);
                j--;
            }
        }
        for(int i=0;i<r;i++) {
		    for(int j=0;j<c;j++) {
		        System.out.print(mat[i][j]+" ");
		    }
		    System.out.println();
		}
    }
        
        static int getEvenCount(int[][] mat,int i) {
            int ctr = 0;
            for(int j = 0;j<mat[i].length;j++) {
                if(mat[i][j]%2 == 0) {
                    ctr++;
                }
            }
            return ctr;
        }
        static void swapRows(int[][] mat,int i,int j) {
            for(int k=0;k<mat[i].length;k++) {
                int t = mat[i][k];
                mat[i][k] = mat[j][k];
                mat[j][k] = t;
            }
        }
    
}
