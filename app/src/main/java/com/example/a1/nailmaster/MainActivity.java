package com.example.a1.nailmaster;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

    String selectedUrl;
    Spinner spinner;
    WebView mWebView;



    public String[] url = {"http://sp.ruteil.ru/upload/iblock/e93/e9311161f9ad9e5f1f6e36ff4d84d1ad.jpg",
            "https://therunet.com/wp-content/uploads/2017/05/oreo-1200x600.jpg",
            "http://www.toptalent.co/wp-content/uploads/2016/07/4000.jpg",
            "http://tehnot.com/wp-content/uploads/2016/06/13-1.jpg",
            "http://www.minterest.co/wp-content/uploads/1425/7654f599496b261.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSpinner();

        mWebView = (WebView) findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);


    }

    void setSpinner () {
        ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this,R.array.spinner_item, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                choiceUrl();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    String choiceUrl() {
        int a = spinner.getSelectedItemPosition();
        selectedUrl = url[a];
        mWebView.loadUrl(selectedUrl);
        return selectedUrl;
    }




}
