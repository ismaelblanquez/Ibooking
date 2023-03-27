package com.ismael.ibooking.lstHoteles.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.ismael.ibooking.R;

public class CommentActivity extends AppCompatActivity {
    private EditText commentEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        commentEditText = findViewById(R.id.comment_text);
        submitButton = findViewById(R.id.comment_send_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String commentText = commentEditText.getText().toString();

                // Lógica para enviar el comentario
            }
        });
    }
}
