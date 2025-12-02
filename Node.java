package lab19;

public class Node<E> {
	private E value;
	private Node<E> prev = null;
	private Node<E> next = null;
	
	public Node(E item) {
		value = item;
	}
	public Node(E item, Node<E> p, Node<E> n) {
		value = item;
		prev = p;
		p.setNext(this);
		next = n;
		n.setPrev(this);
	}
	public Node(E item, Node<E> p) {
		value = item;
		prev = p;
		p.setNext(this);
	}
	public E getValue() {
		return value;
	}
	public Node<E> getPrev() {
		return prev;
	}
	public Node<E> getNext() {
		return next;
	}
	public void setValue(E v) {
		value = v;
	}
	public void setPrev(Node<E> v) {
		prev = v;
	}
	public void setNext(Node<E> v) {
		next = v;
	}
	public String toString() {
		return "Node(" + value + ")";
	}
	public boolean equals(Node<E> node) {
		return value == node.getValue() && prev.equals(node.getPrev()) && next.equals(node.getNext());
	}
	public static void main(String[] args) {
		Node<String> first = new Node<>("obtuse");  
		  
		Node<String> next = new Node<>("rubber goose");  
		first.setNext(next);  
		next.setPrev(first);  
		  
		Node<String> after = new Node<>("guava juice", next);  
		next.setNext(after);  
		System.out.println(after.getPrev().getValue()); // "rubber goose"  
		  
		Node<String> last = new Node<>("giant snake");  
		System.out.println(next.equals(last));
	}
}
