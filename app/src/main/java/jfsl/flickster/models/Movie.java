package jfsl.flickster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by kayla2 on 7/13/2016.
 */
public class Movie  implements Serializable {

    String posterPath;
    String backdropPath;
    String originalTitle;
    String overview;
    String voteAverage;
    float vote_average;

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getBackdropPath() {
        return  String.format("https://image.tmdb.org/t/p/w342/%s",backdropPath);
    }

    public String getOverview() { return overview; }

    public String getOriginalTitle() { return originalTitle; }

    public String getVoteAverage(){return voteAverage;}

    public Float getVote_average() {return vote_average;}




    public Movie(JSONObject jsonObject) throws JSONException {
        this.posterPath = jsonObject.getString("poster_path");
        this.backdropPath = jsonObject.getString("backdrop_path");
        this.originalTitle = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
        this.voteAverage= jsonObject.getString("vote_average");
        this.vote_average = (float) jsonObject.getDouble("vote_average");

    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array){
        ArrayList<Movie> results = new ArrayList<>();

        for (int x = 0; x < array.length(); x++) {
            try {
                results.add(new Movie(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }


}
