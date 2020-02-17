package com.basic.leetcode;

/**
 * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 * <p>
 * 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: -3, 0, 3, 4, 0, -1, 9, 2
 * 输出: 45
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rectangle-area
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution223 {

    public static void main(String[] args) {

    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (D - B) * (C - A);
        int area2 = (H - F) * (G - E);

        // 沒有重合
        if (E >= C || G <= A || F >= D || H <= B) {
            return area1 + area2;
        }

        // 重合部分右边界，左边界，上边界，下边界
        int area3 = (Math.min(C, G) - Math.max(E, A)) * (Math.min(D, H) - Math.max(F, B));

        return area1 + area2 - area3;
    }

}
