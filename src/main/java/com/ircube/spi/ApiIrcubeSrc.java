package com.ircube.spi;

import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.response.UnauthorizedException;
import com.googlecode.objectify.Key;
import com.ircube.kind.Profile;
import com.ircube.form.ProfileForm;

import static com.ircube.service.OfyService.ofy;


/**
  * Add your first API methods in this class, or you may create another class. In that case, please
  * update your web.xml accordingly.
 **/
@Api(name = "apiircubesrc",version = "v1",
   clientIds = { Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID },
   description = "API for this APP" )
public class ApiIrcubeSrc {

   @ApiMethod( name = "saveProfile",path = "profile/save", httpMethod = ApiMethod.HttpMethod.POST)
   public Profile saveProfile ( final User user,  ProfileForm profileForm ) throws UnauthorizedException {
       String name;
       String userId;
       String email;
       System.out.println("1!!!!!-> " + profileForm.getProfileName() );
       if (user == null) {
           throw new UnauthorizedException("Autorization required");
       }

       name = profileForm.getProfileName();
       userId = user.getId();
       email = user.getEmail();
       System.out.println("2!!!!!-> " + name );

       Profile profile = ofy().load().key(Key.create(Profile.class,userId)).now();

       if ( profile == null ){
           if (name == null) {
               name = "defaultUser";
           }

           profile = new Profile(userId, name, email);
       } else {
           profile.update(name);
       }

       ofy().save().entity(profile).now();

       return profile;
   }
    @ApiMethod( name = "login",path = "login", httpMethod = ApiMethod.HttpMethod.POST)



    public Profile login ( final User user,  ProfileForm profileForm ) throws UnauthorizedException {

        String userId = user.getId();
        String name = profileForm.getProfileName();
        Profile profile = ofy().load().key(Key.create(Profile.class,userId)).now();
        if ( profile == null ){
            profile = new Profile(userId, "default", user.getEmail());
        } else {
            if (name  != null) profile.update(name);
        }

        return profile;
    }

    /**
     *      Start page... ->  Logged User -
     *
     *
     * @param user
     * @param profileForm
     * @return
     */

    @ApiMethod (name = "register", path = "",httpMethod = "")
    public Profile register ( final User user, ProfileForm profileForm ){
        String userId = user.getId();
        String name = profileForm.getProfileName();
        Profile profile = ofy().load().key(Key.create(Profile.class,userId)).now();
        if ( profile == null ){
            profile = new Profile(userId, "default", user.getEmail());
        } else {
            if (name  != null) profile.update(name);
        }
        return profile;
    }
}






