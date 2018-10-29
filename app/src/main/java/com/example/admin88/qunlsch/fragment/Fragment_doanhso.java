package com.example.admin88.qunlsch.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin88.qunlsch.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_doanhso extends Fragment {
    float hoadon[] = {23252f,15425,53463f};
    String time[] = {"ngay","tuan","Thang"};
    PieChart pieChart1;


    public Fragment_doanhso() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_doanhso, container, false);
        pieChart1 = v.findViewById(R.id.chart);
        setup();
        return v;
    }
    private void setup() {
        List<PieEntry> pieEntries = new ArrayList<>();
        for (int i=0;i<hoadon.length;i++){
            pieEntries.add(new PieEntry(hoadon[i],time[i]));
        }
        PieDataSet pieChart = new PieDataSet(pieEntries,"thong ke");
        pieChart.setValueTextSize(18);
        pieChart.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData data = new PieData(pieChart);

        pieChart1.setData(data);
        pieChart1.invalidate();
        pieChart1.animateY(1000);
        pieChart1.animateX(1000);
    }

}
