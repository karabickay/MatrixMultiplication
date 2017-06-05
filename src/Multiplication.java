import java.util.ArrayList;

public class Multiplication {
    private static ArrayList<ArrayList<Integer>> A;
    private static ArrayList<ArrayList<Integer>> B;
    private static  int[][] C;

    public static void setA(ArrayList<ArrayList<Integer>> A){
        Multiplication.A = A;
    }

    public static void setB(ArrayList<ArrayList<Integer>> B){
        Multiplication.B = B;
    }

    public static int[][] multiply() {
        int dimention = A.size();
        C = new int[dimention][dimention];
        for (int i = 0; i < dimention; i++) {
            for (int j = 0; j < dimention; j++) {
                int sum = 0;
                for (int k = 0; k < dimention; k++) {
                    sum += A.get(i).get(k) * B.get(k).get(j);
                }

                C[i][j] = sum;
            }
        }
        return C;
    }
}
