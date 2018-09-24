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

public class InstaFetchUserDetails implements Command<Document, String> {

    public InstaFetchUserDetails() {
    }


    @Override
    public CompletableFuture<Document> execute(String arg) {
        return CompletableFuture.supplyAsync(() -> {
            Document posts = null;
            try {
                posts = fetchUserDetails(arg);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return posts;
        });
    }

    public Document fetchUserDetails(String accessToken) throws IOException {

        Document posts = null;
        HttpResponse<JsonNode> httpResponse = null;
        String url = String.format(Constants.USER_BASIC_DETAILS, accessToken);
        try {
            httpResponse = Unirest.get(url).asJson();
            String response = httpResponse.getBody().toString();
            if (response != null && !response.contains("error_code")) {
                Document doc = Document.parse( response.toString() );
                posts = (Document) doc.get("data");
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return posts;
    }
}
