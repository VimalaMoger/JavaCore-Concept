package problemsActivities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Triplets {

	public static void main(String[] args) {
		int[] arr= {7,4,9,10,3};
		List<Integer> list= new ArrayList<>();
		int res=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				res= arr[i] * arr[j];
				for(int k=j+1;k<arr.length;k++) {
					int total=0;
					total = res * arr[k];
					list.add(total);
					}
				}
			}
		for(Integer i: list) {
			System.out.println(i);
		}
		int max= Collections.max(list);
		System.out.println("max of array "+max);

}
}
