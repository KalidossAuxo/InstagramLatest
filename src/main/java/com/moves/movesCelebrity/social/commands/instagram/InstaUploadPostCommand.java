package com.moves.movesCelebrity.social.commands.instagram;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.moves.movesCelebrity.social.types.Command;
import com.moves.movesCelebrity.utils.Constants;
import org.bson.Document;

import java.util.concurrent.CompletableFuture;

public class InstaUploadPostCommand implements Command<Document, String> {

    public InstaUploadPostCommand() {
    }

    @Override
    public CompletableFuture<Document> execute(String arg) {
        return CompletableFuture.supplyAsync(() -> {
            Document containerId = null;
            try {
                containerId = uploadPost(arg);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return containerId;
        });
    }

    private Document uploadPost(String arg) {

        String url = Constants.INSTAGRAM_FETCH_CONTAINER;
        HttpResponse<JsonNode> httpResponse = null;
        Document publishDoc = null;
        try {
            String response = Unirest.get(url).asJson().getBody().toString();
            if (response != null && !response.contains("error_code")) {
                Document doc = Document.parse(response.toString());
                int containerId = 0;
                //check the response and parse the value of containerId to the above integer
                String publishUrl = Constants.INSTAGRAM_PUBLISH_POST;
                String publishResponse = Unirest.get(publishUrl).asJson().getBody().toString();
                if (publishResponse != null && !publishResponse.contains("error_code")) {
                    publishDoc = Document.parse(publishResponse.toString());
                }
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return publishDoc;
    }
}
