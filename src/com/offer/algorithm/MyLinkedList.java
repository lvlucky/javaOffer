package com.offer.algorithm;

import java.util.LinkedList;


/**
 * ������ʵ��
 * �Լ� add delete foreach��ز���
 * @author lv
 * @time 2019-7-23
 * @version
 */
public class MyLinkedList {
	private Node root;//��ǰ�ڵ�
	private int size;//����
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
	//����Ҫ��һ������洢
	private static class Node{
		Integer o;//һ���洢����
		Node next;//ָ����һ���ڵ�
		public Node(Integer o){
			this.o=o;
		}
	}
	//����һ���ڵ�
	public void add(Integer o){
		Node node = new Node(o);
		//����һ���ڵ㸳ֵ�����ڵ�
		if(root==null){
			root = node;
		}else{
			//�������ӽڵ�
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
	 * ɾ��ָ��λ�ýڵ�
	 * ��ʱ�����κ��ж� ����Ĭ��>=0��int����
	 * @param index
	 */
	public void remove(int index){
		if(index<size){
			Node pre =null;//��һ������
			Node node = null;//��ǰ����
			for(int i=0;i<=index;i++){
				if(i==0){
					node = root;
				}else{
					pre = node;
					node = node.next;
				}
			}
			//�ڴ˴�����ɾ��������
			pre.next=node.next; //ֻ��Ҫ����ǰ�ڵ����Ҳ��Ԫ��ָ��ǰ�ڵ����һ��Ԫ�ؾ����ɾ��
			size --;
		}
	}
	/**
	 * ����������
	 */
	public void foreach(){
		print(root);
	}
	//�ݹ����
	public void print(Node node){
		if(node!=null){
			System.out.println(node.o);
			print(node.next);
		}
	}
	/**
	 * ����ת �ݹ�
	 */
	public void rever(){
		//��ת��˼��ͷ��β β��ͷ
		Node next = root.next;
		if(next!=null){
			root.next=null;//�����λ����null
			rever(root,next);

		}
		
	}
	
	/**
	 * ���з�ת
	 * @param node
	 */
	public void rever(Node node, Node next){
		Node nextN = next.next;
		if(nextN==null){
			next.next=node;
			root=next;//��rootָ�����һ��λ��
		}else{
			next.next=node;
			rever(next,nextN);
		}
		
	}
	/**
	 * whileѭ����ת
	 */
	public void rever2(){
		//��ת��˼��ͷ��β β��ͷ
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
	 * ������������ĺϲ�����
	 * meargeList �ϲ������������� 
	 * ��my1Ϊ���� my2�ϲ���my1
	 */
	public static MyLinkedList meargeList(MyLinkedList my1,MyLinkedList my2){
		//����Ļ� ����������������С��������
		//׼�����������ֱ�ָ��my1 my2 �ֱ�Ա�
		Node n1= my1.root;//n1ָ����ڵ�
		Node n2 = my2.root;
		MyLinkedList  meageList = new MyLinkedList();
		Node node = null;
		//����֮ǰ��null�Ƚ� ���������
		//���ȳ�ʼ�� =��һ�����ڵ�Ȼ���������
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
