/*
*
* Bonjour Monsieur notre groupe est composé de Emile DADOU, Guillaume GOUHIER et Yoan FILIPE
*
* */

package epsi.emile.dadou.fruitmastermind;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.TypeConverter;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
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

import java.lang.reflect.Array;
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

public class MainActivity extends AppCompatActivity {

    List<ListHistoric> m_historic = new ArrayList<ListHistoric>() ;

    int NbVictories = 0;
    int Score = 0;
    int MAX_FRUITS = 4;
    int COUPS_RESTANTS = 10;
    TextView NbTries;
    TextView Total_Score;
    int tag_hints = 0;

   // Listes des boutons pour choisir les fruits
    public Button btnChoice1;
    private Button btnChoice2;
    private Button btnChoice3;
    private Button btnChoice4;
    private Button validateButton;

    // élément pour la liste :
    ImageView image_1;
    ImageView image_2;
    ImageView image_3;
    ImageView image_4;

    Integer[] tabIntFruits = new Integer[4];
    List<Character> charToInsert = new ArrayList<Character>() ;

    private RecyclerView list;
    private ArrayAdapter<String> historicAdapter;

    LinearLayoutManager lm = new LinearLayoutManager(MainActivity.this);
    ListHistoricAdaptater adapter = new ListHistoricAdaptater(lm);


    private int randNum;
    private List<Fruit> userGuessList = new ArrayList<Fruit>();
    private List<Fruit> listToFind = new ArrayList<>();



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





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.recyclerview);
        NbTries = findViewById(R.id.triesNb);
        listToFind = initGameList();
        //Toast.makeText(MainActivity.this, listToFind.get(0).getName() + listToFind.get(1).getName() + listToFind.get(2).getName() + listToFind.get(3).getName(), Toast.LENGTH_LONG).show();
        //Buttons for User Choice

        indPep1 = findViewById(R.id.indicePepin1);
        indPep2 = findViewById(R.id.indicePepin2);
        indPep3 = findViewById(R.id.indicePepin3);
        indPep4 = findViewById(R.id.indicePepin4);

        //Log.d("booleans: ", Boolean.toString(false));
        indPep1.setText(Boolean.toString(listToFind.get(0).getHasSeeds()));
        indPep2.setText(Boolean.toString(listToFind.get(1).getHasSeeds()));
        indPep3.setText(Boolean.toString(listToFind.get(2).getHasSeeds()));
        indPep4.setText(Boolean.toString(listToFind.get(3).getHasSeeds()));

        indEp1 = findViewById(R.id.indiceEp1);
        indEp2 = findViewById(R.id.indiceEp2);
        indEp3 = findViewById(R.id.indiceEp3);
        indEp4 = findViewById(R.id.indiceEp4);

        indEp1.setText(Boolean.toString(listToFind.get(0).getPeelable()));
        indEp2.setText(Boolean.toString(listToFind.get(1).getPeelable()));
        indEp3.setText(Boolean.toString(listToFind.get(2).getPeelable()));
        indEp4.setText(Boolean.toString(listToFind.get(3).getPeelable()));

        btnChoice1 = (Button) findViewById(R.id.btnChoice1);
        btnChoice2 = (Button) findViewById(R.id.btnChoice2);
        btnChoice3 =(Button) findViewById(R.id.btnChoice3);
        btnChoice4=(Button) findViewById(R.id.btnChoice4);
        validateButton = (Button) findViewById(R.id.validateButton);
        Total_Score = findViewById(R.id.score);


        //Update User Choices
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
                                image_1 = findViewById(R.id.banane);
                                tabIntFruits[0] = banane;
                                btnChoice1.setText("");
                                // add le fruit à la liste de l'utilisateur
                                userGuessList.add(0, new Fruit(enumFruits.BANANE));
                                break;
                            case "Citron":
                                btnChoice1.setBackgroundResource(citron);
                                image_1 = findViewById(R.id.citron);
                                tabIntFruits[0] = citron;
                                btnChoice1.setText("");
                                userGuessList.add(0, new Fruit(enumFruits.CITRON));
                                break;
                            case "Fraise":
                                btnChoice1.setBackgroundResource(fraise);
                                image_1 = findViewById(R.id.fraise);
                                tabIntFruits[0] = fraise;
                                btnChoice1.setText("");
                                userGuessList.add(0, new Fruit(enumFruits.FRAISE));
                                break;
                            case "Framboise":
                                btnChoice1.setBackgroundResource(framboise);
                                image_1 = findViewById(R.id.framboise);
                                tabIntFruits[0] = framboise;
                                btnChoice1.setText("");
                                userGuessList.add(0, new Fruit(enumFruits.FRAMBOISE));
                                break;
                            case "Kiwi":
                                btnChoice1.setBackgroundResource(kiwi);
                                image_1 = findViewById(R.id.kiwi);
                                tabIntFruits[0] = kiwi;
                                btnChoice1.setText("");
                                userGuessList.add(0, new Fruit(enumFruits.KIWI));
                                break;
                            case "Orange":
                                btnChoice1.setBackgroundResource(orange);
                                image_1 = findViewById(R.id.orange);
                                tabIntFruits[0] = orange;
                                btnChoice1.setText("");
                                userGuessList.add(0, new Fruit(enumFruits.ORANGE));
                                break;
                            case "Prune":
                                btnChoice1.setBackgroundResource(prune);
                                image_1 = findViewById(R.id.prune);
                                tabIntFruits[0] = prune;
                                btnChoice1.setText("");
                                userGuessList.add(0, new Fruit(enumFruits.PRUNE));
                                break;
                            case "Raisin":
                                btnChoice1.setBackgroundResource(raisin);
                                image_1 = findViewById(R.id.raisin);
                                tabIntFruits[0] = raisin;
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
        //Same function as button1
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
                                image_2 = findViewById(R.id.banane);
                                tabIntFruits[1] = banane;
                                btnChoice2.setText("");
                                userGuessList.add(1, new Fruit(enumFruits.BANANE));
                                break;
                            case "Citron":
                                btnChoice2.setBackgroundResource(citron);
                                image_2 = findViewById(R.id.citron);
                                tabIntFruits[1] = citron;
                                btnChoice2.setText("");
                                userGuessList.add(1, new Fruit(enumFruits.CITRON));
                                break;
                            case "Fraise":
                                btnChoice2.setBackgroundResource(fraise);
                                image_2 = findViewById(R.id.fraise);
                                tabIntFruits[1] = fraise;
                                btnChoice2.setText("");
                                userGuessList.add(1, new Fruit(enumFruits.FRAISE));
                                break;
                            case "Framboise":
                                btnChoice2.setBackgroundResource(framboise);
                                image_2 = findViewById(R.id.framboise);
                                tabIntFruits[1] = framboise;
                                btnChoice2.setText("");
                                userGuessList.add(1, new Fruit(enumFruits.FRAMBOISE));
                                break;
                            case "Kiwi":
                                btnChoice2.setBackgroundResource(kiwi);
                                image_2 = findViewById(R.id.kiwi);
                                tabIntFruits[1] = kiwi;
                                btnChoice2.setText("");
                                userGuessList.add(1, new Fruit(enumFruits.KIWI));
                                break;
                            case "Orange":
                                btnChoice2.setBackgroundResource(orange);
                                image_2 = findViewById(R.id.orange);
                                tabIntFruits[1] = orange;
                                btnChoice2.setText("");
                                userGuessList.add(1, new Fruit(enumFruits.ORANGE));
                                break;
                            case "Prune":
                                btnChoice2.setBackgroundResource(prune);
                                image_2 = findViewById(R.id.prune);
                                tabIntFruits[1] = prune;
                                btnChoice2.setText("");
                                userGuessList.add(1, new Fruit(enumFruits.PRUNE));
                                break;
                            case "Raisin":
                                btnChoice2.setBackgroundResource(raisin);
                                image_2 = findViewById(R.id.raisin);
                                tabIntFruits[1] = raisin;
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
        //Same as button 1
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
                                image_3 = findViewById(R.id.banane);
                                tabIntFruits[2] = banane;
                                btnChoice3.setText("");
                                userGuessList.add(2, new Fruit(enumFruits.BANANE));
                                break;
                            case "Citron":
                                btnChoice3.setBackgroundResource(citron);
                                image_3 = findViewById(R.id.citron);
                                tabIntFruits[2] = citron;
                                btnChoice3.setText("");
                                userGuessList.add(2, new Fruit(enumFruits.CITRON));
                                break;
                            case "Fraise":
                                btnChoice3.setBackgroundResource(fraise);
                                image_3 = findViewById(R.id.fraise);
                                tabIntFruits[2] = fraise;
                                btnChoice3.setText("");
                                userGuessList.add(2, new Fruit(enumFruits.FRAISE));
                                break;
                            case "Framboise":
                                btnChoice3.setBackgroundResource(framboise);
                                image_3 = findViewById(R.id.framboise);
                                tabIntFruits[2] = framboise;
                                btnChoice3.setText("");
                                userGuessList.add(2, new Fruit(enumFruits.FRAMBOISE));
                                break;
                            case "Kiwi":
                                btnChoice3.setBackgroundResource(kiwi);
                                image_3 = findViewById(R.id.kiwi);
                                tabIntFruits[2] = kiwi;
                                btnChoice3.setText("");
                                userGuessList.add(2, new Fruit(enumFruits.KIWI));
                                break;
                            case "Orange":
                                btnChoice3.setBackgroundResource(orange);
                                image_3 = findViewById(R.id.orange);
                                tabIntFruits[2] = orange;
                                btnChoice3.setText("");
                                userGuessList.add(2, new Fruit(enumFruits.ORANGE));
                                break;
                            case "Prune":
                                btnChoice3.setBackgroundResource(prune);
                                image_3 = findViewById(R.id.prune);
                                tabIntFruits[2] = prune;
                                btnChoice3.setText("");
                                userGuessList.add(2, new Fruit(enumFruits.PRUNE));
                                break;
                            case "Raisin":
                                btnChoice3.setBackgroundResource(raisin);
                                image_3 = findViewById(R.id.raisin);
                                tabIntFruits[2] = raisin;
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
        //Same as button 1
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
                                image_4 = findViewById(R.id.banane);
                                tabIntFruits[3] = banane;
                                btnChoice4.setText("");
                                userGuessList.add(3, new Fruit(enumFruits.BANANE));
                                break;
                            case "Citron":
                                btnChoice4.setBackgroundResource(citron);
                                image_4 = findViewById(R.id.citron);
                                tabIntFruits[3] = citron;
                                btnChoice4.setText("");
                                userGuessList.add(3, new Fruit(enumFruits.CITRON));
                                break;
                            case "Fraise":
                                btnChoice4.setBackgroundResource(fraise);
                                image_4 = findViewById(R.id.fraise);
                                tabIntFruits[3] = fraise;
                                btnChoice4.setText("");
                                userGuessList.add(3, new Fruit(enumFruits.FRAISE));
                                break;
                            case "Framboise":
                                btnChoice4.setBackgroundResource(framboise);
                                image_4 = findViewById(R.id.framboise);
                                tabIntFruits[3] = framboise;
                                btnChoice4.setText("");
                                userGuessList.add(3, new Fruit(enumFruits.FRAMBOISE));
                                break;
                            case "Kiwi":
                                btnChoice4.setBackgroundResource(kiwi);
                                image_4 = findViewById(R.id.kiwi);
                                tabIntFruits[3] = kiwi;
                                btnChoice4.setText("");
                                userGuessList.add(3, new Fruit(enumFruits.KIWI));
                                break;
                            case "Orange":
                                btnChoice4.setBackgroundResource(orange);
                                image_4 = findViewById(R.id.orange);
                                tabIntFruits[3] = orange;
                                btnChoice4.setText("");
                                userGuessList.add(3, new Fruit(enumFruits.ORANGE));
                                break;
                            case "Prune":
                                btnChoice4.setBackgroundResource(prune);
                                image_4 = findViewById(R.id.prune);
                                tabIntFruits[3] = prune;
                                btnChoice4.setText("");
                                userGuessList.add(3, new Fruit(enumFruits.PRUNE));
                                break;
                            case "Raisin":
                                btnChoice4.setBackgroundResource(raisin);
                                image_4 = findViewById(R.id.raisin);
                                tabIntFruits[3] = raisin;
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
                Resources res = getResources();
                charToInsert = checkUserInput(userGuessList, listToFind, MAX_FRUITS);
                Boolean endGame = checkVictoryConditions(charToInsert);
                adapter.addListHisto(new ListHistoric(res, tabIntFruits, charToInsert));
                list.setLayoutManager(lm);
                list.setAdapter(adapter);
                COUPS_RESTANTS = COUPS_RESTANTS - 1;
                NbTries.setText(String.valueOf(COUPS_RESTANTS));
                Toast.makeText(MainActivity.this, String.valueOf(endGame), Toast.LENGTH_LONG).show();
                if (endGame.booleanValue() == true) {
                    Score = Score + COUPS_RESTANTS;
                    NbVictories = NbVictories + 1;

                    popupEndGame(endGame);
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
                }
                else if (endGame.booleanValue() == false && COUPS_RESTANTS == 0) {
                    Score = Score + COUPS_RESTANTS;
                    //NbVictories = NbVictories;

                    popupEndGame(endGame);
                    Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_LONG).show();
                }
                Total_Score.setText(String.valueOf(Score));
            }
        });
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
        for (int i = 0; i <= 4; i++) {
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

    // Vérification de victoire si les deux listes sont égales
    // useless
    private Boolean checkVictoryConditions(List<Character> result) {
        if (result.get(0) == 'X' && result.get(1) == 'X' && result.get(2) == 'X' && result.get(3) == 'X') {
            return true;
        }
        else {
            return false;
        }
    }



    private List<Character> checkUserInput(List<Fruit>userInput, List<Fruit>inGameFruits, int MAX_FRUITS){ //call a chaque fois que l'utilisateur click sur valider
        List<Character> result = new ArrayList<Character>();

        for(int i = 0; i < MAX_FRUITS; i++){
            char tmpResult = 'O';


            for(int j=0; j < MAX_FRUITS; j++){
                if(userInput.get(i).getName().equals(inGameFruits.get(j).getName())){
                    tmpResult = 'V';

                    if(i == j){
                        tmpResult = 'X';
                    }
                }
            }
            result.add(i, tmpResult);
        }



        return result;
    }




    //==========================================
    //==========================================
    // Partie de Yoan
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

        indicePep = findViewById(R.id.indicePepinTxt);
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

        indiceEp = findViewById(R.id.indiceEpTxt);
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

    public void useIndice(){
        if (tag_hints == 0 && COUPS_RESTANTS > 2) {
            COUPS_RESTANTS = COUPS_RESTANTS - 2;
            NbTries.setText(String.valueOf(COUPS_RESTANTS));
            tag_hints = 1;
        }
        else if (tag_hints == 1 && COUPS_RESTANTS > 3) {
            COUPS_RESTANTS = COUPS_RESTANTS - 3;
            NbTries.setText(String.valueOf(COUPS_RESTANTS));
            tag_hints = 2;
        }
        else {
            Toast.makeText(MainActivity.this, "Vous avez utilisez tout les indices disponibles", Toast.LENGTH_LONG).show();
        }

    }


    private void popupEndGame(final Boolean endGame){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.activity_end_game, null);
        TextView mVictoireDefaite = (TextView) mView.findViewById(R.id.VictoireDefaite);
        TextView score = (TextView) mView.findViewById(R.id.textView5);
        TextView nbVic = (TextView) mView.findViewById(R.id.textView4);
        Button mNewGame = (Button) mView.findViewById(R.id.NewGame);
        final Button mRestart = (Button) mView.findViewById(R.id.Restart);
        final Button mQuitt = (Button) mView.findViewById(R.id.Quitt);

        if (endGame) {
            mVictoireDefaite.setText("Victoire");
        }
        else {
            mVictoireDefaite.setText("Defaite");
        }
        nbVic.setText(String.valueOf(this.NbVictories));
        score.setText(String.valueOf(this.Score));
        mBuilder.setView(mView);

        final AlertDialog dialog = mBuilder.create();

        dialog.show();

        mNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                COUPS_RESTANTS = 10;
                tag_hints = 0;
                adapter.clearList();
                NbTries.setText(String.valueOf(COUPS_RESTANTS));
                listToFind.clear();
                listToFind = initGameList();
                if (!endGame) {
                    Score = 0;
                    NbVictories = 0;
                    Total_Score.setText(String.valueOf(Score));
                }
                dialog.cancel();
            }
        });

        mRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                COUPS_RESTANTS = 10;
                tag_hints = 0;
                adapter.clearList();
                NbTries.setText(String.valueOf(COUPS_RESTANTS));
                if (!endGame) {
                    Score = 0;
                    NbVictories = 0;
                    Total_Score.setText(String.valueOf(Score));
                }
                dialog.cancel();
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

}