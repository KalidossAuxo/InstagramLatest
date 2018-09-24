package com.moves.movesCelebrity.social.commands.instagram;

import com.moves.movesCelebrity.configuration.MovesConfiguration;
import com.moves.movesCelebrity.dao.SocialMediaPostDao;
import com.moves.movesCelebrity.social.types.Command;
import org.bson.Document;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class InstaWriteUserDetails implements Command<Void, Document> {

    @Override
    public CompletableFuture<Void> execute(Document documents) {
        return CompletableFuture.supplyAsync(() -> {
            insert(documents);
            return null;
        });
    }

    public void insert(Document documents) {
        if (documents != null && documents.size() != 0)
            SocialMediaPostDao.insert(documents, MovesConfiguration.COLLECTION_USER_DETAILS);
    }
}
