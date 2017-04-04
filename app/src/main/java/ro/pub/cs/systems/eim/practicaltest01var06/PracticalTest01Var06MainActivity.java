package ro.pub.cs.systems.eim.practicaltest01var06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var06MainActivity extends AppCompatActivity {

    private EditText leftEditText = null;
    //private EditText rightEditText = null;
    private Button leftButton = null;
    private Button rightButton = null;
    private Button centerButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_main);
        leftEditText = (EditText)findViewById(R.id.editText);
        //rightEditText = (EditText)findViewById(R.id.right_edit_text);
        leftEditText.setText(String.valueOf("http://"));
        //rightEditText.setText(String.valueOf(0));

        leftButton = (Button)findViewById(R.id.button);
        rightButton = (Button)findViewById(R.id.button2);
        centerButton = (Button)findViewById(R.id.button3);

        leftButton.setOnClickListener(buttonClickListener);
        rightButton.setOnClickListener(buttonClickListener);


        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("http://cs.curs.pub.ro")) {
                leftEditText.setText(savedInstanceState.getString("http://cs.curs.pub.ro"));
            } else {
                leftEditText.setText(String.valueOf("http://"));
            }

        } else {
            leftEditText.setText(String.valueOf(0));
        }

    }

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.button:
                    //int leftNumberOfClicks = Integer.parseInt(leftEditText.getText().toString());
                    int i=0;
                    //leftNumberOfClicks++;
                    //leftEditText.setText(String.valueOf(leftNumberOfClicks));
                    leftEditText.setVisibility(View.INVISIBLE);
                    break;
                case R.id.button2:
                    //int rightNumberOfClicks = Integer.parseInt(rightEditText.getText().toString());
                    //rightNumberOfClicks++;
                    //rightEditText.setText(String.valueOf(rightNumberOfClicks));
                    break;
            }
        }
    }




    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("http://cs.curs.pub.ro", leftEditText.getText().toString());
        //savedInstanceState.putString("rightCount", rightEditText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("http://cs.curs.pub.ro")) {
            leftEditText.setText(savedInstanceState.getString("http://cs.curs.pub.ro"));
        } else {
            leftEditText.setText(String.valueOf(0));
        }

    }


}
