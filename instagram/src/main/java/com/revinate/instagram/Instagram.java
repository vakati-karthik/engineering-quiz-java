package com.revinate.instagram;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import com.revinate.instagram.User;

/**
 * Your Instagram object will be instantiated and called as such:
 * Instagram instagram = new Instagram();
 * instagram.postMedia(userId,mediaId);
 * List<Integer> feed = instagram.getMediaFeed(userId);
 * instagram.follow(followerId,followedId);
 * instagram.unfollow(followerId,followedId);
 */

public class Instagram {

    private Map<Integer, User> userInfo;
    private Map<Integer, Integer> mediaOrder;
    private static int mediaOrderId = 1;

    /** Initialize your data structure here. */
    public Instagram() {
        userInfo = new HashMap<Integer, User>();
        mediaOrder = new HashMap<Integer, Integer>();
    }

    /** Add a new media.
     * Since this class doesn't give any information whether a user is existing or not,
     * I create the user who posts the media for the first time i.e.,
     * I create the user whenever I don't find this user from the list of users who posted the media atleast once
     * */
    public void postMedia(int userId, int mediaId) {
        //Assuming postMedia creates a new user whenever this is the first post of this user
        if (!userInfo.containsKey(userId))
            createUser(userId);
        userInfo.get(userId).getMediaPosts().add(mediaId);
        mediaOrder.put(mediaId, mediaOrderId++);
    }

    /** Retrieve the 10 most recent media ids in the user's media feed.
     * Each media must be posted by the user herself or by someone the user follows
     * Media must be ordered from most recent to least recent. */
    public List<Integer> getMediaFeed(int userId) {
        if (!userInfo.containsKey(userId))
            return null;
        User user = userInfo.get(userId);
        Set<Integer> currentUserMedia = new HashSet<Integer>(user.getMediaPosts());
        user.getFollowsList().forEach(followedUserId -> currentUserMedia.addAll(userInfo.get(followedUserId).getMediaPosts()));
        List<Integer> list = new ArrayList(currentUserMedia);
        list.sort((mediaId1, mediaId2) -> mediaOrder.get(mediaId2) - mediaOrder.get(mediaId1));
        return list.size() > 10 ? list.subList(0, 10) : list;
    }

    /** A Follower follows a followed. Nothing happens if invalid
     * The following cases are considered for this method.
     * I assume there can be idle users who haven't posted the media yet.
     * Since this class doesn't give any information whether a user is existing or not,
     * I create a user whenever I don't find this user from the list of users who posted the media atleast once and
     * this user follows or being followed by other users.
     * Also there can be cases where user1 follows user2 who then starts posting media.
     * */
    public void follow(int followerId, int followedId) {
        if (!userInfo.containsKey(followerId))
            createUser(followerId);
        if (!userInfo.containsKey(followedId))
            createUser(followedId);
        userInfo.get(followerId).getFollowsList().add(followedId);
    }

    /** A Follower unfollows a followed. Nothing happens if invalid */
    public void unfollow(int followerId, int followedId) {
        if (userInfo.containsKey(followerId) && userInfo.containsKey(followedId))
            userInfo.get(followerId).getFollowsList().remove(followedId);
    }

    public void createUser(int userId) {
        userInfo.put(userId, new User());
    }

    public Map<Integer, User> getUserInfo(){
        return userInfo;
    }
}


