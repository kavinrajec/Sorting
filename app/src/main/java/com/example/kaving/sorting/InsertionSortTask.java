package com.example.kaving.sorting;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;

import java.util.Arrays;

/**
 * Created by KavinG on 11/18/2015.
 */
public class InsertionSortTask extends AsyncTask<int[],String,String> {
    Activity activity;
    TextView tv2;
    long start, end;

    public InsertionSortTask(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected String doInBackground(int[]... params) {
        if (params[0] != null) {
            //int[] clone = Arrays.copyOf(array, array.length);
            start = System.currentTimeMillis();
            int[] output = params[0];
            Algorithms.doInsertionSort(output);
            end = System.currentTimeMillis();
            //tv2.setText((end - start) + " ms");

        } else {
            //tv2.setText("Array is not initilized yet");
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        tv2 = (TextView) activity.findViewById(R.id.tvInsertionSort);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        tv2.setText((end - start) + " ms");
    }
}
