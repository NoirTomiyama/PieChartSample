package com.example.tommy.piechartsample;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    PieChart mPie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPie = findViewById(R.id.pie);

        setupPieChartView();
    }

    private void setupPieChartView() {
        mPie.setUsePercentValues(true);

        Description desc = new Description();
        desc.setText("PieChartのサンプルだよ");
        mPie.setDescription(desc);

        Legend legend = mPie.getLegend();
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);

        // サンプルデータ
        ArrayList<Float> value = new ArrayList<>();
        value.add(10f);
        value.add(20f);
        value.add(30f);
        value.add(40f);

        ArrayList<String> label = new ArrayList<>();
        label.add("A");
        label.add("B");
        label.add("C");
        label.add("D");

        ArrayList<PieEntry> entries = new ArrayList<>();
        for(int i = 0; i<value.size(); i++){
            entries.add( new PieEntry(value.get(i), label.get(i)));
        }

        // ラベル
        PieDataSet dataSet = new PieDataSet(entries,"チャートのラベル");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setDrawValues(true);

        PieData pieData = new PieData(dataSet);
        pieData.setValueFormatter(new PercentFormatter());
        pieData.setValueTextSize(20f);
        pieData.setValueTextColor(Color.WHITE);

        mPie.setData(pieData);

    }
}
