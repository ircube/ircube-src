package com.ircube.kind;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * Created by Ivo @ircube on 30/06/2015.
 */
@Entity
@Cache
public class Profile {
    @Id private String userId;
    private String name;
    private String email;

    private Profile(){}

    /**
     * This method construct a Profile.
     * @param userId The id of this profile.
     * @param name  The name of the profile owner.
     * @param email The mail of the profile owner.
     */
    public Profile(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public void update( String name ) {
        if (name != null) {
            this.name = name;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
