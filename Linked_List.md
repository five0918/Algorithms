#1. 链表

[TOC]

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
