package com.revinate.instagram;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InstagramTest {

    @Test
    public void testPostMedia() throws Exception {
        Instagram instagram = new Instagram();
        instagram.postMedia(1,-1000);
        Thread.sleep(1);
        instagram.postMedia(-1,-1001);
        Thread.sleep(1);
        instagram.postMedia(2,1135);
        Thread.sleep(1);
        instagram.postMedia(3,1092);
        Thread.sleep(1);
        instagram.postMedia(3,3094);
        Thread.sleep(1);
        instagram.postMedia(1,1022);
        Thread.sleep(1);
        instagram.postMedia(-1,9);
        assertThat(instagram.getUserInfo().size(), is(4));
    }

    @Test
    public void testGetMediaFeed() throws Exception {
        Instagram instagram = new Instagram();
        instagram.postMedia(1,1025);
        Thread.sleep(1);
        instagram.postMedia(2,1135);
        Thread.sleep(1);
        instagram.postMedia(3,1092);
        Thread.sleep(1);
        instagram.postMedia(3,3094);
        Thread.sleep(1);
        instagram.postMedia(1,1022);

        instagram.follow(1, 2);
        instagram.follow(1, 3);

        // The following tests test for the order from most recent to least recent
        List<Integer> feed = instagram.getMediaFeed(1);
        assertThat(feed.get(0), is(1022));
        assertThat(feed.get(1), is(3094));
        assertThat(feed.get(2), is(1092));
        assertThat(feed.get(3), is(1135));
        assertThat(feed.get(4), is(1025));

        instagram.unfollow(1, 3);

        List<Integer> feed_2 = instagram.getMediaFeed(1);
        assertThat(feed_2.get(0), is(1022));
        assertThat(feed_2.get(1), is(1135));
        assertThat(feed_2.get(2), is(1025));

        // The following tests test for total number of media
        instagram.postMedia(1,999);
        Thread.sleep(1);
        instagram.postMedia(2,1234);
        Thread.sleep(1);
        instagram.postMedia(1,1111);
        Thread.sleep(1);
        instagram.postMedia(2,2016);
        Thread.sleep(1);
        instagram.postMedia(1,222);
        Thread.sleep(1);
        instagram.postMedia(2,2017);
        Thread.sleep(1);
        instagram.postMedia(1,333);
        Thread.sleep(1);
        instagram.postMedia(1,444);
        Thread.sleep(1);
        instagram.postMedia(2,2018);

        List<Integer> feed_3 = instagram.getMediaFeed(1);
        assertThat(feed_3.size(), is(10));

        instagram.unfollow(1, 2);
        List<Integer> feed_4 = instagram.getMediaFeed(1);
        assertThat(feed_4.size(), is(7));
    }

    @Test
    public void testFollowUnfollowMethods() throws Exception {
        Instagram instagram = new Instagram();
        instagram.postMedia(1,111);
        Thread.sleep(1);
        instagram.postMedia(2,222);
        instagram.follow(1, 2);
        instagram.follow(1, 4);
        instagram.follow(1, 3);

        List<Integer> feed_1 = instagram.getMediaFeed(1);
        assertThat(feed_1.size(), is(2));

        instagram.postMedia(4,1000);
        instagram.unfollow(1, 3);
        List<Integer> feed_2 = instagram.getMediaFeed(1);
        assertThat(feed_2.size(), is(3));

        instagram.postMedia(3,2000);
        List<Integer> feed_3 = instagram.getMediaFeed(1);
        assertThat(feed_3.size(), is(3));

        instagram.follow(1, 3);
        List<Integer> feed_4 = instagram.getMediaFeed(1);
        assertThat(feed_4.size(), is(4));

        instagram.unfollow(2, 3);
        instagram.unfollow(7, 9);
        instagram.unfollow(7, 2);
        instagram.unfollow(2, 9);

        assertThat(instagram.getUserInfo().size(), is(4));
    }
}