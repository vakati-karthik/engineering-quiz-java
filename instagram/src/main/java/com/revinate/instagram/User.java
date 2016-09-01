package com.revinate.instagram;

import java.util.Set;
import java.util.HashSet;

public class User {

    private Set<Integer> mediaPosts;

    private Set<Integer> followsList;

    public User() {
        mediaPosts = new HashSet<Integer>();
        followsList = new HashSet<Integer>();
    }

    public Set<Integer> getMediaPosts() {
        return mediaPosts;
    }

    public Set<Integer> getFollowsList() {
        return followsList;
    }

}