package com.revinate.instagram;

import java.util.Collections;
import java.util.List;

/**
 * Your Instagram object will be instantiated and called as such:
 * Instagram instagram = new Instagram();
 * instagram.postMedia(userId,mediaId);
 * List<Integer> feed = instagram.getMediaFeed(userId);
 * instagram.follow(followerId,followedId);
 * instagram.unfollow(followerId,followedId);
 */

public class Instagram {

    /** Initialize your data structure here. */
    public Instagram() {

    }

    /** Add a new media. */
    public void postMedia(int userId, int mediaId) {

    }

    /** Retrieve the 10 most recent media ids in the user's media feed.
     * Each media must be posted by the user herself or by someone the user follows
     * Media must be ordered from most recent to least recent. */
    public List<Integer> getMediaFeed(int userId) {
        return Collections.emptyList();
    }

    /** A Follower follows a followed. Nothing happens if invalid */
    public void follow(int followerId, int followedId) {

    }

    /** A Follower unfollows a followed. Nothing happens if invalid */
    public void unfollow(int followerId, int followedId) {

    }
}


