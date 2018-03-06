package es.jujoru.u4_botonatras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SegundaActivity extends AppCompatActivity {
    int cont;
    EditText etCont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        etCont =(EditText)findViewById(R.id.etCont2);

        Bundle b= getIntent().getExtras();

        if(b!=null){
            cont = b.getInt(MainActivity.EXTRA_CONT);
            etCont.setText(""+cont);

        }
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(new Intent(getApplicationContext(), MainActivity.class));
        i.putExtra(MainActivity.EXTRA_CONT, cont);
        startActivity(i);
        finish();
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);
        cont = savedInstanceState.getInt(MainActivity.EXTRA_CONT);
        etCont.setText(cont+"");
    }

    public void clickCont(View view){
        cont++;
        etCont.setText(cont+"");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        cont = Integer.parseInt(etCont.getText().toString());
        outState.putInt("CONT", cont);

    }

}
