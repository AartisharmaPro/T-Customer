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

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){

        this.context=context;
    }

    //Arrays
    public int[] slide_images={
            R.drawable.ic_onbo,
            R.drawable.ic_onboarding_2,
            R.drawable.ic_onboarding_3

    };

    public String[] slide_headings={
            "Book your transportation before you go",
            "Choose the best mean of transportation",
            "Keep tracking your road while you are on board"
    };
    public String[] slide_desc={

                "Trango is a network of technology-enabled urban mobility transport, offering a seamless mobility experience at the convenience of a tap.",
  "Our vast network of urban mobility provides a safe & secure journey from one place to another.",
            "India’s best urban mobility venture for all types of customers that aims at providing its outstanding assistance & mobility services to all the daily commuters."

};

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject( View view, Object o) {
        return view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slidelayout,container,false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slideimage);
        TextView slideHeading = (TextView) view.findViewById(R.id.slideheading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slidedesc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((RelativeLayout)object);
    }
}
