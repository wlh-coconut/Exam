//
//  main.cpp
//  ali3
//
//  Created by 代虎林 on 2020/4/20.
//  Copyright © 2020 daihulin. All rights reserved.
//

#include <iostream>
#include <vector>
#include <limits.h>

using namespace std;

int Floyd(vector<vector<int>> dis, vector<int> A) {
    int n = A.size();
    for (int i = 0; i < n; i++) {
        dis[i][i] = 0;//顶点i到i的距离初始化为0
    }
    int ans = INT_MAX;
    for (int k = 0; k < n; k++) {
        for (int u = 0; u < n; u++) {
            for (int v = 0; v < n; v++) {
                if (dis[u][k] != INT_MAX && dis[k][v] != INT_MAX && dis[u][k]+dis[k][v]<dis[u][v]) {
                    dis[u][v] = dis[u][k] + dis[k][v];//找到更短的路径
                    if (A[u] == A[v] && dis[u][v] < ans) {
                        ans = dis[u][v];
                    }
                }
            }
        }
    }
    return ans;
}
int main(int argc, const char * argv[]) {
    // insert code here...
    int n;
    cin >> n;
    vector<int> A(n);
    vector<vector<int>> dis(n, vector<int>(n, INT_MAX));
    for (int i = 0; i < n; ++i) {
        cin >> A[i];
    }
    int u, v;
    for (int i = 0; i < n-1; ++i) {
        cin >> u >> v;
        dis[u-1][v-1] = 1;
    }
    
    cout << Floyd(dis, A);
    
    return 0;
}

