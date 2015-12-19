package com.example.kaving.sorting;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;

/**
 * Created by KavinG on 11/2/2015.
 */
public class BubbleSortTask extends AsyncTask<int[],String,String>{
    static int[] array;
    Activity activity;
    TextView tv1;
    long start,end;

    public BubbleSortTask(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected String doInBackground(int[]... params) {
        String result="";
        if (params[0] != null) {
           // int[] clone = Arrays.copyOf(array, array.length);
            start = System.currentTimeMillis();
            int[] output =params[0];
            Algorithms.doBubbleSort(output);
            end = System.currentTimeMillis();
            result = ((end - start) + " ms");
        } else {
            //tv1.setText("Array is not initilized yet");
        }
        return result;
    }

       @Override
    protected void onPreExecute() {
        super.onPreExecute();
        tv1 = (TextView) activity.findViewById(R.id.tvBubbleSort);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        tv1.setText(s);
    }
}
