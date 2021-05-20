package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Book4 extends AppCompatActivity {
    PDFView book4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book4);

        book4 = (PDFView)findViewById(R.id.pdfbook4);
        book4.fromAsset("M1_4.pdf").load();
    }
}