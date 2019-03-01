package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

import mali.helo.jokelib.JokeBank;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** Endpoints that returns a joke */
    @ApiMethod(name = "jokes")
    public MyBean jokes() {
        MyBean response = new MyBean();

        // Use {@link JokeBank} form the java library to get a joke
        JokeBank jokeBank = new JokeBank();

        response.setData(jokeBank.getJoke());

        return response;
    }

}
