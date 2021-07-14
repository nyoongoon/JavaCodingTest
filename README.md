자바 코딩테스트 공부 기록 저장소입니다. 
리드미 파일엔 코딩테스트를 풀기 위한 개념들을 정리합니다.

## 재귀 함수 
### if 문을 사용하여 **종료조건**을 설정!

``` java
  if(종료조건){
	    return; //함수 종료의 의미
	}else{ //종료조건이 아닐때
	    실행문
	}
```  

### 재귀함수는 스택프레임을 사용한다.

              |	        		 |
              | (<메소드>		 )|	
              | (매개변수 정보	)|
              | (지역변수	정보  )|
              | (복귀 주소		 )|-------- 
              |( ㄴ==호출 라인	 )|       |
              |(…		      	 )|       |
              |---------------|       |
              | (<메소드>		  )|       |	
              | (매개변수 정보	 )|       |
              | (지역변수	정보   )|       |
              | (복귀 주소		  )| <—---- 아래 스택(먼저 호출된)의 메소드로 복귀 (백트래킹)
              | ( ㄴ==호출 라인 )|
              | (  …		     )|
              |---------------|
                  <스택 프레임>



### 그래프
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
