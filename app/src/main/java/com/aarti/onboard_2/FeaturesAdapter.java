package com.aarti.onboard_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class FeaturesAdapter extends PagerAdapter {



    Context context;
    LayoutInflater layoutInflater;

    public FeaturesAdapter(Context context)
    {
        this.context=context;
    }


    public int[] feature_images=
            {
                    R.drawable.ic_search__icon,
                    R.drawable.ic_location_icon,
                    R.drawable.ic_navigation_icon,
                    R.drawable.ic_advanced_booking,
                    R.drawable.ic_move

            };

    public String[] feature_headings={
            "Find your stop",
            "Locate on Maps",
            "Navigate",
            "Advance Book"
            ,"Move"
    };
    public String[] feature_desc={
            "Search for all the available public transport routes available for your destination on a single tap.",
            "Provides you with the location of the public transport stop",
            "Maps a route from your current location to the stop.",
            "Book your seat or ticket before you go on the app.",
            "Information on transit services available near the stop."


    };






    @Override
    public int getCount()
    {
        return
                feature_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==  object;
    }

    public Object instantiateItem(ViewGroup container, int position)
    {
        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view=layoutInflater.inflate(R.layout.features,container,false);

        ImageView slideImageView =  view.findViewById(R.id.feature_image);
        TextView slideHeading =  view.findViewById(R.id.feature_heading);
        TextView slideDescription =  view.findViewById(R.id.feature_description);

        slideImageView.setImageResource(feature_images[position]);
        slideHeading.setText(feature_headings[position]);
        slideDescription.setText(feature_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object)
    {
        container.removeView((View) object);
    }


}
