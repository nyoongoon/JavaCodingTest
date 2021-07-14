자바 코딩테스트 공부 기록 저장소입니다. 
리드미 파일엔 코딩테스트를 풀기 위한 개념들을 정리합니다.


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
        4↓    2↑          1, 3, 4             ① 0  2   4  0  0
        ③ -> ④          2, 5, 5             ② 0  0   0  0  5
           5             3, 4, 5             ③ 0  0   0  5  0  
                         4, 2, 2             ④ 0  2   0  0  0   
                                             ⑤ 0  0   0  0  0
