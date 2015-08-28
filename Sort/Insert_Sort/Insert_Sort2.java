public class Insert_Sort2{

	// public static void insert_sort(int[] array){
	// 	int N=array.length;
	// 	for (int i=1;i<N;i++) {
	// 		int temp=array[i];
	// 		for (int j=i-1;j>=0;j--) {
	// 			if (temp<array[j]) {
	// 				array[j+1]=array[j];
	// 				array[j]=temp;
	// 			}
	// 		}

	// 	}
	// }

	public static void insert_sort(int[] array){
		int N=array.length;
		for (int i=1;i<N;i++) {
			int temp=array[i];
			int j=i-1;
			while(j>=0&&temp<array[j]){
				array[j+1]=array[j];
				j--;
			}
			array[j+1]=temp;

		}
	}

	public static void main(String[] args) {
		int[] arr={3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
		System.out.println("ÅÅÐòÇ°:");
		for (int n :arr ) {
			System.out.print(n+" ");
		}
		insert_sort(arr);
		System.out.println("\nÅÅÐòºó:");
		for (int n :arr ) {
			System.out.print(n+" ");
		}
	}
}