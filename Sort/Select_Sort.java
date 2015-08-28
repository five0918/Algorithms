import java.util.*;

public class Select_Sort{
	//�мǱ����ǽ�������������Ԫ�ص�λ�ã������ǽ�����������ֵ����������ġ�
	public static void swap(int[] array,int a,int b){
		int temp=array[a];
		array[a]=array[b];
		array[b]=temp;
	}

	public static void select_sort(int[] array){
		int N=array.length;
		for (int i=0;i<N;i++) {
			//��a[i]he a[i+1...N]����СԪ�ؽ���
			int min=i;//��СԪ�ص�����
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
		System.out.println("����ǰ:");
		for (int n :arr ) {
			System.out.print(n+" ");
		}
		select_sort(arr);
		System.out.println("\n�����:");
		for (int n :arr ) {
			System.out.print(n+" ");
		}
	}
}