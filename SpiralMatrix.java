public class SpiralMatrix 
{
    // initialising the matrix
    int[][] matrix1 = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    // initialising the 4 variables to navigate the matrix
    int top = 0,left = 0,right = 2, bottom = 2;
    int dir=0;// 1 variable to change direction while printing the matrix 

    public void run()
    {
        while(top<=bottom && left<=right)//base condition
        {
        if(dir==0)//initially dir=0 --> after this it will go to line44
        {
            for(int i=left;i<=right;i++)
                System.out.print(matrix1[top][i]);
            top+=1;  
        }
        if(dir==1)
        {
            for(int i=top;i<=bottom;i++)
            {
                System.out.print(matrix1[i][right]);
            }right-=1;
        }
        if(dir==2)
        {
            for(int i=right;i>=left;i--){
                System.out.print(matrix1[bottom][i]);
            }
            bottom-=1;
        }
        if(dir==3)
        {
            for(int i=bottom;i>=top;i--){
                System.out.print(matrix1[i][left]);
            }
            left+=1;
        }
        dir=(dir+1)%4;
        }
    }
    
    public static void main(String[] args){
        SpiralMatrix sm = new SpiralMatrix();
        System.out.println("Spiral order of the matrix:");
        sm.run();
    }

}
