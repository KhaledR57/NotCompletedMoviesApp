package com.example.moviesapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {
    private Context context;
    private List<PagerSlide> pagerSlides;

    public ViewPagerAdapter(Context context, List<PagerSlide> pagerSlides) {
        this.context = context;
        this.pagerSlides = pagerSlides;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.pager_slide,null);

        ImageView slideImage = view.findViewById(R.id.slide_image);
        TextView Title = view.findViewById(R.id.title);
        TextView Body = view.findViewById(R.id.body);

        slideImage.setImageResource(pagerSlides.get(position).getImage());
        Title.setText(pagerSlides.get(position).getTitle());
        Body.setText(pagerSlides.get(position).getBody());

        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return pagerSlides.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
