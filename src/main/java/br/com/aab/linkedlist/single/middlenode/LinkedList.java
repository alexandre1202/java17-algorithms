package br.com.aab.linkedlist.single.middlenode;

import java.util.Objects;

class LinkedList implements List {

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.insert(10);
		linkedList.insert(11);
		linkedList.insert(12);
		linkedList.insert(13);
		linkedList.insert(14);
		linkedList.insert(15);

		System.out.printf("The middle of the linked list is %d", linkedList.getMiddleNode().getData());;
	}

	// this is the head node or root node
	private Node root;
	private int numOfItems;
	
	@Override
	public Node getMiddleNode() {
		if (Objects.isNull(root)) return null;
		Node slow = this.root;
		Node faster = this.root;
		while (Objects.nonNull(faster.getNextNode()) && Objects.nonNull(faster.getNextNode().getNextNode())) {
			slow = slow.getNextNode();
			faster = faster.getNextNode().getNextNode();
		}
		return slow;
	}
	
	@Override
	public void insert(int data) {
		
		if(root==null) {
			// this is the first item in the linked list
			root = new Node(data);
		} else {
			// we know that this is not the first item in the linked list
			insertBeginning(data);
		}	
	}

	// we just have to update the references O(1)
	private void insertBeginning(int data) {
		Node newNode = new Node(data);
		newNode.setNextNode(root);
		root = newNode;
	}
	
	// because we have to start with the root node
	// first we have to find the last node in O(N)
	private void insertEnd(int data, Node node) {
		
		// this is when we keep looking for the last node O(N)
		if(node.getNextNode() != null) {
			insertEnd(data, node.getNextNode());
		} else {
			// we have found the last node
			Node newNode = new Node(data);
			node.setNextNode(newNode);
		}
	}

	@Override
	public void traverse() {
		
		if(root==null) return;
		
		Node actualNode = root;
		
		while(actualNode != null) {
			System.out.println(actualNode);
			actualNode = actualNode.getNextNode();
		}	
	}

	@Override
	public int size() {
		return numOfItems;
	}
}

interface List {
    public Node getMiddleNode();
    public void insert(int data);
    public void traverse();
    public int size();
}

class Node {

    private int data;
    private Node nextNode;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "" + this.data;
    }
}