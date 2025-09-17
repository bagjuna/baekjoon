

import java.util.*;

class Solution {
    static List<Node>[] graph;
    static boolean[] visited;
    static int[] dist;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        // 방문 배열
        visited = new boolean[N + 1];
        // 인접 리스트
        graph = new List[N + 1];
        // 최단거리 배열
        dist = new int[N + 1];
        
        //1. 출발 지점 외 나머지 지점까지의 최소 비용은 최대로 지정해둔다
        for (int i = 0; i < N + 1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
        dist[0] = dist[1] = 0;
        
        // 2. 그래프 내부의 모든 정점을 초기화 한다.
       for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 3. 그래프의 모든 값을 채워 넣는다.
        for (int[] ints : road) {
            int u = ints[0], v = ints[1], w = ints[2];
            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

       // 4. 다익스트라 알고리즘을 진행한다.
		// 모든 노드을 방문하면 종료하기 때문에, 노드의 개수 만큼만 반복을 한다.
		for (int i = 0; i < N; i++) {
			// 4 - 1. 현재 거리 비용 중 최소인 지점을 선택한다.
			// 해당 노드가 가지고 있는 현재 비용.
			int nodeValue = Integer.MAX_VALUE;
			// 해당 노드의 인덱스(번호).
			int nodeIdx = 0;
			// 인덱스 0은 생각하지 않기 때문에 0부터 반복을 진행한다.
			for (int j = 1; j < N + 1; j++) {
				// 해당 노드를 방문하지 않았고, 현재 모든 거리비용 중 최솟값을 찾는다.
				if (!visited[j] && dist[j] < nodeValue) {
					nodeValue = dist[j];
					nodeIdx = j;
				}
			}
			// 최종 선택된 노드를 방문처리 한다.
			visited[nodeIdx] = true;

			// 4 - 2. 해당 지점을 기준으로 인접 노드의 최소 거리 값을 갱신한다.
			for (int j = 0; j < graph[nodeIdx].size(); j++) {
				// 인접 노드를 선택한다.
				Node adjNode = graph[nodeIdx].get(j);
				// 인접 노드가 현재 가지는 최소 비용과
				// 현재 선택된 노드의 값 + 현재 노드에서 인접 노드로 가는 값을 비교하여 더 작은 값으로 갱신한다.
				if (dist[adjNode.idx] > dist[nodeIdx] + adjNode.cost) {
					dist[adjNode.idx] = dist[nodeIdx] + adjNode.cost;
				}
			}
		}
        
        for(int i = 1; i< N + 1; i ++){
            if(dist[i] <= K)answer++;
        }
        
        
        return answer;
    }

    static class Node {
        int idx;
        int cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}