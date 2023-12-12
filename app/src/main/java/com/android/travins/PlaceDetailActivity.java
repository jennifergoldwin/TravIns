package com.android.travins;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.travins.databinding.ActivityPlaceDetailBinding;
import com.android.travins.ui.adapters.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class PlaceDetailActivity extends AppCompatActivity {

    private ActivityPlaceDetailBinding binding;
    private ArrayList<String> tabsText = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlaceDetailBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_place_detail);

        tabsText.add("Overview");
        tabsText.add("Review");

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),getLifecycle());
//        adapter.addFragment(new OverviewFragment(), "Overview");
//        adapter.addFragment(brandFragment, "Brand")

        binding.pager.setAdapter(adapter);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(binding.tabLayout,binding.pager,(tab, position) ->
                tab.setText(tabsText.get(position))
        );
        tabLayoutMediator.attach();
    }
}