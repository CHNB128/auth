package com.daren.auth.model;

import org.jooq.Record;
import org.jooq.Result;

import static com.daren.auth.tables.Tokens.TOKENS;

public class Token {

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getValue() {
        return value;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getIp() {
        return ip;
    }

    private final Long id;
    private final Long userId;
    private final String value;
    private final String userAgent;
    private final String ip;

    public Token(Record data) {
        this.id = data.getValue(TOKENS.ID);
        this.value = data.getValue(TOKENS.VALUE);
        this.userAgent = data.getValue(TOKENS.USER_AGENT);
        this.userId = data.getValue(TOKENS.USER_ID);
        this.ip = data.getValue(TOKENS.IP);
    }

}
