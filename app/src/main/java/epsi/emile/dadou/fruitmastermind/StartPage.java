package epsi.emile.dadou.fruitmastermind;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//Landing Page / Activity
public class StartPage extends AppCompatActivity {

    private Button Play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        Play = findViewById(R.id.button1);
        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartPage.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
