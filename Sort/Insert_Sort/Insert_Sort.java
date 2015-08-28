public class Insert_Sort{

	public static void swap(int[] array,int a,int b){
		int temp=array[a];
		array[a]=array[b];
		array[b]=temp;
	}

	public static void insert_sort(int[] array){
		int N=array.length;
		for (int i=1;i<N;i++) {
			for (int j=i;j>0;j--) {
				if (array[j]<array[j-1]) {
					swap(array,j,j-1);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] arr={3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
		System.out.println("ÅÅĞòÇ°:");
		for (int n :arr ) {
			System.out.print(n+" ");
		}
		insert_sort(arr);
		System.out.println("\nÅÅĞòºó:");
		for (int n :arr ) {
			System.out.print(n+" ");
		}
	}
}