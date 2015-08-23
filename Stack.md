下压栈是一种基于后进先出策略的集合类型。
在应用程序中使用栈迭代器的一个典型原因是在用集合保存元素的同时颠倒它们的相对顺序。

>Stack的底层为一个用于保存栈中的元素的数组a[],和一个用于保存栈中元素数量的整数N，栈的顶部位于a[N](如果栈为非空)。
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
		a[N++]=item;
	}

	public Item pop(){
		return a[--N];
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



```java

```
