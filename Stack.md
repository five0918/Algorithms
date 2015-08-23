下压栈是一种基于后进先出策略的集合类型。
在应用程序中使用栈迭代器的一个典型原因是在用集合保存元素的同时颠倒它们的相对顺序。

>Stack的底层为一个用于保存栈中的元素的数组a[]，和一个用于保存栈中元素数量的整数N，栈的顶部位于a[N-1] （如果栈为非空）。
>要删除一个元素，将N减一并返回a[N]。要添加一个元素，我们将a[N]设为新元素并将N加1。

```java
import java.util.Scanner;

public class FixedCapacityStackOfStrings<Item>{
	private Item[] a;
	private int N;	//size

	public FixedCapacityStackOfStrings(int cap){
	  //创建泛型数组在Java中不允许的。
		a=(Item[])new Object[cap];
	}

	public boolean isEmpty(){
		return N==0;
	}

	public void push(Item item){
		if(N==a.length){
			resize(2*a.length);
		}
		a[N++]=item;
	}

	public Item pop(){
		//从栈顶删除元素
		Item item=a[--N];
		//避免对象游离
		a[N]=null;
		if(N>0&&N==a.length/4){
			resize(a.length/2);
		}
		return item;
	}

	public int size(){
		return N;
	}

	public static void main(String[] args) {
		FixedCapacityStackOfStrings stack=new FixedCapacityStackOfStrings(100);
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			String item=in.next();
			if (!item.equals("-")) {
				stack.push(item);
			}else if (!stack.isEmpty()) {
				System.out.print(stack.pop()+" ");
			}
		}
		System.out.println("("+stack.size()+" left on stack)");
	}
}
```

>选择用数组表示栈内容意味着必须预先估计栈的最大容量。在Java中数组一旦创建，其大小无法改变。我们需要能够调整数组a[]大小，使得它既可以保存所有的元素，又不至于浪费过多的空间。

>调整栈的大小
```java
private void resize(int max){
	//将大小为N<max的栈移动到一个新的大小为max的数组中
	Item[] temp=(Item[])new Object[max];
	for (int i=0;i<N;i++){
		temp[i]=a[i];
	}
	a=temp;
}
```


>下压栈（LIFO）（能够动态调整数组大小的实现）
```java
import java.util.Iterator;
public class ResizingArrayStack<Item> implements Iterable<Item>{
	private Item[] a=(Item[])new Object[1];		//栈元素
	private int N=0;							//元素个数

	public boolean isEmpty(){
		return N==0;
	}

	public int size(){
		return N;
	}

	private void resize(int max){
		//将栈移动到一个大小为max的新数组
		Item[] temp=(Item[])new Object[max];
		for (int i=0;i<N;i++ ) {
			temp[i]=a[i];
		}
		a=temp;
	}

	public void push(Item item){
		//将元素添加到栈顶
		if (N==a.length) {
			resize(2*a.length);
		}
		a[N++]=item;
	}

	public Item pop(Item item){
		//从栈顶删除元素
		Item item=a[--N];
		a[N]=null;		//避免对象游离
		if (N>0&&N==a.length/4) {
			resize(a.length/2);
		}
		return item;
	}

	public Iterator<Item> iterator(){
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<Item>{
		//支持后进先出迭代
		private int i=N;
		public boolean hasNext(){
			return i>0;
		}

		public Item next(){
			reutn a[--i];
		}
		public void remove(){}
	}

}

```
