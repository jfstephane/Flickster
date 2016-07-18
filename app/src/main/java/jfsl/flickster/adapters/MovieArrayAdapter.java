package jfsl.flickster.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import jfsl.flickster.R;
import jfsl.flickster.models.Movie;

/**
 * Created by kayla2 on 7/13/2016.
 */
public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public static class ViewHolder{
        TextView title;
        TextView overview;

    }

    public MovieArrayAdapter(Context context, List<Movie> movies){
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // get the data item for position
        Movie movie = getItem(position);
        ViewHolder viewHolder;
        // check the existing view being reused
        if (convertView == null) {
            viewHolder= new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
            viewHolder.title = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.overview = (TextView) convertView.findViewById(R.id.tvOverview);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder= (ViewHolder)convertView.getTag();
        }

        // find the image view
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
        // clear out image from convertView
        ivImage.setImageResource(0);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        // populate data
        viewHolder.title.setText(movie.getOriginalTitle());
        viewHolder.overview.setText(movie.getOverview());





        int orientation = getContext().getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT){
        Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE){
            Picasso.with(getContext()).load(movie.getBackdropPath()).into(ivImage);
        }

        // return the view
        return convertView;
    }
}
