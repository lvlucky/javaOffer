package com.offer.algorithm;

import java.util.LinkedList;


/**
 * 单链表实现
 * 以及 add delete foreach相关操作
 * @author lv
 * @time 2019-7-23
 * @version
 */
public class MyLinkedList {
	private Node root;//当前节点
	private int size;//长度
	public static void main(String[] args) {
		MyLinkedList mylist = new MyLinkedList();
		mylist.add(1);
		mylist.add(2);
		mylist.add(3);
		mylist.add(4);
		mylist.add(5);
		mylist.add(7);
		mylist.add(9);
		mylist.add(10);
		mylist.add(11);
		MyLinkedList mylist2 = new MyLinkedList();
		mylist2.add(1);
		mylist2.add(2);
		mylist2.add(3);
		mylist2.add(4);
		mylist2.add(5);
		mylist2.add(7);
		mylist2.add(8);
		MyLinkedList mylist3 = meargeList(mylist,mylist2);
		mylist3.foreach();
//		mylist.rever2();
//		mylist.foreach();

	}
	//首先要有一个对象存储
	private static class Node{
		Integer o;//一个存储对象
		Node next;//指向下一个节点
		public Node(Integer o){
			this.o=o;
		}
	}
	//插入一个节点
	public void add(Integer o){
		Node node = new Node(o);
		//将第一个节点赋值给根节点
		if(root==null){
			root = node;
		}else{
			//在最后添加节点
			lastAdd(node,root);
		}
		size ++;
	}
	public void lastAdd(Node node,Node lastNode){
		if(lastNode.next==null){
			lastNode.next=node;
		}else{
			lastAdd(node,lastNode.next);
		}
	}
	/**
	 * 删除指定位置节点
	 * 暂时不做任何判断 例子默认>=0的int类型
	 * @param index
	 */
	public void remove(int index){
		if(index<size){
			Node pre =null;//上一个对象
			Node node = null;//当前对象
			for(int i=0;i<=index;i++){
				if(i==0){
					node = root;
				}else{
					pre = node;
					node = node.next;
				}
			}
			//在此处进行删除操作。
			pre.next=node.next; //只需要将当前节点的上也给元素指向当前节点的下一个元素就完成删除
			size --;
		}
	}
	/**
	 * 遍历单链表
	 */
	public void foreach(){
		print(root);
	}
	//递归遍历
	public void print(Node node){
		if(node!=null){
			System.out.println(node.o);
			print(node.next);
		}
	}
	/**
	 * 链表反转 递归
	 */
	public void rever(){
		//反转意思是头边尾 尾扁头
		Node next = root.next;
		if(next!=null){
			root.next=null;//将最初位置至null
			rever(root,next);

		}
		
	}
	
	/**
	 * 进行反转
	 * @param node
	 */
	public void rever(Node node, Node next){
		Node nextN = next.next;
		if(nextN==null){
			next.next=node;
			root=next;//将root指向最后一个位置
		}else{
			next.next=node;
			rever(next,nextN);
		}
		
	}
	/**
	 * while循环反转
	 */
	public void rever2(){
		//反转意思是头边尾 尾扁头
		Node node = root;
		Node pre = null;
		Node next = null;
		while(node!=null){
			next = node.next;
			node.next= pre;
			pre = node;
			node = next;
		}
		root = pre;		
	}
	/**
	 * 
	 */
	public void checkRing(){
		
	}
	/**
	 * 两个有序链表的合并操作
	 * meargeList 合并连个有序链表 
	 * 以my1为基础 my2合并到my1
	 */
	public static MyLinkedList meargeList(MyLinkedList my1,MyLinkedList my2){
		//有序的话 将两个有序的链表从小到大排序
		//准备两个变量分别指向my1 my2 分别对比
		Node n1= my1.root;//n1指向根节点
		Node n2 = my2.root;
		MyLinkedList  meageList = new MyLinkedList();
		Node node = null;
		//忽略之前的null比较 这进入正题
		//首先初始化 =给一个根节点然后进入正题
		if(n1.o<=n2.o){
			meageList.root = n1;
			node = n1;
			n1 = n1.next;
		}else{
			meageList.root = n2;
			node = n2;
		}
		while(n1!=null &&n2!=null){
			Node tmp = null;
			if(n1.o<=n2.o){
				tmp=n1;
				n1=n1.next;
			}else{
				tmp = n2;
				n2 = n2.next;
			}
			node.next= tmp;
			node = tmp;
		}
		if(n1==null){
			node.next = n2;
		}
		if(n2==null){
			node.next= n1;
		}
		return meageList;
	}
	
}
