package de.christianhartmann.play;

import java.util.Optional;

public class PlayResult {

    private final PlayResultType playResultType;
    private final String message;

    PlayResult(final PlayResultType playResultType, final String message) {
        this.message = message;
        this.playResultType = playResultType;
    }

    public Optional<String> getMessage() {
        return Optional.ofNullable(message);
    }

    public PlayResultType getPlayResultType() {
        return playResultType;
    }
}
