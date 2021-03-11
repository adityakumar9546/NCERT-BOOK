package com.h.class10ncertsolutions.Activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.github.barteksc.pdfviewer.PDFView;
import com.h.class10ncertsolutions.*;

/* created by ashbatra in June 2019 */

public class PdfActivity extends AppCompatActivity {
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        

        pdfView = (PDFView) findViewById(R.id.v_pdf);
        

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private String namecreate(String bookname, String chpnum) {
        //the files are saved in the format b1ch12 for book1, chapter 12
        String filename = "b"+bookname+"ch"+chpnum+".pdf";
        return filename;
    }
}


