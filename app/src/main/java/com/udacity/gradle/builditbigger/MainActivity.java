package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import mali.helo.jokelib.JokeBank;
import mali.helo.joketeller.JokeTellerActivity;


public class MainActivity extends AppCompatActivity
        implements EndpointsAsyncTask.OnBackEndResponseListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onTellJoke(View view) {
        // Request joke from backend
        new EndpointsAsyncTask(this, this).execute();
    }

    @Override
    public void onBackEndResponse(String response) {
        // Pass joke to {@link JokeTellerActivity} at joketeller anroid lib
        Intent tellJoke = new Intent(this, JokeTellerActivity.class);
        tellJoke.putExtra(JokeTellerActivity.EXTRA_JOKE, response);
        startActivity(tellJoke);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
