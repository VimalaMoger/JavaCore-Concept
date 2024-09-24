package java8.collection.linkedList;

public class LinkedList {
	Node  head;
	void traverseLL(){
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	void insertBeginning(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
   void insertLast(int data) {
	   Node newNode = new Node(data);
	   newNode.next = null;
	   Node temp = head;
	   while(temp.next != null) {
		   temp = temp.next;
	   }
	   temp.next= newNode;
	   System.out.println("added at the end "+data);
   }
   void insertMiddle(int data, int postition) {
	   Node newNode = new Node(data);
	   newNode.next = null;
	   Node temp=head;
	   for(int i=2;i<postition;i++) {
		   if(temp.next !=null) {
			   temp = temp.next;
		   }
	   }
	   newNode.next = temp.next;
	   temp.next= newNode;
	   System.out.println("added in the middle "+data);
   }

   void deleteBiginning(int data) {
	   head = head.next;
	   System.out.println("deleting item "+data);
   }

   void deleteEnd(int data) {
	   Node temp= head;
	   while(temp.next.next != null) {
		   temp =temp.next;
	   }
	   temp.next=null;

   }
   void deleteMiddle(int position) {
	   Node temp= head;
	   for(int i=2;i<position;i++) {
		   if(temp.next != null) {
			   temp = temp.next;
		   }
	   }
	   System.out.println("delete middle "+temp.next.data);
	   temp.next =temp.next.next;

   }
   boolean search(int x) {
	    Node current = head;    //Initialize current
	        while (current != null)
	        {
	            if (current.data == x)
	                return true;    //data found
	            current = current.next;
	        }
	        return false;    //data not found
	    }
   
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertBeginning(12);
		list.insertLast(45);
		list.insertLast(34);
		//list.traverseLL();
		list.insertLast(56);
		//list.traverseLL();
		list.insertMiddle(90, 2);
		list.traverseLL();

		list.deleteBiginning(12);
		list.traverseLL();
		list.deleteMiddle(3);
		
		list.traverseLL();
		list.deleteMiddle(2);
		list.traverseLL();
		System.out.println(list.search(900));

	}

}
class Node{
	int data;
	Node next;
	Node(int data){
		this.data=data;
		next = null;
	}
}
