package edu.pprakashumd.tabdemo;

import android.app.ListActivity;
import android.os.Bundle;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.TweetUi;
import com.twitter.sdk.android.tweetui.UserTimeline;

import io.fabric.sdk.android.Fabric;


public class PullingTweets extends ListActivity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "pf9nKLgyg0xSYkQPs427T7ON0";
    private static final String TWITTER_SECRET = "o98K9CFnuQJsjXlIcU2Yxs6xmk733CvjqtH9xwEZrFOBAuTAGn";

    private long uOfMarylandID = 16129880;
    private long presidentLohID = 299743215;
    private long diamondbackID = 36003748;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig), new TweetUi());
        setContentView(R.layout.timeline);

        // UMD
        UserTimeline userTimeline = new UserTimeline.Builder()
                .userId(diamondbackID)
                //.screenName("UofMaryland")
                .build();

        UserTimeline userTimeline2 = new UserTimeline.Builder()
                .userId(presidentLohID)
                //.screenName("UofMaryland")
                .build();

        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(this)
                .setTimeline(userTimeline)
                .build();

        final TweetTimelineListAdapter adapter2 = new TweetTimelineListAdapter.Builder(this)
                .setTimeline(userTimeline2)
                .build();

        setListAdapter(adapter);
    }
}

