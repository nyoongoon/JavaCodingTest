package BFS;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestWayBFS {
	Node root;

	public int bfs(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		int level = 0;
		while (!q.isEmpty()) {
			int len = q.size();

			for (int i = 0; i < len; i++) {
				Node node = q.poll();
				if(node.lt == null && node.rt == null) return level;
				if (node.lt != null) {
					q.add(node.lt);
				}
				if (node.rt != null) {
					q.add(node.rt);
				}
			}
			level++;
		}
		return 0;// 그냥 해주는 리턴
	}

	public static void main(String[] args) {
		ShortestWayBFS obj = new ShortestWayBFS();
		obj.root = new Node(1);
		obj.root.lt = new Node(2);
		obj.root.rt = new Node(3);
		obj.root.lt.lt = new Node(4);
		obj.root.lt.rt = new Node(5);
		System.out.println(obj.bfs(obj.root));
	}
}
