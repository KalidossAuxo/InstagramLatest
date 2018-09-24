package com.moves.movesCelebrity.configuration;

import io.dropwizard.Configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MovesConfiguration extends Configuration {

    public static final String COLLECTION_POSTS_INSTAGRAM = "posts_instagram";
    public static final String COLLECTION_TRENDS_INSTAGRAM = "trends_instagram";
    public static final String INSTAGRAM_ACCESS_TOKEN = "8570581783.244de53.e32a60487f8c4ef19258984fc9a6cb58";
    public static final String COLLECTION_INSTA_MEDIA_BY_TAG = "insta_trends_by_tag";
    public static final String COLLECTION_USER_DETAILS = "user_details_instagram";
    public static final String COLLECTION_MEDIA_COMMENTS = "media_comments_instagram";

    public static final String DB_NAME = "movesCelebrity";
    public static final Map<String, String> PLATFORM_MAP;

    static {
        HashMap<String, String> aMap = new HashMap<>();
        aMap.put("twitter", "dulquer");
        aMap.put("instagram", "408096151.9437cac.ab7a30150efe44fb81d5dc83ffa16543");
        aMap.put("twitter.trends", "Mumbai");
        aMap.put("instagram.trends", "lat=48.858844&lng=2.294351");
        PLATFORM_MAP = Collections.unmodifiableMap(aMap);
    }
}
