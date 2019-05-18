package Graph;

import LinearDataStructures.List;
import LinearDataStructures.Node;

public class KeyNode implements Node {

	public int user;
    public KeyNode next;
    
    public KeyNode(int keynode) {
    	this.user=keynode;
    }
    
    public String toString() {
    	return this.user+" ";
    }
	@Override
	public void setNext(Node node) {
		this.next=(KeyNode)node;

	}

	@Override
	public Node getNext() {
		// TODO Auto-generated method stub
		return next;
	}

	@Override
	public Node clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEqual(Node node) {
		// TODO Auto-generated method stub
		KeyNode temp = (KeyNode)node;
		return this.user == temp.user ? true : false;
	}

	@Override
	public boolean isLessThan(Node node) {
		// TODO Auto-generated method stub
		return false;
	}


}
