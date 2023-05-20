package day1.pascal.memoization;

import java.util.HashMap;
import java.util.Map;

public class Memoization {
    
	static Map<String, Integer> map = new HashMap<String, Integer>();
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
		}else if(map.get(i+","+j) != null){
			return map.get(i+","+j);
		}else{
			int result = pascalVal(i-1,j-1)+pascalVal(i-1,j);
			map.put(i+","+j, result);
			return result;
		}
	}

}
