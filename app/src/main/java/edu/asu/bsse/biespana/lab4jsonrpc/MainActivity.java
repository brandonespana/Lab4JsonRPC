package edu.asu.bsse.biespana.lab4jsonrpc;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private EditText argument1;
    private EditText argument2;
    private RadioGroup operationsOptions;
    private TextView answerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        argument1 = (EditText) findViewById(R.id.argument1);
        argument2 = (EditText) findViewById(R.id.argument2);
        operationsOptions = (RadioGroup) findViewById(R.id.operationsOptions);
        answerView = (TextView) findViewById(R.id.answer);
    }


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

    public void operationSelected(View view){


    }

    public void performOperation(View view){

        //Read the arguments:
        //Double arg1 = Double.parseDouble(argument1.getText().toString());
       // Double arg2 = Double.parseDouble(argument2.getText().toString());

        String arg1 = argument1.getText().toString();
        String arg2 = argument2.getText().toString();

        Log.d("ARGUMENT 1", arg1);
        Log.d("ARGUMENT 2", arg2);

        //Read the selected operation:
        RadioButton selectedButton = (RadioButton) findViewById(operationsOptions.getCheckedRadioButtonId());
        String selection =  selectedButton.getText().toString();
        Log.d("SELECTION", selection);

        //Stat AsyncTask class to perform operation in background
        new BackgroundCaculatorTask().execute(arg1,arg2,selection);
    }
}


class BackgroundCaculatorTask extends AsyncTask<String, Void, Double>{

    private CalculatorProxy proxy;

    protected void onPreExecute(){
        proxy = new CalculatorProxy();
    }


    protected Double doInBackground(String...arguments){
        Double answer = 0.0;
        Double argument1 = Double.parseDouble(arguments[0]);
        Double argument2 = Double.parseDouble(arguments[1]);
        String operationToDo = arguments[2];

        if ("multiply".equals(operationToDo)){
            answer = proxy.multiply(argument1,argument2);
        }
        else if("divide".equals(operationToDo)){
            answer = proxy.dividie(argument1,argument2);
        }
        else if("add".equals(operationToDo)){
            answer = proxy.add(argument1,argument2);
        }
        else if ("subtract".equals(operationToDo)){
            answer = proxy.subtract(argument1,argument2);
        }

        return  answer;

    }

    protected void onPostExecute(Double answer){
       //TODO:Display on the UI:
        Log.d("RESULT",answer.toString());

    }

}