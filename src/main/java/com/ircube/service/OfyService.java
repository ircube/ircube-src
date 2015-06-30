package com.ircube.service;



import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.ObjectifyFactory;
import com.ircube.kind.Profile;

/**
 * Created by Ivo @ircube on 30/06/2015.
 */
public class OfyService {

    /**
     * this static block ensure the entity registration.
     */
    static {


        factory().register(Profile.class);



    }
    public static Objectify ofy(){
        return ObjectifyService.ofy();
    }
    public static ObjectifyFactory factory(){
        return ObjectifyService.factory();
    }
}
