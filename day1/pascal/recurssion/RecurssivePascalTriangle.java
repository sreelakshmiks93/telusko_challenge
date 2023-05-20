package day1.pascal.recurssion;
//Print pascal trianlge using recurssive operation
public class RecurssivePascalTriangle {

	public static void main(String[] args) {
		int numRows = 10;
		for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(pascalVal(i, j) + " ");
            }
            System.out.println();
        }
	}

	public static int pascalVal(int i, int j) {
		if(i == 0 || j== 0||j ==i) {
			return 1;
		}else {
			return pascalVal(i-1,j-1)+pascalVal(i-1,j);
		}
	}
}
