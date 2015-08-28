import java.util.*;

public class Select_Sort{
	//切记本题是交换数组中两个元素的位置，而不是交换两个数的值，否则会出错的。
	public static void swap(int[] array,int a,int b){
		int temp=array[a];
		array[a]=array[b];
		array[b]=temp;
	}

	public static void select_sort(int[] array){
		int N=array.length;
		for (int i=0;i<N;i++) {
			//将a[i]he a[i+1...N]中最小元素交换
			int min=i;//最小元素的索引
			for (int j=i+1;j<N;j++) {
				if (array[j]<array[min]) {
					min=j;
				}
			}
			swap(array,i,min);
		}
	}

	public static void main(String[] args) {
		int[] arr={3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
		System.out.println("排序前:");
		for (int n :arr ) {
			System.out.print(n+" ");
		}
		select_sort(arr);
		System.out.println("\n排序后:");
		for (int n :arr ) {
			System.out.print(n+" ");
		}
	}
}