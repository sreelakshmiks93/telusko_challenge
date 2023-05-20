package day1.pascal.iteration;
// Build pascal triangle using normal iteration
public class PascalsTriangle {

	public static void main(String[] args) {
		int rowSize = 10;
		int[][] triangle = new int[rowSize][];
		for (int i = 0; i < rowSize; i++) {
			triangle[i] = new int[i + 1];
			if(i == 0)
			System.out.print(1+" \n");
			for (int j = 1; j < i; j++) {
					triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
					System.out.print(triangle[i][j]+" ");
			}
			triangle[i][i] = 1;
			System.out.print(1+" \n");
		}
		
	}
}
