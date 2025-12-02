package lab19;

public class DoublyLinkedList<E> implements List<E>{
	private Node<E> first;
	
    public void add(E element) {
    	if (size() == 0) {
    		first = new Node(element);
    	} else {
    		Node<E> last = getLast();
    		Node<E> newNode = new Node(element);
    		last.setNext(newNode);
    		newNode.setPrev(last);
    	}
    }

    public void add(int i, E element) throws IndexOutOfBoundsException {
    	Node<E> newPrevNode = get(i);
    	Node<E> newNextNode = newPrevNode.getNext();
		Node<E> newNode = new Node(element);
		newPrevNode.setNext(newNode);
		newNode.setPrev(newPrevNode);
		if (newNextNode != null) {
			newNextNode.setPrev(newNode);
			newNode.setNext(newNextNode);
		}
    }

    public void remove() {
    	getLast().getPrev().setNext(null);
	}

    public Node<E> remove(int i) throws IndexOutOfBoundsException {
    	Node<E> victim = get(i);
    	Node<E> prev = victim.getPrev();
    	Node<E> next = victim.getNext();
    	if (prev != null && next != null) {
    		prev.setNext(next);
    		next.setPrev(prev);
    	} else if (prev != null) {
    		prev.setNext(null);
    	} else if (next != null) {
    		next.setPrev(null);
    	}
    	return victim;
    }

    public Node<E>  get(int i) throws IndexOutOfBoundsException {
    	Node<E> currentNode = first;
    	for (int j = 0; j < i; j++) {
    		if (currentNode.getNext() != null) {
    			currentNode = currentNode.getNext();
    		} else {
    			throw new IndexOutOfBoundsException();
    		}
    	}
    	return currentNode;
    }

    public void set(int i, E element) throws IndexOutOfBoundsException {
    	Node<E> node = get(i);
    	node.setValue(element);
    }

    public int size() {
    	Node<E> currentNode = first;
    	if (currentNode == null) {return 0;}
    	int size = 1;
    	while (currentNode.getNext() != null) {
    		currentNode = currentNode.getNext();
    		size++;
    	}
    	return size;
    }

    public boolean isEmpty() {
    	return size() == 0;
    }

    public String toString() {
    	Node<E> currentNode = first;
    	String str = "DoublyLinkedList[";
    	if (currentNode != null) {
    		str += currentNode.toString();
    	}
    	while (currentNode.getNext() != null) {
    		currentNode = currentNode.getNext();
    		str += "," + currentNode.toString();
    	}
    	return str + "]";
    }
    
    public Node<E> getLast() {
    	Node<E> currentNode = first;
    	while (currentNode.getNext() != null) {
    		currentNode = currentNode.getNext();
    	}
    	return currentNode;
    }
	
	public static void main(String[] args) {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();  
		list.add(10);  
		list.add(20);  
		list.add(30);  
		System.out.println(list.toString()); // [10, 20, 30]  
		  
		list.add(2, 40);  
		list.add(0, 5);  
		list.set(2, 50);  
		System.out.println(list.toString()); // [5, 10, 50, 40, 30]  
		  
		list.remove(4);  
		list.remove(2);  
		System.out.println(list.size()); // 3  
		System.out.println(list.toString()); // [5, 10, 40]
	}
}
