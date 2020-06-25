package com.daren.auth.model;

import com.daren.auth.Database;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import java.sql.SQLException;

import static com.daren.auth.tables.Users.USERS;

public class User {

    private final long id;
    private final String email;
    private final String hash;

    public User(Record data) {
        this.id = data.getValue(USERS.ID);
        this.email = data.getValue(USERS.EMAIL);
        this.hash = data.getValue(USERS.HASH);
    }

    public static int create(String email, String hash) throws SQLException {
        DSLContext context = Database.getConnection();
        return context.insertInto(USERS)
                .set(USERS.EMAIL, email)
                .set(USERS.HASH, hash)
                .execute();
    }

    public static User findByEmailAndHash(String email, String hash) throws SQLException {
        DSLContext context = Database.getConnection();
        Record result = context
                .select()
                .from(USERS)
                .where(USERS.EMAIL.eq(email))
                .and(USERS.HASH.eq(hash))
                .fetchAny();
        return new User(result);
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getHash() {
        return hash;
    }
}





