package com.ircube.form;

/**
 * Created by Ivo @ircube on 30/06/2015.
 */
public class ProfileForm {

    private String profileName;

    private ProfileForm() {

    }

    public ProfileForm(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }


    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }
}
