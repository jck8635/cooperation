package project;
import java.util.*;

class Node{									//점 클래스예요.
	private int data;						//위치정보
	private LinkedList<Node> adjacent;		//연결된 점 정보 모음
	private LinkedList<Eatery> shop;		//해당 위치에 있는 가게 모음
	private boolean marked;					//탐색할 때 쓰여요 여기 왔는가?
	
	public Node(int d) {
		this.data = d;
		adjacent = new LinkedList<>();
		shop = new LinkedList<>();
		marked = false;
	}
	
	public LinkedList<Node> getAdjacent(){
		return adjacent;					//연결된 점 모음집 반환
	}
	
	public LinkedList<Eatery> getShop(){
		return shop;						//있는 가게들 반환
	}
	
	public boolean getMarked() {
		return marked;						//여기 왔는지 정보 반환
	}
	
	public void setMarked(boolean b) {
		marked = b;							//여기 왔는지 정보 수정
	}
	
}

public class Graph {
	private Node[] nodes;					//점들의 모음
	
	public Graph(int d, Eatery array[]) {
		nodes = new Node[d];
		for (int i=0; i<d; i++) {
			nodes[i] = new Node(i);
		}
		for (Eatery i : array) this.nodes[i.getLocation()].getShop().add(i);	//그래프 생성시 음식점 리스트를 입력받아 각 위치에 놓아줍니다.
	}
	
	public void addEdge(int i1, int i2) {	//점끼리 연결해주는 메소드
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		if(!n1.getAdjacent().contains(n2)) n1.getAdjacent().add(n2);
		if(!n1.getAdjacent().contains(n1)) n2.getAdjacent().add(n1);
	}
	
	public Node[] getNodes() {				//점 모음집 반환
		return nodes;
	}
	
	public Eatery[] BFSort(Eatery[] array, int po) {	//BFS 입니다. 큐를 이용해서 순차적으로 탐색함.
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
			
			for (Eatery shop : tmp.getShop()) {			//탐색한 장소에 있는 가게들 반환시킴
				array[ind] = shop;
				ind++;
			}
		}
		
		return array;
		
	}
}