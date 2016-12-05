package algoritmos;



public class DlinkList {
	DlinkNode head;
	DlinkNode tail;
	int size;
	public DlinkList(){
		head=tail=null;
		size=0;
	}
	public class DlinkNode{
		int value;
		DlinkNode prev;
		DlinkNode next;
		public DlinkNode(int x){
			value=x;
			prev=next=null;
		}
	}
	int size(){
		return size;
	}
	void AddFront(int x){
		DlinkNode newNode=new DlinkNode(x);
		if(size==0){
			head=tail=newNode;
		}
		else{
         head.prev=newNode;
		newNode.next=head;
		head=newNode;
		}
		size++;
	}
	int removeFront()throws Exception{
		if (size==0)
			throw new Exception();
		int ret=0;
		 if (size==1){
			ret=head.value;
			head=tail=null;
		}
		 else{
			 ret=head.value;
			 head=head.next;
          head.prev=null;
			 
		 }
			
		size--;
		return ret;
		
	}
	void AddBack(int x){
		DlinkNode newNode=new DlinkNode(x);
		if (size==0){
			head=tail=newNode;
		}
		else{
         newNode.prev=tail;
			tail.next=newNode;
			tail=newNode;
		}
		size++;
	}
	int removeBack()throws Exception{
		if (size==0)
			throw new Exception();
		int ret=tail.value;
		if (size==1){
			ret=tail.value;
			tail=head=null;
			}
		
		else {	
			DlinkNode prv=tail.prev;
			prv.next=null;
			tail=prv;
           
			}
             
		size--;
		return ret;
		
	}
	void insert(int pos, int x)throws Exception{
		if(pos<0)
			throw new Exception();
		else if (pos==0)
			AddFront(x);
		else if(pos==size)
			AddBack(x);
         else{   
		DlinkList list1=new DlinkList();
		DlinkList list2 = new DlinkList();
		DlinkNode cur = head.next;
		DlinkNode cur2=head;
		list1.head=cur2;
		list1.size =1; 
		
		int i=0;
		while(i<pos-1){
			cur2.next=cur;
       
         cur2=cur;
			cur=cur.next;
			list1.size++;
			i++;
		}
     
		list1.tail=cur2;
		cur2=cur;
      cur=cur.next;
		list2.head=cur2;
      list2.size=1;
		while(i<size){
         cur2.next=cur;
         cur2=cur;
         i++;
			list2.size++;
         if(cur==tail)
            break;
         cur=cur.next;         
			
		}
		list2.tail=cur2;
		list1.AddBack(x);
		list1.tail.next=list2.head;
         list2.head.prev=list1.tail;
         head=list1.head;
         tail=list2.tail;
		size=list1.size + list2.size;
      }
		
	}
	int delete(int pos)throws Exception{
		int ret=0;
		DlinkNode cur=head;
		if(pos<0||pos>=size)
			throw new Exception();
		else if (pos==size-1)
			removeBack();
		else if (pos==0)
			removeFront();
		else{
			for(int i=0;i<pos;i++){
				cur=cur.next;
				if (i==pos-1){
					ret=cur.value;
					cur.prev.next=cur.next;
					cur.next.prev=cur.prev;
					cur=null;
				}
				
			}
			
		}
		size--;
		return ret;
	}
	
	int get(int pos) throws Exception{
		DlinkNode cur=head;
		if (size==0)
			throw new Exception();
		else if(pos<0||pos>size)
			throw new Exception();
		else if (pos==0)
			return head.value;
		else{
		for(int i=0;i<pos;i++){
			cur=cur.next;
		}
		}
		return cur.value;
		
		
	}
	

	public static void main(String[] args){
		DlinkList L=new DlinkList();
		L.AddBack(1);
		L.AddBack(2);
		L.AddFront(0);
		L.AddFront(4);
		L.AddBack(15);
		L.AddBack(90);
		L.AddBack(67);
		try{
			L.insert(2, 5);
			L.insert(2, 8);
			L.insert(3, 18);
			L.insert(4, 80);
			L.insert(7, 48);
			L.delete(6);
			L.removeBack();
			L.removeFront();
		}catch(Exception e){}
		DlinkNode cur=L.head;
		for(int i=0;i<L.size;i++){
		 System.out.println(cur.value); 
		 cur=cur.next;
	}
		System.out.println();
		System.out.println();
		try{
		System.out.println(L.get(5));
		}catch(Exception e){}
		System.out.println(L.size());
		}
	

}