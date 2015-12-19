package com.example.kaving.sorting;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;

import java.util.Arrays;


/**
 * Created by KavinG on 11/18/2015.
 */
public class SelectionSortTask extends AsyncTask<int[],String,String> {
    Activity activity;
    TextView tv3;
    long start,end;
   public SelectionSortTask(Activity activity){
        this.activity = activity;
    }

    @Override
    protected String doInBackground(int[]... params) {
        if (params[0] != null) {
           // int[] clone = Arrays.copyOf(array, array.length);
            start = System.currentTimeMillis();
            int[] output = params[0];
            Algorithms.doSelectionSort(output);
             end = System.currentTimeMillis();
            //tv3.setText((end - start) + " ms");

        } else {
           // tv3.setText("Array is not initilized yet");
        }
        return null;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        tv3 = (TextView) activity.findViewById(R.id.tvSelectionSort);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        tv3.setText((end - start) + " ms");
    }
}
