package com.basic.leetcode;

import javafx.util.Pair;

import java.util.*;

/**
 * 5305. 获取你好友已观看的视频  显示英文描述
 * 用户通过次数 341
 * 用户尝试次数 528
 * 通过次数 348
 * 提交次数 1169
 * 题目难度 Medium
 * 有 n 个人，每个人都有一个  0 到 n-1 的唯一 id 。
 * <p>
 * 给你数组 watchedVideos  和 friends ，其中 watchedVideos[i]  和 friends[i] 分别表示 id = i 的人观看过的视频列表和他的好友列表。
 * <p>
 * Level 1 的视频包含所有你好友观看过的视频，level 2 的视频包含所有你好友的好友观看过的视频，以此类推。一般的，Level 为 k 的视频包含所有从你出发，最短距离为 k 的好友观看过的视频。
 * <p>
 * 给定你的 id  和一个 level 值，请你找出所有指定 level 的视频，并将它们按观看频率升序返回。如果有频率相同的视频，请将它们按名字字典序从小到大排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 1
 * 输出：["B","C"]
 * 解释：
 * 你的 id 为 0 ，你的朋友包括：
 * id 为 1 -> watchedVideos = ["C"]
 * id 为 2 -> watchedVideos = ["B","C"]
 * 你朋友观看过视频的频率为：
 * B -> 1
 * C -> 2
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 2
 * 输出：["D"]
 * 解释：
 * 你的 id 为 0 ，你朋友的朋友只有一个人，他的 id 为 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == watchedVideos.length == friends.length
 * 2 <= n <= 100
 * 1 <= watchedVideos[i].length <= 100
 * 1 <= watchedVideos[i][j].length <= 8
 * 0 <= friends[i].length < n
 * 0 <= friends[i][j] < n
 * 0 <= id < n
 * 1 <= level < n
 * 如果 friends[i] 包含 j ，那么 friends[j] 包含 i
 */
public class Solution5305 {

    public static void main(String[] args) {
        Solution5305 solution = new Solution5305();
        List<List<String>> watchedVideos = new ArrayList<>();
        List<String> video1 = new ArrayList<>();
        video1.add("A");
        video1.add("B");
        watchedVideos.add(video1);
        List<String> video2 = new ArrayList<>();
        video2.add("C");
        watchedVideos.add(video2);
        List<String> video3 = new ArrayList<>();
        video3.add("B");
        video3.add("C");
        watchedVideos.add(video3);
        List<String> video4 = new ArrayList<>();
        video4.add("D");
        watchedVideos.add(video4);

//        List<String> strings = solution.watchedVideosByFriends(watchedVideos, new int[][]{{1, 2}, {0, 3}, {0, 3}, {1, 2}}, 0, 1);
//        System.out.println(strings);
//
//        List<String> strings1 = solution.watchedVideosByFriends(watchedVideos, new int[][]{{1, 2}, {0, 3}, {0, 3}, {1, 2}}, 1, 1);
//        System.out.println(strings1);
//
//        List<String> strings2 = solution.watchedVideosByFriends(watchedVideos, new int[][]{{1, 2}, {0, 3}, {0, 3}, {1, 2}}, 2, 1);
//        System.out.println(strings2);

        List<String> strings3 = solution.watchedVideosByFriends(watchedVideos, new int[][]{{1, 2}, {0, 3}, {0, 3}, {1, 2}}, 0, 2);
        System.out.println(strings3);
    }

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int rank = 1;
        List<Integer> temp = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < friends[id].length; i++) {
            if (!visited.contains(id)) {
                visited.add(id);
                temp.add(friends[id][i]);
            }
        }

        while (rank < level) {
            List<Integer> leveltemp = new ArrayList<>();
            for (int i = 0; i < temp.size(); i++) {
                int[] friend = friends[temp.get(i)];
                if (!visited.contains(temp.get(i))) {
                    visited.add(temp.get(i));
                    for (int j = 0; j < friend.length; j++) {
                        leveltemp.add(friend[j]);
                    }
                }
            }
            temp = leveltemp;
            rank++;
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < temp.size(); i++) {
            List<String> videos = watchedVideos.get(temp.get(i));
            for (String video : videos) {
                map.put(video, map.getOrDefault(video, 0) + 1);
            }
        }

        List<String> result = new ArrayList<>();
        map.keySet().forEach(a -> result.add(a));

        return result;
    }

    public List<String> watchedVideosByFriends2(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(id);
        visited.add(id);
        int len = 0;
        while (!queue.isEmpty() && len < level) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer idd = queue.poll();
                for (int j = 0; j < friends[idd].length; j++) {
                    if (!visited.contains(friends[idd][j])) {
                        queue.add(friends[idd][j]);
                        visited.add(friends[idd][j]);
                    }
                }
            }
            len++;
        }

        Map<String, Integer> map = new HashMap<>();
        while (!queue.isEmpty()) {
            Integer idd = queue.poll();
            for (int i = 0; i < watchedVideos.get(idd).size(); i++) {
                map.put(watchedVideos.get(idd).get(i), map.getOrDefault(watchedVideos.get(idd).get(i), 0) + 1);
            }
        }

        PriorityQueue<Pair<String, Integer>> priorityQueue = new PriorityQueue<>((t1, t2) -> {
            if (t1.getValue().equals(t2.getValue())) {
                return t1.getKey().compareTo(t2.getKey());
            } else {
                return t1.getValue().compareTo(t2.getValue());
            }
        });
        map.forEach((key, value) -> priorityQueue.add(new Pair<>(key, value)));
        List<String> ans = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            ans.add(priorityQueue.poll().getKey());
        }
        return ans;
    }

}
