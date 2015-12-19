package com.example.kaving.sorting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity{
    private static RadioGroup radioGroup;
    private static RadioButton radioButton;
    private static Button btnGenerateArray;
    TextView tv, tv1, tv2, tv3;
    EditText et;
    private int size = 0;
    static int[] array;
    BubbleSortTask bubbleSortTask;
    SelectionSortTask selectionSortTask;
    InsertionSortTask insertionSortTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.etArraySize);
        tv = (TextView) findViewById(R.id.tvGeneratedArray);
        tv1 = (TextView) findViewById(R.id.tvBubbleSort);
        tv2 = (TextView) findViewById(R.id.tvInsertionSort);
        tv3 = (TextView) findViewById(R.id.tvSelectionSort);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        //radioButton = (RadioButton) findViewById(R.id.)
    }

    public void generateArray(View v){

       // int selected_id = radioGroup.getCheckedRadioButtonId();
        try {
            size = Integer.parseInt(et.getText().toString());

            switch (radioGroup.getCheckedRadioButtonId()) {
                case R.id.rbtnBestCase:
                    array = Algorithms.getNaturalNumbers(size);
                    tv.setText("Array Created for Best Case of size " + array.length);
                    break;
                case R.id.rbtnAverageCase:
                    array = Algorithms.getRandom(size);
                    tv.setText("Array Created for Average Case of size " + array.length);
                    break;
                case R.id.rbtnWorstCase:
                    array = Algorithms.getReverse(size);
                    tv.setText("Array Created for Worst Case of size " + array.length);
                    break;
            }
        }catch(Exception ex){
            //tv.setText("Please enter the Array size");
            Toast.makeText(MainActivity.this, "Yo Yo Honey Pls enter the array size...!!!", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickSort(View v) {
            switch (v.getId()) {
                case R.id.btnBubbleSort:
                    bubbleSortTask = new BubbleSortTask(this);
                    bubbleSortTask.execute(array);
                    break;

                case R.id.btnInsertionSort:
                    insertionSortTask = new InsertionSortTask(this);
                    insertionSortTask.execute(array);
                    break;

                case R.id.btnSelectionSort:
                    selectionSortTask = new SelectionSortTask(this);
                    selectionSortTask.execute(array);
                    break;

                case R.id.btnBenchmarkAll:
                   /* bubbleSort();
                    insertionSort();
                    selectionSort();*/
                    bubbleSortTask = new BubbleSortTask(this);
                    bubbleSortTask.execute(array);

                    insertionSortTask = new InsertionSortTask(this);
                    insertionSortTask.execute(array);

                    selectionSortTask = new SelectionSortTask(this);
                    selectionSortTask.execute(array);
                    break;

            }
    }


   /* public void bubbleSort() {

        if (array != null) {
            int[] clone = Arrays.copyOf(array, array.length);

            long start = System.currentTimeMillis();
            int[] output = Algorithms.doBubbleSort(clone);
            long end = System.currentTimeMillis();
            tv1.setText((end - start) + " ms");

        } else {
            tv1.setText("Array is not initilized yet");
        }
    }

    public void insertionSort() {

        if (array != null) {
            int[] clone = Arrays.copyOf(array, array.length);

            long start = System.currentTimeMillis();
            int[] output = Algorithms.doInsertionSort(clone);
            long end = System.currentTimeMillis();
            tv2.setText((end - start) + " ms");

        } else {
            tv2.setText("Array is not initilized yet");
        }
    }

    public void selectionSort() {

        if (array != null) {
            int[] clone = Arrays.copyOf(array, array.length);

            long start = System.currentTimeMillis();
            int[] output = Algorithms.doSelectionSort(clone);
            long end = System.currentTimeMillis();
            tv3.setText((end - start) + " ms");

        } else {
            tv3.setText("Array is not initilized yet");
        }
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
