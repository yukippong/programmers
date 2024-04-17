import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] answer = solution(4);

        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(int n) {
        int matrix[][] = new int[n][n];

        int count = 0;
        int inc = 1;
        int i = 0; int j = 0;

        int totalLen = 0;
        
        for(int index = n; index > 0; index--, count++){
           int mod  = count % 3;

           System.out.println("=================");
           System.out.printf("index=%d, mod=%d %n", index, mod);

            if(mod == 0) {
                System.out.printf("i=%d, j=%d %n", i, j);

                for(int k=0; k < index; k++) {
                    matrix[i][j] = inc;
                    System.out.printf("a[%d][%d]=[%d] %n", i, j, inc);
                    inc++;
                    i++;
                }                
            }
            else if(mod == 1) {
                i--;
                j++;
                System.out.printf("i=%d, j=%d %n", i, j);                

                for(int k=0; k < index; k++) {
                    matrix[i][j] = inc;
                    System.out.printf("a[%d][%d]=[%d] %n", i, j, inc);
                    inc++;
                    j++;
                }
            }
            else if(mod == 2) {
                i--; 
                j-=2;
                System.out.printf("i=%d, j=%d %n", i, j);
                
                for(int k=0; k < index; k++) {
                    matrix[i][j] = inc;
                    System.out.printf("a[%d][%d]=[%d] %n", i, j, inc);
                    inc++;
                    i--; j--;
                }
                
                i+=2;
                j++;
            }
            
            totalLen+=index;
        }
        
        int[] answer = new int[totalLen];
        int answerIndex = 0;

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                System.out.print(matrix[a][b] + " ");
                if(matrix[a][b] > 0 && answerIndex < answer.length) {
                    answer[answerIndex] = matrix[a][b];
                    answerIndex++;
                }
            }
            System.out.println();
        }
        
        return answer;
    }
    
}
