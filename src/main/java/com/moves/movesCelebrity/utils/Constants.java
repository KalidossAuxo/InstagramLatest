package com.moves.movesCelebrity.utils;

import com.fasterxml.jackson.databind.cfg.MutableConfigOverride;
import com.moves.movesCelebrity.configuration.MovesConfiguration;

import static com.moves.movesCelebrity.configuration.MovesConfiguration.INSTAGRAM_ACCESS_TOKEN;

public class Constants {

    public static final String USER_BASIC_DETAILS = "https://api.instagram.com/v1/users/self/?access_token="+ MovesConfiguration.INSTAGRAM_ACCESS_TOKEN;
    public static final String RECENT_MEDIA_URL = "https://api.instagram.com/v1/users/self/media/recent/?access_token="+MovesConfiguration.INSTAGRAM_ACCESS_TOKEN;
    public static final String INSTA_SEARCH_BY_TAG_URL = "https://api.instagram.com/v1/tags/%1$s/media/recent?access_token="+MovesConfiguration.INSTAGRAM_ACCESS_TOKEN;
    public static final String INSTA_MEDIA_LOCATION_URL = "https://api.instagram.com/v1/media/search?lat=20.593683&lng=78.962883&access_token="+MovesConfiguration.INSTAGRAM_ACCESS_TOKEN;
    public static final String FACEBOOK_GRAPH_API_URL = "https://graph.facebook.com/v3.1/";
    public static final String FETCH_INSTAGRAM_BUSINESS_ACCOUNT = FACEBOOK_GRAPH_API_URL + "/%$1s?fields=instagram_business_account";
    public static final String INSTAGRAM_FETCH_CONTAINER = FACEBOOK_GRAPH_API_URL + "/media?image_url=%1$s&caption=%2$s";
    public static final String INSTAGRAM_PUBLISH_POST = FACEBOOK_GRAPH_API_URL + "%1$s/media_publish?creation_id=%2$s";
    public static final String INSTAGRAM_ACCOUNT_INSIGHTS = FACEBOOK_GRAPH_API_URL + "%1$s/insights?metric=impressions,reach,profile_views&period=day";
    public static final String INSTAGRAM_MEDIA_INSIGHTS = FACEBOOK_GRAPH_API_URL + "%1$s/insights?metric=impressions,reach,engagement";
    public static final String INSTAGRAM_MEDIA_COMMENTS = "https://api.instagram.com/v1/media/%1$s/comments?access_token="+MovesConfiguration.INSTAGRAM_ACCESS_TOKEN;

}
