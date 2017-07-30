package jfsl.flickster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import jfsl.flickster.models.Movie;

public class details extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //Animation
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        // Find the toolbar view and set as ActionBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarDtls);
        setSupportActionBar(toolbar);


        ImageView ImageDtls = (ImageView) findViewById(R.id.imageDtls);
        RatingBar RatingDtls = (RatingBar) findViewById(R.id.ratingDtls);
        TextView TitleDtls = (TextView) findViewById(R.id.titleDtls);
        TextView OverviewDtls = (TextView) findViewById(R.id. overviewDtls);
        TextView Tvtbdtls = (TextView) findViewById(R.id.tvtbdtls);
        RatingDtls.setEnabled(false);
        Movie Movie = (Movie) getIntent().getSerializableExtra("movie");
        Movie.getBackdropPath();
        Movie.getOriginalTitle();
        Movie.getOverview();

        Picasso.with(getApplicationContext()).load(Movie.getBackdropPath()).into(ImageDtls);
        // return the view

        RatingDtls.setRating(Movie.getVote_average());
        TitleDtls.setText(Movie.getOriginalTitle().toString());
        Tvtbdtls.setText(Movie.getOriginalTitle().toString());
        OverviewDtls.setText(Movie.getOverview().toString());


    }

    public void back(View view) {
        finishMyActivity();
    }

    @Override
    public void onBackPressed() {
        finishMyActivity();
    }

    public void finishMyActivity() {
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }


}
