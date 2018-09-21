package com.moves.movesCelebrity.social.commands.instagram;

import com.moves.movesCelebrity.social.types.Command;
import org.bson.Document;

import java.util.concurrent.CompletableFuture;

public class InstaBusinessAccountWriteCommand implements Command<Void, Document>{

    @Override
    public CompletableFuture<Void> execute(Document arg) {
        insert(arg);
        return null;
    }

    private void insert(Document arg) {
        if (arg != null){

        }
    }
}
