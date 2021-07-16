package DFS;
//인프런 7-9
public class ShrotestWayDFS {
	Node root;
	static int min = 9999;
	public int dfs(int level, Node root) {
		if(root.lt == null && root.rt == null) {
			return level;
		}else {
			return Math.min(dfs(level+1, root.lt), dfs(level+1, root.rt));
		}
		
	}
	
	public static void main(String[] args) {
		ShrotestWayDFS obj = new ShrotestWayDFS();
		obj.root = new Node(1);
		obj.root.lt = new Node(2);
		obj.root.rt = new Node(3);
		obj.root.lt.lt = new Node(4);
		obj.root.lt.rt = new Node(5);
		System.out.println(obj.dfs(0, obj.root));
	}
}
