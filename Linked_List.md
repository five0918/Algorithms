#二. 链表

##1. 构造链表 

链表是一种递归的数据结构，它或者为空（null），或者是指向一个结点（node）的引用，该结点含有一个泛型的元素和一个指向另一个链表的引用。                                                              
结点是一个可能含有任意类型数据的抽象实体，它所包含的指向结点的应用显示了它在构造链表之中的作用。

```java
private class Node{
    Item item;
    Node next;
}
```
创建链表过程如下图：

![linked_list](https://github.com/five0918/Algorithms/blob/master/pictures/linked_list.jpg)

##2. 在表头插入结点
要在首结点first的给定链表开头插入字符串not,我们先将first保存在oldfirst中，然后将一个新的结点赋予first，并将它的item域设置为not，next域设置为oldfirst.过程如下图：
![insert_node](https://github.com/five0918/Algorithms/blob/master/pictures/insert_node.png)]

##3. 在表头删除结点
只需要将first指向first.next即可。过程如下图：
![remove_first_node](https://github.com/five0918/Algorithms/blob/master/pictures/remove_firstnode.png)
##4. 在表尾插入元素
我们先将last保存在oldlast中，然后让last指向新的结点，并让oldlast的next域设置为last。过程如下图：
![insert_last_node](https://github.com/five0918/Algorithms/blob/master/pictures/insert_lastnode.png)

##4. 其他位置的插入和删除操作
我们可以通过first链接访问链表的首结点并通过last链接访问链表的尾结点：
- 在表头插入结点；
- 在表头删除结点；
- 在表尾插入结点。
>注意：当插入结点的之前，我们必须要保存之前结点的链接，否则就会失去对这个结点的访问，丢失这个结点。

其他操作，如下几种，就不那么容易实现了：
- 删除指定的结点；
- 在指定结点前插入一个新结点。
- 
例如我们怎样删除尾结点呢？last链接帮不上忙，因为需要将尾结点的前一个结点的链接值改为null。在缺少其他信息的情况下，唯一的解决方法就是遍历链表并找到指向last的结点。
实现任意插入和删除操作的标准解决方案是使用双向链表，其中每个结点都含有两个链接，分别指向不同的方向。

##5. 遍历链表
访问链表中所有元素也有一个对应方式：将循环的索引变量x初始化为链表的首结点，然后通过x.item访问和x相关联的元素，并将x设为x.next来访问链表中的下一个结点，如此反复直到x的值为null，表明已经到了链表的结尾。
```java
for(Node x=first;x!=null;x=x.next){
    //处理x.item
}
```

##6. 下压堆栈（链表实现）
```java
import java.util.Iterator;
import java.util.Scanner;

public class Stack<Item> implements Iterable<Item>{
	private Node first;	//栈顶（最近添加的元素）
	private int N;		//元素个数
	private class Node{
		Item item;
		Node next;
	}

	public boolean isEmpty(){ 
		return first==null; 
	}
	public int size(){ 
		return N; 
	}

	public void push(Item item){
		Node oldfirst=first;
		first=new Node();
		first.item=item;
		first.next=oldfirst;
		N++;
	}

	public Item pop(){
		Item item=first.item;
		first=first.next;
		N--;
		return item;
	}

	public Iterator<Item> iterator(){
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item>{
		private Node current=first;
		public boolean hasNext(){
			return current!=null;
		}
		public void remove(){}
		public Item next(){
			Item item=current.item;
			current=current.next;
			return item;
		}
	}

	public static void main(String[] args) {
		Stack<String> stack=new Stack<String>();
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
