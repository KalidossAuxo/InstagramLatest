package com.moves.movesCelebrity.social.commands.instagram;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.moves.movesCelebrity.social.types.Command;
import com.moves.movesCelebrity.utils.Constants;
import org.bson.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class InstaPostFetchCommand implements Command<ArrayList<Document>, String> {

    public InstaPostFetchCommand() {
    }

    @Override
    public CompletableFuture<ArrayList<Document>> execute(String arg) {
        return CompletableFuture.supplyAsync(() -> {
            ArrayList<Document> posts = null;
            try {
                posts = fetchInstaPosts(arg);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return posts;
        });
    }

    public ArrayList<Document> fetchInstaPosts(String accessToken) throws IOException {

        ArrayList<Document> posts = null;
        HttpResponse<JsonNode> httpResponse = null;
        String url = String.format(Constants.RECENT_MEDIA_URL, accessToken);
        try {
            httpResponse = Unirest.get(url).asJson();
            String response = httpResponse.getBody().toString();
            if (response != null && !response.contains("error_code")) {
                Document doc = Document.parse( response.toString() );
                posts = (ArrayList<Document>) doc.get("data");
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return posts;
    }
}
