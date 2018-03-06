package es.jujoru.u4_botonatras;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
final static String EXTRA_CONT ="CONT";
    int cont=0;
    EditText etCont;
    TextView tvSUmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        etCont =(EditText)findViewById(R.id.etNombre);
        tvSUmar =(TextView)findViewById(R.id.tvSumar);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            cont =extras.getInt(EXTRA_CONT);
            etCont.setText(cont+"");
        }

        if (savedInstanceState != null) {
            // Restore value of members from saved state
            int aa = savedInstanceState.getInt(EXTRA_CONT);
             Toast.makeText(getApplicationContext(), "Has girado y vas por: "+aa, Toast.LENGTH_LONG).show();
        }

    }

    public void sumar(View view){
        cont++;
        etCont.setText(cont+"");
        tvSUmar.setText(cont+"");
    }

    public void irNuevaActivity(View view){
        Intent i=new Intent(getApplicationContext(),SegundaActivity.class);
        i.putExtra(EXTRA_CONT,cont);
        startActivity(i);
    }


    public void clickGoogle(View view){

        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

    }

    public void abrirCamara(View view){

        Intent i=new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.google.es"));
        startActivity(i);

    }

    @Override
        protected void onRestoreInstanceState(Bundle savedInstanceState) {
                super.onRestoreInstanceState(savedInstanceState);

        cont = savedInstanceState.getInt(EXTRA_CONT);


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putInt(EXTRA_CONT, cont);

    }
}
