package mali.helo.joketeller;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class JokeTellerActivity extends AppCompatActivity {

    public static final String EXTRA_JOKE = "extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_teller);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get the joke from the intent
        String joke = getIntent().getStringExtra(EXTRA_JOKE);

        // Show the joke
        TextView jokeTextView = findViewById(R.id.joke_text_view);
        jokeTextView.setText(joke);
    }

}
