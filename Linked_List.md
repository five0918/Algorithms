>链表是一种递归的数据结构，它或者为空（null），或者是指向一个结点（node）的引用，该结点含有一个泛型的元素和一个指向另一个链表的引用。                                                              
结点是一个可能含有任意类型数据的抽象实体，它所包含的指向结点的应用显示了它在构造链表之中的作用。
```java
private class Node{
    Item item;
    Node next;
}
```
![linked_list](http://pan.baidu.com/s/14Wnhk)