package com.basic.datastruct.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        User tom = new User(2, "Tom");
        User jack = new User(2, "Jack");
        User tony = new User(3, "Tony");
        User bob = new User(3, "Bob");
        User hahahhh = new User(1, "Hahahhh");

        PriorityQueue<User> queue = new PriorityQueue<User>(new UserComparator());

        queue.add(tom);
        queue.add(tom);
        queue.add(jack);
        queue.add(jack);
        queue.add(tony);
        queue.add(tony);
        queue.add(bob);
        queue.add(bob);
        queue.add(hahahhh);

        while (queue.size() > 0) {
            User user = queue.poll();
            System.out.println(user.username);
        }
    }

}

class UserComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return o1.priority - o2.priority;
    }

}

class User {
    int priority;
    String username;

    public User(int priority, String username) {
        this.priority = priority;
        this.username = username;
    }

}
