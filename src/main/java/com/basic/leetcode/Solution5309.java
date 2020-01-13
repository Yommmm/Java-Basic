package com.basic.leetcode;

/**
 * 用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。
 * <p>
 * 网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
 * <p>
 * 给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 4, connections = [[0,1],[0,2],[1,2]]
 * 输出：1
 * 解释：拔下计算机 1 和 2 之间的线缆，并将它插到计算机 1 和 3 上。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
 * 输出：-1
 * 解释：线缆数量不足。
 * 示例 4：
 * <p>
 * 输入：n = 5, connections = [[0,1],[0,2],[3,4],[2,3]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^5
 * 1 <= connections.length <= min(n*(n-1)/2, 10^5)
 * connections[i].length == 2
 * 0 <= connections[i][0], connections[i][1] < n
 * connections[i][0] != connections[i][1]
 * 没有重复的连接。
 * 两台计算机不会通过多条线缆连接。
 */
public class Solution5309 {

    public static void main(String[] args) {
        Solution5309 solution = new Solution5309();
//        System.out.println(solution.makeConnected(4, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
//        System.out.println(solution.makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}}));
//        System.out.println(solution.makeConnected(5, new int[][]{{0, 1}, {0, 2}, {3, 4}, {2, 3}}));
//        System.out.println(solution.makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}}));
//
//        System.out.println(solution.makeConnected(11, new int[][]{{1, 4}, {0, 3}, {1, 3}, {3, 7}, {2, 7}, {0, 1}, {2, 4}, {3, 6}, {5, 6}, {6, 7}, {4, 7}, {0, 7}, {5, 7}}));

        System.out.println(solution.makeConnected(100, new int[][]{{17, 51}, {33, 83}, {53, 62}, {25, 34}, {35, 90}, {29, 41}, {14, 53}, {40, 84}, {41, 64}, {13, 68}, {44, 85}, {57, 58}, {50, 74}, {20, 69}, {15, 62}, {25, 88}, {4, 56}, {37, 39}, {30, 62}, {69, 79}, {33, 85}, {24, 83}, {35, 77}, {2, 73}, {6, 28}, {46, 98}, {11, 82}, {29, 72}, {67, 71}, {12, 49}, {42, 56}, {56, 65}, {40, 70}, {24, 64}, {29, 51}, {20, 27}, {45, 88}, {58, 92}, {60, 99}, {33, 46}, {19, 69}, {33, 89}, {54, 82}, {16, 50}, {35, 73}, {19, 45}, {19, 72}, {1, 79}, {27, 80}, {22, 41}, {52, 61}, {50, 85}, {27, 45}, {4, 84}, {11, 96}, {0, 99}, {29, 94}, {9, 19}, {66, 99}, {20, 39}, {16, 85}, {12, 27}, {16, 67}, {61, 80}, {67, 83}, {16, 17}, {24, 27}, {16, 25}, {41, 79}, {51, 95}, {46, 47}, {27, 51}, {31, 44}, {0, 69}, {61, 63}, {33, 95}, {17, 88}, {70, 87}, {40, 42}, {21, 42}, {67, 77}, {33, 65}, {3, 25}, {39, 83}, {34, 40}, {15, 79}, {30, 90}, {58, 95}, {45, 56}, {37, 48}, {24, 91}, {31, 93}, {83, 90}, {17, 86}, {61, 65}, {15, 48}, {34, 56}, {12, 26}, {39, 98}, {1, 48}, {21, 76}, {72, 96}, {30, 69}, {46, 80}, {6, 29}, {29, 81}, {22, 77}, {85, 90}, {79, 83}, {6, 26}, {33, 57}, {3, 65}, {63, 84}, {77, 94}, {26, 90}, {64, 77}, {0, 3}, {27, 97}, {66, 89}, {18, 77}, {27, 43}}));

    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;

        Integer[] unionFind = new Integer[n];

        for (int[] connection : connections) {
            unionFind[connection[1]] = connection[0];
            if (null != unionFind[connection[0]] && unionFind[connection[0]] != connection[0])
                unionFind[connection[0]] = connection[1];
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("index: " + i + " parent: " + unionFind[i]);
            if (null == unionFind[i]) result += 1;
        }

        return result;
    }

}
