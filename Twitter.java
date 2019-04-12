import java.util.*;

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

public class Twitter {

    private static final int userNewsFeedNum = 10;
    private static HashMap<Integer, TreeMap<Long, Integer>> userNewsFeeds;
    private static HashMap<Integer, HashSet<Integer>> userFollowIds;

    /** Initialize your data structure here. */
    public Twitter() {
        userNewsFeeds = new HashMap<>();
        userFollowIds = new HashMap<>();

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        // record the posting time
        Long current = System.nanoTime();
        // retrieve the newsFeed map by userId
        TreeMap<Long, Integer> newsFeed = new TreeMap<>();
        if(userNewsFeeds.containsKey(userId)){
            newsFeed = userNewsFeeds.get(userId);
        }
        newsFeed.put(current, tweetId);
        // update the newer newsFeed for the userId
        userNewsFeeds.put(userId, newsFeed);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        // get the followed IDs by the user ID
        HashSet<Integer> followedIDs = new HashSet<>();
        if (userFollowIds.containsKey(userId)){
            followedIDs = userFollowIds.get(userId);
        }
        // add the userID itself for the news feed
        followedIDs.add(userId);

        TreeMap<Long, Integer> currentNewsFeed = new TreeMap<>();
        for (Integer i : followedIDs) {
            if (userNewsFeeds.containsKey(i)){
                currentNewsFeed.putAll(userNewsFeeds.get(i));
            }
        }

        List<Integer> result = new ArrayList<>();
        Iterator<Long> newsFeedTime = currentNewsFeed.descendingKeySet().iterator();
        int getNum = 0;
        while (newsFeedTime.hasNext() && getNum < 10){
            result.add(currentNewsFeed.get(newsFeedTime.next()));
            getNum++;
        }
        return result;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> followee = new HashSet<>();
        if (userFollowIds.containsKey(followerId)){
            followee = userFollowIds.get(followerId);
        }
        followee.add(followeeId);
        userFollowIds.put(followerId, followee);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> followee = new HashSet<>();
        if (userFollowIds.containsKey(followerId)){
            followee = userFollowIds.get(followerId);
        }
        followee.remove(followeeId);
        userFollowIds.put(followerId, followee);
    }

    public static void main(String[] args){
        Twitter obj = new Twitter();
        obj.postTweet(1,5);
        obj.follow(1,2);
        obj.follow(2,1);
        System.out.println(obj.getNewsFeed(2));
        obj.postTweet(2,6);
        System.out.println(obj.getNewsFeed(1));
        System.out.println(obj.getNewsFeed(2));
        obj.unfollow(2, 1);
        System.out.println(obj.getNewsFeed(1));
        System.out.println(obj.getNewsFeed(2));
        obj.unfollow(1, 2);
        System.out.println(obj.getNewsFeed(1));
        System.out.println(obj.getNewsFeed(2));
    }
}
