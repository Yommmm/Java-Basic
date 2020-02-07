package com.basic.leetcode;

import java.util.*;

public class Twitter {

    private Map<Integer, Set<Integer>> followeeMap; //键：用户ID；值：该用户关注的人的ID集合

    private Map<Integer, List<Integer>> userTweetMap;   //建：用户ID；值：该用户发表的推文链表

    private Map<Integer, Integer> tweetToIndex; //键：推文ID；值：推文编号

    private int index;  //推文编号，从0开始

    public Twitter() {
        followeeMap = new HashMap<>();
        userTweetMap = new HashMap<>();
        tweetToIndex = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!userTweetMap.containsKey(userId)) {
            userTweetMap.put(userId, new ArrayList<>());
        }
        userTweetMap.get(userId).add(0, tweetId);
        tweetToIndex.put(tweetId, index++);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        List<Integer> userList = new ArrayList<>();
        Set<Integer> followees = followeeMap.get(userId);
        if (null != followees) {
            userList.addAll(followees);
            if (!followees.contains(userId)) {
                userList.add(userId);
            }
        } else {
            userList.add(userId);
        }
        int[] curs = new int[userList.size()]; //有多少个用户，就有多少个推文链表，也就需要多少个指针
        while (result.size() < 10) {
            int maxIndex = -1, max = Integer.MIN_VALUE;
            for (int i = 0; i < userList.size(); i++) {
                List<Integer> tweets = userTweetMap.get(userList.get(i));
                if (null != tweets && curs[i] < tweets.size() && max < tweetToIndex.get(tweets.get(curs[i]))) {
                    maxIndex = i;
                    max = tweetToIndex.get(tweets.get(curs[i]));
                }
            }
            if (maxIndex == -1) {
                break;
            }
            result.add(userTweetMap.get(userList.get(maxIndex)).get(curs[maxIndex]++));
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (!followeeMap.containsKey(followerId)) {
            followeeMap.put(followerId, new HashSet<>());
        }
        followeeMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followeeMap.containsKey(followerId)) {
            followeeMap.get(followerId).remove(followeeId);
        }
    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
}
