package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Book3 extends AppCompatActivity {
    PDFView book3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book3);

        book3 = (PDFView)findViewById(R.id.pdfbook3);
        book3.fromAsset("M1_3.pdf").load();
    }
}