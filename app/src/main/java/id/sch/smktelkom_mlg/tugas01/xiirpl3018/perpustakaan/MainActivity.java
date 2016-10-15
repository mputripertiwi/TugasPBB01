package id.sch.smktelkom_mlg.tugas01.xiirpl3018.perpustakaan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    Button bok;
    CheckBox c1,c2,c3,c4;
    RadioGroup rg;
    Spinner sp;
    TextView tvHasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editText);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        rg = (RadioGroup) findViewById(R.id.rgStatus);
        c1 = (CheckBox) findViewById(R.id.checkBox);
        c2=(CheckBox) findViewById(R.id.checkBox5);
        c3 = (CheckBox) findViewById(R.id.checkBox3);
        c4=(CheckBox) findViewById(R.id.checkBox4);
        sp = (Spinner) findViewById(R.id.spinner);
        bok = (Button) findViewById(R.id.buttonOk);

        bok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
            }
        });
    }

    private void doProcess() {
        if(isValid()){
            String nama = etNama.getText().toString();
            String hasil = null;
           if (rg.getCheckedRadioButtonId()!=-1)
           {
               RadioButton rb = (RadioButton)
                       findViewById(rg.getCheckedRadioButtonId());
               hasil =rb.getText().toString();
           }
            String hsl =" Judul Buku yang di pilih : \n";
            int startlen = hsl.length();
            if(c1.isChecked()) hsl+=c1.getText()+"\n";
            if(c2.isChecked()) hsl+=c2.getText()+"\n";
            if(c3.isChecked()) hsl+=c3.getText()+"\n";
            if(c4.isChecked()) hsl+=c4.getText()+"\n";
            if(hasil.length()==startlen) hsl+="Tidak ada pada pilihan";
            tvHasil.setText(" Nama Siswa :"+ nama + "\n" + hasil + "\n" + hsl
            + "\n" + sp.getSelectedItem().toString());
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        if(nama.isEmpty())
        {
            etNama.setError("Nama Belum Diisi");
            valid = false;
        }

        return valid;
    }

}
