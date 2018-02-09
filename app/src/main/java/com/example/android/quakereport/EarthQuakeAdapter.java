package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import android.graphics.drawable.GradientDrawable;

/**
 * Created by v-nkumar on 1/25/2018.
 */

public class EarthQuakeAdapter extends ArrayAdapter<EarthQuake> {

    private static final String LOG_TAG = EarthQuakeAdapter.class.getSimpleName();

    public EarthQuakeAdapter(Activity context, ArrayList<EarthQuake> earthQuakes) {
        super(context, 0, earthQuakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        EarthQuake currEarthQuake = getItem(position);

        TextView magTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        Double magnitude = currEarthQuake.getMagnitude();

        DecimalFormat decimalFormat = new DecimalFormat("0.0");

        magTextView.setText(decimalFormat.format(magnitude));
        GradientDrawable magnitudeCircle = (GradientDrawable) magTextView.getBackground();
        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currEarthQuake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        //Seperating the place to primary and offset location
        String orgPlace = currEarthQuake.getPlace();
        int indexOfOf = orgPlace.indexOf ("of");
        String primaryLocation;
        String offsetLocation;

        if(indexOfOf < 0){
            offsetLocation = "Near the";
            primaryLocation = orgPlace;
        } else{
            offsetLocation = orgPlace.substring(0,indexOfOf + 2);
            primaryLocation = orgPlace.substring(indexOfOf+2,orgPlace.length());
        }

        TextView primaryPlaceEarthQuake = (TextView) listItemView.findViewById(R.id.primary_location);
        primaryPlaceEarthQuake.setText(primaryLocation);

        TextView offsetLocationTextView = (TextView) listItemView.findViewById(R.id.location_offset);
        offsetLocationTextView.setText(offsetLocation);

        //Create a new Date object
        Date dateObject = new Date(currEarthQuake.getTimeInMilliSeconds());
        //Format Date
        String dateToDisplay = formatDate(dateObject);

        //find the textview with the id date
        TextView dateOfEarthQuake = (TextView) listItemView.findViewById(R.id.date);

        dateOfEarthQuake.setText(dateToDisplay);

        //Format Date
        String formattedTime = formatTime(dateObject);

        //find the textview with the id date
        TextView timeOfTheEarthQuake = (TextView) listItemView.findViewById(R.id.time);

        timeOfTheEarthQuake.setText(formattedTime);

        return listItemView;
    }

    private String formatDate(Date dateObject){
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject){
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private int getMagnitudeColor(Double magnitude){
        int magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude1);

        int mag = magnitude.intValue();

        switch (mag){
            case 0: magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case 1: magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude1);
                    break;
            case 2: magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case 3: magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case 4: magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case 5: magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case 6: magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case 7: magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case 8: magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case 9: magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            default: magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
        }
        return magnitude1Color;
    }
}
