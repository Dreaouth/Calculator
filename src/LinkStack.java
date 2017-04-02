interface IStack{
	void clear();
	boolean IsEmpty();
	void push(Object x);
	Object pop();
	int length();
	Object peek();
}
class Node {
	private Object data;
	private Node next;

	public Node() {
		data=null;
	}

	public Node(Object dat) {
		data=dat;
	}

	public Node(Object dat, Node nex) {
		data=dat;
		next=nex;
	}

	public Object Getdata() {
		return data;
	}

	public Node Getnext() {
		return next;
	}

	public void Setdata(Object data) {
		this.data = data;
	}

	public void Setnext(Node next) {
		this.next = next;
	}
}

public class LinkStack implements IStack{
	private Node top;
	@Override
	public void clear() {
		top=null;
	}

	@Override
	public boolean IsEmpty() {
		return top==null;
	}

	@Override
	public void push(Object x) {
		Node p=new Node(x);
		p.Setnext(top);
		top=p;
	}

	@Override
	public Object pop() {
		if(IsEmpty())
			return null;
		else{
			Node pNode=top;
			top=top.Getnext();
			return pNode.Getdata();
		}
		
	}

	@Override
	public int length() {
		Node pNode=top;
		int len=0;
		while(pNode!=null){
			pNode=pNode.Getnext();
			++len;
		}
		return len;
	}

	@Override
	public Object peek() {
		if(!IsEmpty())
			return top.Getdata();
		else {
			return null;
		}
	}
	public void display(){
		Node pNode=top;
		while(pNode!=null){
			System.out.print(pNode.Getdata().toString()+" ");
			pNode=pNode.Getnext();
		}
		System.out.println();
	}
	public static void main(String[] args) {
		LinkStack A=new LinkStack();
		for(int i=0;i<10;i++)
			A.push(i+2);
		A.display();
		System.out.println(A.peek());
		A.pop();
		System.out.println(A.peek());
		System.out.println(A.toString());
	}
}
