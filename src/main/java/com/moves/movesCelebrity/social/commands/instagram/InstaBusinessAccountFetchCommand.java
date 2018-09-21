package com.moves.movesCelebrity.social.commands.instagram;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.moves.movesCelebrity.social.types.Command;
import com.moves.movesCelebrity.utils.Constants;
import org.bson.Document;

import java.util.concurrent.CompletableFuture;

public class InstaBusinessAccountFetchCommand implements Command<Document, String>{

    public InstaBusinessAccountFetchCommand(){
    }

    @Override
    public CompletableFuture<Document> execute(String arg) {
        return CompletableFuture.supplyAsync(() -> {
            Document posts = null;
            try {
                posts = fetchBusinessAccountData(arg);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return posts;
        });
    }

    private Document fetchBusinessAccountData(String arg) {
        HttpResponse<JsonNode>httpResponse = null;
        String url = String.format(Constants.FETCH_INSTAGRAM_BUSINESS_ACCOUNT, arg);
        Document doc = null;
        try {
            httpResponse = Unirest.get(url).asJson();
            String response = httpResponse.getBody().toString();
            if (response != null && !response.contains("error_code")) {
                doc = Document.parse( response.toString() );
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return doc;
    }
}
