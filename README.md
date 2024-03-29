자바 코딩테스트 공부 기록 저장소입니다.  <br>
README 파일엔 코딩테스트를 풀기 위한 개념들을 정리합니다.

# 동적 계획법 (DP)
- 분할 정복과 비슷. 동적계획법은 => 결과를 저장해두고 다시 찾아가는 방식(메모이제이션)에서 푼다는 점이 다름
- 동적 계획법은 바텀업 & 분할 정복은 탑다운 방식
- 동적 계획법 접근 방법 : 문제는 분석할땐 재귀적으로 하고, 풀때는 바텀업을 한다. 


// 쪼갤수 있는 부분을 => 트리로 비쥬얼화 하기. 
## girdTravelet memoization 
```
       (2,3) 
 (오)/  	    \(왼)
  (1,3)     (2,2)   => 쪼개서 트리로 비쥬얼화
  /  \       /  \
(0,3)(1,2)(1,2)(2,1) 		//(0,3) 같은 0이 포함된 노드는 계산x
	  / \
       (0,2)(1,1) 	//=> (1,1)의 값은 1
```

```javascript
const gridTraveler = (m, n, memo={}) =>{
	//are the args in the memo
	const key = m + ',' + n;


	if(key in memo) return memo[key];
	if(m ===1 && n === 1) return 1;
	if(m ===0 || n === 0) return 0;


	memo[key] gridTraveler(m-1, n, memo) + gridTraveler(m, n-1, memo); //키를 어렵게 저장하지 않게 주의
	return memo[key]l;
};
//gridTraveler(a, b) == gridTraveler(b, a)
```


## 1. 메모이제이션
### 1. make it work : 작동 먼저 시키기 (재귀적 부르트포스로 먼저 구현이 핵심!!!)
- 문제를 트리로 시각화 하기
- 재귀를 사용하여 구현하기 
- 테스트하기
### 2. make it effiecnt : 효율적으로 만들기 
- 메모 만들기 (배열, 해쉬 등의 자료구조) => 주의) 모든 재귀 함수가 접근 가능하게 구현.
- 메모의 값을 리턴하는 베이스 케이스 만들기. (ex=> fibo(1), fibo(2) == 1)
- 리턴 값을 메모에 저장하기

## 2. 타뷸레이션
<br/><br/><br/>

# 재귀 함수 
### if 문을 사용하여 **종료조건**을 설정!

``` java
  if(종료조건){
	    return; //함수 종료의 의미
	}else{ //종료조건이 아닐때
	    실행문
	}
```  

### 재귀함수는 스택프레임을 사용한다.

       	  |	         |
          | (<메소드>     )|	
          | (매개변수 정보  )|
          | (지역변수 정보  )|
          | (복귀 주소     )|-------- 
          |( ㄴ==호출 라인  )|       |
          |(...	         )|       |
          |---------------|       |
          | (<메소드>	)|       |	
          | (매개변수 정보   )|       |
          | (지역변수 정보   )|       |
          | (복귀 주소	)| <—---- 아래 스택(먼저 호출된)의 메소드로 복귀 (백트래킹)
          | ( ㄴ==호출 라인 )|
          | (  …         )|
          |---------------|
              <스택 프레임>
<br/><br/><br/>

# 트리
## 이진트리순회(깊이 우선 탐색-DFS : Depth-First Search)
- 깊이 우선 탐색
- 루트 노드에서 왼쪽 자식 노드 먼저 -> 오른쪽 자식 노드

- 전위순회 : 부 -> 왼 -> 오 
- 중위순회 : 왼 -> 부 -> 오
- 후위순회 : 왼 -> 오 -> 부

## 코드
### 노드 클래스를 생성, DFS 메소드 생성 <- 스택 사용!
- 값과, 왼쪽 자식 노드 주소, 오른쪽 자식 노드 주소.

``` java
class Node{
	int data;	//값
	Node lt, rt;	// 왼쪽 자식 주소, 오른쪽 자식 주소
	public Node(int val) {
		data = val;
		lt = rt = null;
	}
}
// DFS 메소드
public void DFS (Node root) {
	if(root == null) return;
	else {
		//System.out.print(root.data); <- 전위순회
		DFS(root.lt); 
		//System.out.print(root.data); <- 중위순회
		DFS(root.rt);
		//System.out.print(root.data); <- 후위순회
	}
}
```

## 이진트리 순회(넓이 우선 탐색 : 레벨탐색) BFS

- 루트가 0레벨. 자식 노드들의 레벨은 +1 씩 오른다.
- 레벨 탐색. -> 레벨 순으로 탐색. BFS —> 큐를 활용!!


## 코드 BFS 메소드 <- 큐 사용! 
``` java 
public void bfs(Node root){
	Queue<Node> queue = new LinkedList<>();
	queue.offer(root);
	int level = 0; //루트노드로 시작
	while(!queue.isEmpty()){
		int len = queue.size();
		for(int i = 0; i<len; i++){
			Node cur=queue.poll(); // 노드를 하나 큐에서 뽑고, 그의 자식 노드들을 큐에 넣기!!! <- BFS에서 주목할 곳!!!
			System.out.print(cur.data + " ");
			if(cur.lt!=null) { //왼쪽자식 큐에 넣기
				queue.offer(cur.lt);
			}
			if(cur.rt!=null) {//오른쪽자식 큐에 넣기
				queue.offer(cur.rt);
			}
		}
		// 하나의 레벨 끝
		level++; // 다음레벨
		System.out.println();
	}	
}
```
<br/><br/><br/>

# 그래프
- 그래프 : 버텍스와 엣지로 이루어진 집합
- G(V, E) == 그래프(버텍스, 엣지) 
                    |     |
                   노드   간선
## 인접행렬

- 1. 무방향 그래프
 
                                      graph[a][b]   
              ① ㅡ ② ㅡ ⑤      1, 2                 ①  ②  ③  ④  ⑤
              |    |           1, 3               ① 0  1   1  0  0
              ③ ㅡ ④           2, 4               ② 1  0   0  1  1
                               3, 4               ③ 1  0   0  1  0  
                               2, 5               ④ 0  1   1  0  0   
                                                  ⑤ 0  1   0  0  0

- 2. 방향 그래프
 
                                      graph[a][b]  
              ① -> ② -> ⑤    1, 2                 ①  ②  ③  ④  ⑤
              ↓     ↑          1, 3               ① 0  1   1  0  0
              ③ -> ④          3, 4               ② 0  0   0  0  1
                               4, 2               ③ 0  0   0  1  0  
                               2, 5               ④ 0  1   0  0  0   
                                                  ⑤ 0  0   0  0  0


- 3. 가중치 방향 그래프
                               
                                    graph[a][b][c]  
                 2    5
              ① -> ② -> ⑤     1, 2, 2               ①  ②  ③  ④  ⑤
              4↓    2↑         1, 3, 4             ① 0  2   4  0  0
              ③ -> ④          2, 5, 5             ② 0  0   0  0  5
                 5             3, 4, 5             ③ 0  0   0  5  0  
                               4, 2, 2             ④ 0  2   0  0  0   
                                                   ⑤ 0  0   0  0  0
