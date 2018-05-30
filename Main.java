package com.sd.weather;

import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.QuotePost;
import com.tumblr.jumblr.types.TextPost;
import com.tumblr.jumblr.types.User;

public class Main {

    static final String CONSUMER_KEY = "dqddgY8lpMiMV9DrnC7fWczvi394ESxqQ63agULe4Rvb2l92Qk";
    static final String SECRET_KEY = "alALJbwV1GZJSYCMkHjxSq3XdxZT9VJThhZF3YRVu6BWaRdAcs";

    public static void main(String[] args) {
        // Authenticate via OAuth
        JumblrClient client = new JumblrClient(
                "dqddgY8lpMiMV9DrnC7fWczvi394ESxqQ63agULe4Rvb2l92Qk",
                "alALJbwV1GZJSYCMkHjxSq3XdxZT9VJThhZF3YRVu6BWaRdAcs"
        );
        client.setToken(
                "P5E4grbdQ6olNyZy71DRxMO5RCqeSRXcVkAPmARVVzF6a9ARWF",
                "8uODK783KJNi6i3yS5EKuuzNF1anQ657VX1Y0cs8rG3nnO0q2s"
        );

// Make the request
        User user = client.user();
        System.out.println(user.getName());

        if(args.length < 1) {
            System.out.println("No arguments supplied, destroying.");
            System.exit(7384663);
        }

        else {
            TextPost currentPost;
            try {
                currentPost = client.newPost("sdweather", TextPost.class);
                currentPost.setTitle("Weather");
                currentPost.setBody("Temperature: " + args[0] + "\nPressure: " + args[1]);
                currentPost.setState("queued");
                currentPost.save();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    }
}
