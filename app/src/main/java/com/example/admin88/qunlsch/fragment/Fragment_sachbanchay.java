package com.example.admin88.qunlsch.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin88.qunlsch.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_sachbanchay extends Fragment {
    BarChart barChart;
    View v;
    public Fragment_sachbanchay() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_sachbanchay, container, false);
        barChart = v.findViewById(R.id.barchar);
        barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(true);
        barChart.setMaxVisibleValueCount(30);
        barChart.setDrawGridBackground(true);

        List<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, 10f));
        barEntries.add(new BarEntry(2, 3f));
        barEntries.add(new BarEntry(3, 5f));
        barEntries.add(new BarEntry(4, 16f));
        barEntries.add(new BarEntry(5, 9f));

        BarDataSet barDataSet = new BarDataSet(barEntries, "data");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData barData = new BarData(barDataSet);
        barData.setBarWidth(0.9f);
        barChart.setData(barData);
        barChart.animateY(1000);
        barChart.animateX(1000);
        return  v;
    }

}
