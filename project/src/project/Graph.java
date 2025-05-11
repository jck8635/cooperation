package project;
import java.util.*;

class Node{									//�� Ŭ��������.
	private int data;						//��ġ����
	private LinkedList<Node> adjacent;		//����� �� ���� ����
	private LinkedList<Eatery> shop;		//�ش� ��ġ�� �ִ� ���� ����
	private boolean marked;					//Ž���� �� ������ ���� �Դ°�?
	
	public Node(int d) {
		this.data = d;
		adjacent = new LinkedList<>();
		shop = new LinkedList<>();
		marked = false;
	}
	
	public LinkedList<Node> getAdjacent(){
		return adjacent;					//����� �� ������ ��ȯ
	}
	
	public LinkedList<Eatery> getShop(){
		return shop;						//�ִ� ���Ե� ��ȯ
	}
	
	public boolean getMarked() {
		return marked;						//���� �Դ��� ���� ��ȯ
	}
	
	public void setMarked(boolean b) {
		marked = b;							//���� �Դ��� ���� ����
	}
	
}

public class Graph {
	private Node[] nodes;					//������ ����
	private HashMap<String,Integer> hash;	//��ġ->����ȣ�� ���� ���� �ؽ���
	
	public Graph() {
		hash = new HashMap<>();
	}
	
	public void setNodeSize(int d) {
		nodes = new Node[d];
		for (int i=0; i<d; i++) {
			nodes[i] = new Node(i);
		}
	}
	
	public void setHash(String location, int po) {
		this.hash.put(location, po);
	}
	
	public void setShoplist(Eatery array[]) {
		//
		for (Eatery i : array) this.nodes[hash.get(i.getLocation())].getShop().add(i);	//�׷��� ������ ������ ����Ʈ�� �Է¹޾� �� ��ġ�� �����ݴϴ�.
	}
	
	public void addEdge(String s1, String s2) {	//������ �������ִ� �޼ҵ�
		Node n1 = nodes[hash.get(s1)];
		Node n2 = nodes[hash.get(s2)];
		if(!n1.getAdjacent().contains(n2)) n1.getAdjacent().add(n2);
		if(!n1.getAdjacent().contains(n1)) n2.getAdjacent().add(n1);
	}
	
	public Node[] getNodes() {				//�� ������ ��ȯ
		return nodes;
	}
	
	public Eatery[] BFSort(Eatery[] array, int po) {	//BFS �Դϴ�. ť�� �̿��ؼ� ���������� Ž����.
		int ind = 0;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(nodes[po]);
		nodes[po].setMarked(true);
		while(queue.size() != 0) {
			Node tmp = queue.poll();
			for (Node n : tmp.getAdjacent()) {
				if(!(n.getMarked())) {
					queue.add(n);
					n.setMarked(true);
				}
			}
			
			for (Eatery shop : tmp.getShop()) {			//Ž���� ��ҿ� �ִ� ���Ե� ��ȯ��Ŵ
				array[ind] = shop;
				ind++;
			}
		}
		
		return array;
		
	}
}