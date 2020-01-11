package epsi.emile.dadou.fruitmastermind;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.TypeConverter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static epsi.emile.dadou.fruitmastermind.R.drawable.banane;
import static epsi.emile.dadou.fruitmastermind.R.drawable.citron;
import static epsi.emile.dadou.fruitmastermind.R.drawable.fraise;
import static epsi.emile.dadou.fruitmastermind.R.drawable.framboise;
import static epsi.emile.dadou.fruitmastermind.R.drawable.kiwi;
import static epsi.emile.dadou.fruitmastermind.R.drawable.orange;
import static epsi.emile.dadou.fruitmastermind.R.drawable.prune;
import static epsi.emile.dadou.fruitmastermind.R.drawable.raisin;
import static epsi.emile.dadou.fruitmastermind.R.id.indiceEpTxt;
import static epsi.emile.dadou.fruitmastermind.R.id.indicePepinTxt;

public class MainActivity extends AppCompatActivity {

    private Button btnChoice1;
    private Button btnChoice2;
    private Button btnChoice3;
    private Button btnChoice4;
    private Button validateButton;

    private int tryNb = 10;

    private LinearLayout indices;
    private TextView indicePep;
    private TextView indiceEp;
    private LinearLayout indicePepin;
    private LinearLayout indicesEpluchure;
    private TextView indPep1;
    private TextView indPep2;
    private TextView indPep3;
    private TextView indPep4;
    private TextView indEp1;
    private TextView indEp2;
    private TextView indEp3;
    private TextView indEp4;

    private ListView list;
    private ArrayAdapter<String> historicAdapter;
    private List<String> historic;

    private Button fruit1;
    private int randNum;
    private List<Fruit> userGuessList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        list = (ListView) findViewById(R.id.list);


        btnChoice1 = (Button) findViewById(R.id.btnChoice1);
        btnChoice2 = (Button) findViewById(R.id.btnChoice2);
        btnChoice3 =(Button) findViewById(R.id.btnChoice3);
        btnChoice4=(Button) findViewById(R.id.btnChoice4);
        validateButton = (Button) findViewById(R.id.validateButton);

        btnChoice1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Création d'un nouveau menu popup lors d'un click sur le bouton
                PopupMenu popup = new PopupMenu(MainActivity.this, btnChoice1);
                popup.getMenuInflater().inflate(R.menu.menu_choice_fruit, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getTitle().toString()){
                            case "Banane":
                                // changement de background du bouton
                                btnChoice1.setBackgroundResource(banane);
                                btnChoice1.setText("");
                                // add le fruit à la liste de l'utilisateur
                                userGuessList.add(0, new Fruit(enumFruits.BANANE));
                                break;
                            case "Citron":
                                btnChoice1.setBackgroundResource(citron);
                                btnChoice1.setText("");
                                userGuessList.add(0, new Fruit(enumFruits.CITRON));
                                break;
                            case "Fraise":
                                btnChoice1.setBackgroundResource(fraise);
                                btnChoice1.setText("");
                                userGuessList.add(0, new Fruit(enumFruits.FRAISE));
                                break;
                            case "Framboise":
                                btnChoice1.setBackgroundResource(framboise);
                                btnChoice1.setText("");
                                userGuessList.add(0, new Fruit(enumFruits.FRAMBOISE));
                                break;
                            case "Kiwi":
                                btnChoice1.setBackgroundResource(kiwi);
                                btnChoice1.setText("");
                                userGuessList.add(0, new Fruit(enumFruits.KIWI));
                                break;
                            case "Orange":
                                btnChoice1.setBackgroundResource(orange);
                                btnChoice1.setText("");
                                userGuessList.add(0, new Fruit(enumFruits.ORANGE));
                                break;
                            case "Prune":
                                btnChoice1.setBackgroundResource(prune);
                                btnChoice1.setText("");
                                userGuessList.add(0, new Fruit(enumFruits.PRUNE));
                                break;
                            case "Raisin":
                                btnChoice1.setBackgroundResource(raisin);
                                btnChoice1.setText("");
                                userGuessList.add(0, new Fruit(enumFruits.RAISIN));
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
                                userGuessList.add(1, new Fruit(enumFruits.BANANE));
                                break;
                            case "Citron":
                                btnChoice2.setBackgroundResource(citron);
                                btnChoice2.setText("");
                                userGuessList.add(1, new Fruit(enumFruits.CITRON));
                                break;
                            case "Fraise":
                                btnChoice2.setBackgroundResource(fraise);
                                btnChoice2.setText("");
                                userGuessList.add(1, new Fruit(enumFruits.FRAISE));
                                break;
                            case "Framboise":
                                btnChoice2.setBackgroundResource(framboise);
                                btnChoice2.setText("");
                                userGuessList.add(1, new Fruit(enumFruits.FRAMBOISE));
                                break;
                            case "Kiwi":
                                btnChoice2.setBackgroundResource(kiwi);
                                btnChoice2.setText("");
                                userGuessList.add(1, new Fruit(enumFruits.KIWI));
                                break;
                            case "Orange":
                                btnChoice2.setBackgroundResource(orange);
                                btnChoice2.setText("");
                                userGuessList.add(1, new Fruit(enumFruits.ORANGE));
                                break;
                            case "Prune":
                                btnChoice2.setBackgroundResource(prune);
                                btnChoice2.setText("");
                                userGuessList.add(1, new Fruit(enumFruits.PRUNE));
                                break;
                            case "Raisin":
                                btnChoice2.setBackgroundResource(raisin);
                                btnChoice2.setText("");
                                userGuessList.add(1, new Fruit(enumFruits.RAISIN));
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
                                userGuessList.add(2, new Fruit(enumFruits.BANANE));
                                break;
                            case "Citron":
                                btnChoice3.setBackgroundResource(citron);
                                btnChoice3.setText("");
                                userGuessList.add(2, new Fruit(enumFruits.CITRON));
                                break;
                            case "Fraise":
                                btnChoice3.setBackgroundResource(fraise);
                                btnChoice3.setText("");
                                userGuessList.add(2, new Fruit(enumFruits.FRAISE));
                                break;
                            case "Framboise":
                                btnChoice3.setBackgroundResource(framboise);
                                btnChoice3.setText("");
                                userGuessList.add(2, new Fruit(enumFruits.FRAMBOISE));
                                break;
                            case "Kiwi":
                                btnChoice3.setBackgroundResource(kiwi);
                                btnChoice3.setText("");
                                userGuessList.add(2, new Fruit(enumFruits.KIWI));
                                break;
                            case "Orange":
                                btnChoice3.setBackgroundResource(orange);
                                btnChoice3.setText("");
                                userGuessList.add(2, new Fruit(enumFruits.ORANGE));
                                break;
                            case "Prune":
                                btnChoice3.setBackgroundResource(prune);
                                btnChoice3.setText("");
                                userGuessList.add(2, new Fruit(enumFruits.PRUNE));
                                break;
                            case "Raisin":
                                btnChoice3.setBackgroundResource(raisin);
                                btnChoice3.setText("");
                                userGuessList.add(2, new Fruit(enumFruits.RAISIN));
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
                                userGuessList.add(3, new Fruit(enumFruits.BANANE));
                                break;
                            case "Citron":
                                btnChoice4.setBackgroundResource(citron);
                                btnChoice4.setText("");
                                userGuessList.add(3, new Fruit(enumFruits.CITRON));
                                break;
                            case "Fraise":
                                btnChoice4.setBackgroundResource(fraise);
                                btnChoice4.setText("");
                                userGuessList.add(3, new Fruit(enumFruits.FRAISE));
                                break;
                            case "Framboise":
                                btnChoice4.setBackgroundResource(framboise);
                                btnChoice4.setText("");
                                userGuessList.add(3, new Fruit(enumFruits.FRAMBOISE));
                                break;
                            case "Kiwi":
                                btnChoice4.setBackgroundResource(kiwi);
                                btnChoice4.setText("");
                                userGuessList.add(3, new Fruit(enumFruits.KIWI));
                                break;
                            case "Orange":
                                btnChoice4.setBackgroundResource(orange);
                                btnChoice4.setText("");
                                userGuessList.add(3, new Fruit(enumFruits.ORANGE));
                                break;
                            case "Prune":
                                btnChoice4.setBackgroundResource(prune);
                                btnChoice4.setText("");
                                userGuessList.add(3, new Fruit(enumFruits.PRUNE));
                                break;
                            case "Raisin":
                                btnChoice4.setBackgroundResource(raisin);
                                btnChoice4.setText("");
                                userGuessList.add(3, new Fruit(enumFruits.RAISIN));
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

        // Add listener of the validate button
        // useless
        // Fonction de vérification de doublons
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTry(tryNb - 1);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_indice, menu);
        return true;
    }

    // afficher indice :
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        indices = findViewById(R.id.indices);
        indices.setVisibility(View.VISIBLE);
        switch (item.getItemId()){
            case R.id.indice1:
                afficherIndice1();
                useIndice();
                Toast.makeText(this,item.getTitle(), Toast.LENGTH_LONG).show();
                break;
            case R.id.indice2:
                afficherIndice2();
                useIndice();
                Toast.makeText(this,item.getTitle(), Toast.LENGTH_LONG).show();
                break;

            default:
                return super.onOptionsItemSelected(item);

        }
        return true;
    }

    public void afficherIndice1(){

        indicePep = findViewById(indicePepinTxt);
        indicePepin = findViewById(R.id.indicePepin);
        indPep1 = findViewById(R.id.indicePepin1);
        indPep2 = findViewById(R.id.indicePepin2);
        indPep3 = findViewById(R.id.indicePepin3);
        indPep4 = findViewById(R.id.indicePepin4);

        indicePep.setVisibility(View.VISIBLE);
        indicePepin.setVisibility(View.VISIBLE);
        indPep1.setVisibility(View.VISIBLE);
        indPep2.setVisibility(View.VISIBLE);
        indPep3.setVisibility(View.VISIBLE);
        indPep4.setVisibility(View.VISIBLE);

    }

    public void afficherIndice2(){

        indiceEp = findViewById(indiceEpTxt);
        indicesEpluchure = findViewById(R.id.indiceEp);
        indEp1 = findViewById(R.id.indiceEp1);
        indEp2 = findViewById(R.id.indiceEp2);
        indEp3 = findViewById(R.id.indiceEp3);
        indEp4 = findViewById(R.id.indiceEp4);

        indiceEp.setVisibility(View.VISIBLE);
        indicesEpluchure.setVisibility(View.VISIBLE);
        indEp1.setVisibility(View.VISIBLE);
        indEp2.setVisibility(View.VISIBLE);
        indEp3.setVisibility(View.VISIBLE);
        indEp4.setVisibility(View.VISIBLE);

    }

    // décrémentation d'essai si utilisation d'indice :
    public void useIndice(){
        setTry(tryNb - 2);
    }

    void setTry(int tryVal){
        tryNb = tryVal;
        TextView scoreView = findViewById(R.id.triesNb);
        scoreView.setText(String.valueOf(tryNb));
    }

// Génération d'une liste contenenant tout les fruits
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

    // génération de la liste à trouver
    public List<Fruit> initGameList() {
        List<Fruit> fruitsToFind = new ArrayList<Fruit>();
        List<Integer> listNum = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            randNum = (int) (Math.random() * 9);
            // Vérifie si le nombre généré est contenu dans la liste (donc si le fruit est déjà présent)
            // et génère un nouveau numéro
            while (listNum.contains(randNum)) {
                randNum = (int) (Math.random() * 9);
            }
            // en fonction du nombre ajoute le fruit correspondant à la liste à trouver
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

    private void popupEndGame(){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.activity_end_game, null);
        TextView mVictoireDefaite = (TextView) mView.findViewById(R.id.VictoireDefaite);
        Button mNewGame = (Button) mView.findViewById(R.id.NewGame);
        Button mRestart = (Button) mView.findViewById(R.id.Restart);
        Button mQuitt = (Button) mView.findViewById(R.id.Quitt);

        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();

        mNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mQuitt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStartPage();
            }
        });


    }

    public void openStartPage(){
        Intent intent = new Intent(this, StartPage.class);
        startActivity(intent);
    }

    // Vérification de victoire si les deux listes sont égales
    // useless
    private void checkVictoryConditions(List<Fruit> listToGuess, List<Fruit> userGuessList) {
        if (listToGuess.equals(userGuessList)) {
            Toast.makeText(MainActivity.this, "Yay you're the master fruiter",Toast.LENGTH_SHORT).show();


        }
    }

    //
    private void initGame() {
        /*historic = new ArrayList<>();
        historicAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, historic);
        list = findViewById(R.id.list);
        list.setAdapter(historicAdapter);*/
    }




}