package epsi.emile.dadou.fruitmastermind;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static epsi.emile.dadou.fruitmastermind.R.drawable.banane;
import static epsi.emile.dadou.fruitmastermind.R.drawable.citron;
import static epsi.emile.dadou.fruitmastermind.R.drawable.fraise;
import static epsi.emile.dadou.fruitmastermind.R.drawable.framboise;
import static epsi.emile.dadou.fruitmastermind.R.drawable.kiwi;
import static epsi.emile.dadou.fruitmastermind.R.drawable.orange;
import static epsi.emile.dadou.fruitmastermind.R.drawable.prune;
import static epsi.emile.dadou.fruitmastermind.R.drawable.raisin;

public class MainActivity extends AppCompatActivity {

    Button btnChoice1;
    Button btnChoice2;
    Button btnChoice3;
    Button btnChoice4;

    private Button fruit1;
    private int randNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fruit1 = findViewById(R.id.btnChoice1);
        fruit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Toast.makeText(MainActivity.this, "Banane",Toast.LENGTH_SHORT).show();
            }
        });

        btnChoice1 = (Button) findViewById(R.id.btnChoice1);
        btnChoice2 = (Button) findViewById(R.id.btnChoice2);
        btnChoice3 =(Button) findViewById(R.id.btnChoice3);
        btnChoice4=(Button) findViewById(R.id.btnChoice4);

        btnChoice1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this, btnChoice1);
                popup.getMenuInflater().inflate(R.menu.menu_choice_fruit, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getTitle().toString()){
                            case "Banane":
                                btnChoice1.setBackgroundResource(banane);
                                btnChoice1.setText("");
                                break;
                            case "Citron":
                                btnChoice1.setBackgroundResource(citron);
                                btnChoice1.setText("");
                                break;
                            case "Fraise":
                                btnChoice1.setBackgroundResource(fraise);
                                btnChoice1.setText("");
                                break;
                            case "Framboise":
                                btnChoice1.setBackgroundResource(framboise);
                                btnChoice1.setText("");
                                break;
                            case "Kiwi":
                                btnChoice1.setBackgroundResource(kiwi);
                                btnChoice1.setText("");
                                break;
                            case "Orange":
                                btnChoice1.setBackgroundResource(orange);
                                btnChoice1.setText("");
                                break;
                            case "Prune":
                                btnChoice1.setBackgroundResource(prune);
                                btnChoice1.setText("");
                                break;
                            case "Raisin":
                                btnChoice1.setBackgroundResource(raisin);
                                btnChoice1.setText("");
                                break;
                            default:
                                break;
                        }
                        return true;
                    }
                });

                popup.show();
            }
        });

        btnChoice2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this, btnChoice2);
                popup.getMenuInflater().inflate(R.menu.menu_choice_fruit, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getTitle().toString()){
                            case "Banane":
                                btnChoice2.setBackgroundResource(banane);
                                btnChoice2.setText("");
                                break;
                            case "Citron":
                                btnChoice2.setBackgroundResource(citron);
                                btnChoice2.setText("");
                                break;
                            case "Fraise":
                                btnChoice2.setBackgroundResource(fraise);
                                btnChoice2.setText("");
                                break;
                            case "Framboise":
                                btnChoice2.setBackgroundResource(framboise);
                                btnChoice2.setText("");
                                break;
                            case "Kiwi":
                                btnChoice2.setBackgroundResource(kiwi);
                                btnChoice2.setText("");
                                break;
                            case "Orange":
                                btnChoice2.setBackgroundResource(orange);
                                btnChoice2.setText("");
                                break;
                            case "Prune":
                                btnChoice2.setBackgroundResource(prune);
                                btnChoice2.setText("");
                                break;
                            case "Raisin":
                                btnChoice2.setBackgroundResource(raisin);
                                btnChoice2.setText("");
                                break;
                            default:
                                break;
                        }
                        return true;
                    }
                });

                popup.show();
            }
        });

        btnChoice3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this, btnChoice3);
                popup.getMenuInflater().inflate(R.menu.menu_choice_fruit, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getTitle().toString()){
                            case "Banane":
                                btnChoice3.setBackgroundResource(banane);
                                btnChoice3.setText("");
                                break;
                            case "Citron":
                                btnChoice3.setBackgroundResource(citron);
                                btnChoice3.setText("");
                                break;
                            case "Fraise":
                                btnChoice3.setBackgroundResource(fraise);
                                btnChoice3.setText("");
                                break;
                            case "Framboise":
                                btnChoice3.setBackgroundResource(framboise);
                                btnChoice3.setText("");
                                break;
                            case "Kiwi":
                                btnChoice3.setBackgroundResource(kiwi);
                                btnChoice3.setText("");
                                break;
                            case "Orange":
                                btnChoice3.setBackgroundResource(orange);
                                btnChoice3.setText("");
                                break;
                            case "Prune":
                                btnChoice3.setBackgroundResource(prune);
                                btnChoice3.setText("");
                                break;
                            case "Raisin":
                                btnChoice3.setBackgroundResource(raisin);
                                btnChoice3.setText("");
                                break;
                            default:
                                break;
                        }
                        return true;
                    }
                });

                popup.show();
            }
        });

        btnChoice4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this, btnChoice4);
                popup.getMenuInflater().inflate(R.menu.menu_choice_fruit, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getTitle().toString()){
                            case "Banane":
                                btnChoice4.setBackgroundResource(banane);
                                btnChoice4.setText("");
                                break;
                            case "Citron":
                                btnChoice4.setBackgroundResource(citron);
                                btnChoice4.setText("");
                                break;
                            case "Fraise":
                                btnChoice4.setBackgroundResource(fraise);
                                btnChoice4.setText("");
                                break;
                            case "Framboise":
                                btnChoice4.setBackgroundResource(framboise);
                                btnChoice4.setText("");
                                break;
                            case "Kiwi":
                                btnChoice4.setBackgroundResource(kiwi);
                                btnChoice4.setText("");
                                break;
                            case "Orange":
                                btnChoice4.setBackgroundResource(orange);
                                btnChoice4.setText("");
                                break;
                            case "Prune":
                                btnChoice4.setBackgroundResource(prune);
                                btnChoice4.setText("");
                                break;
                            case "Raisin":
                                btnChoice4.setBackgroundResource(raisin);
                                btnChoice4.setText("");
                                break;
                            default:
                                break;
                        }
                        return true;
                    }
                });

                popup.show();
            }
        });
    }


    public List<Fruit> allFruitsListInit() {
        List<Fruit> fruits = new ArrayList<Fruit>();
        fruits.add(new Fruit(enumFruits.BANANE));
        fruits.add(new Fruit(enumFruits.CITRON));
        fruits.add(new Fruit(enumFruits.FRAISE));
        fruits.add(new Fruit(enumFruits.FRAMBOISE));
        fruits.add(new Fruit(enumFruits.KIWI));
        fruits.add(new Fruit(enumFruits.ORANGE));
        fruits.add(new Fruit(enumFruits.PRUNE));
        fruits.add(new Fruit(enumFruits.RAISIN));

        return fruits;
    }

    public List<Fruit> initGameList() {
        List<Fruit> fruitsToFind = new ArrayList<Fruit>();
        List<Integer> listNum = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            randNum = (int) (Math.random() * 9);
            if (listNum.contains(randNum)) {
                randNum = (int) (Math.random() * 9);
            }
            switch (randNum) {
                case 0 : fruitsToFind.add(new Fruit(enumFruits.ORANGE)); listNum.add(randNum); break;
                case 1 : fruitsToFind.add(new Fruit(enumFruits.BANANE)); listNum.add(randNum); break;
                case 2 : fruitsToFind.add(new Fruit(enumFruits.CITRON)); listNum.add(randNum); break;
                case 3 : fruitsToFind.add(new Fruit(enumFruits.RAISIN)); listNum.add(randNum); break;
                case 4 : fruitsToFind.add(new Fruit(enumFruits.FRAISE)); listNum.add(randNum); break;
                case 5 : fruitsToFind.add(new Fruit(enumFruits.FRAMBOISE)); listNum.add(randNum); break;
                case 6 : fruitsToFind.add(new Fruit(enumFruits.KIWI)); listNum.add(randNum); break;
                case 7 : fruitsToFind.add(new Fruit(enumFruits.PRUNE)); listNum.add(randNum); break;
            }
        }
        return fruitsToFind;
    }

    private void checkVictoryConditions(List<Fruit> listToGuess, List<Fruit> userGuessList) {
        if (listToGuess.equals(userGuessList)) {
            Toast.makeText(MainActivity.this, "Yay you're the master fruiter",Toast.LENGTH_SHORT).show();
        }
    }

    private void initGame() {

    }
}
