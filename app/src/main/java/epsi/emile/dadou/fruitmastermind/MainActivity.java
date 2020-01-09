package epsi.emile.dadou.fruitmastermind;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.TypeConverter;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
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

public class MainActivity extends AppCompatActivity {

    private Button btnChoice1;
    private Button btnChoice2;
    private Button btnChoice3;
    private Button btnChoice4;
    private Button validateButton;

    // élément pour la liste :
    private ImageView Image1;
    private ImageView Image2;
    private ImageView Image3;
    private ImageView Image4;
    private String indice1;
    private String indice2;
    private String indice3;
    private String indice4;

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
                                Image1.setImageDrawable(getResources().getDrawable(banane));
                                btnChoice1.setText("");
                                // add le fruit à la liste de l'utilisateur
                                userGuessList.add(0, new Fruit(enumFruits.BANANE));
                                break;
                            case "Citron":
                                btnChoice1.setBackgroundResource(citron);
                                Image1.setImageDrawable(getResources().getDrawable(citron));
                                btnChoice1.setText("");
                                userGuessList.add(0, new Fruit(enumFruits.CITRON));
                                break;
                            case "Fraise":
                                btnChoice1.setBackgroundResource(fraise);
                                Image1.setImageDrawable(getResources().getDrawable(fraise));
                                btnChoice1.setText("");
                                userGuessList.add(0, new Fruit(enumFruits.FRAISE));
                                break;
                            case "Framboise":
                                btnChoice1.setBackgroundResource(framboise);
                                Image1.setImageDrawable(getResources().getDrawable(framboise));
                                btnChoice1.setText("");
                                userGuessList.add(0, new Fruit(enumFruits.FRAMBOISE));
                                break;
                            case "Kiwi":
                                btnChoice1.setBackgroundResource(kiwi);
                                Image1.setImageDrawable(getResources().getDrawable(kiwi));
                                btnChoice1.setText("");
                                userGuessList.add(0, new Fruit(enumFruits.KIWI));
                                break;
                            case "Orange":
                                btnChoice1.setBackgroundResource(orange);
                                Image1.setImageDrawable(getResources().getDrawable(orange));
                                btnChoice1.setText("");
                                userGuessList.add(0, new Fruit(enumFruits.ORANGE));
                                break;
                            case "Prune":
                                btnChoice1.setBackgroundResource(prune);
                                Image1.setImageDrawable(getResources().getDrawable(prune));
                                btnChoice1.setText("");
                                userGuessList.add(0, new Fruit(enumFruits.PRUNE));
                                break;
                            case "Raisin":
                                btnChoice1.setBackgroundResource(raisin);
                                Image1.setImageDrawable(getResources().getDrawable(raisin));
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
                                Image2.setImageDrawable(getResources().getDrawable(banane));
                                btnChoice2.setText("");
                                userGuessList.add(1, new Fruit(enumFruits.BANANE));
                                break;
                            case "Citron":
                                btnChoice2.setBackgroundResource(citron);
                                Image2.setImageDrawable(getResources().getDrawable(citron));
                                btnChoice2.setText("");
                                userGuessList.add(1, new Fruit(enumFruits.CITRON));
                                break;
                            case "Fraise":
                                btnChoice2.setBackgroundResource(fraise);
                                Image2.setImageDrawable(getResources().getDrawable(fraise));
                                btnChoice2.setText("");
                                userGuessList.add(1, new Fruit(enumFruits.FRAISE));
                                break;
                            case "Framboise":
                                btnChoice2.setBackgroundResource(framboise);
                                Image2.setImageDrawable(getResources().getDrawable(framboise));
                                btnChoice2.setText("");
                                userGuessList.add(1, new Fruit(enumFruits.FRAMBOISE));
                                break;
                            case "Kiwi":
                                btnChoice2.setBackgroundResource(kiwi);
                                Image2.setImageDrawable(getResources().getDrawable(kiwi));
                                btnChoice2.setText("");
                                userGuessList.add(1, new Fruit(enumFruits.KIWI));
                                break;
                            case "Orange":
                                btnChoice2.setBackgroundResource(orange);
                                Image2.setImageDrawable(getResources().getDrawable(orange));
                                btnChoice2.setText("");
                                userGuessList.add(1, new Fruit(enumFruits.ORANGE));
                                break;
                            case "Prune":
                                btnChoice2.setBackgroundResource(prune);
                                Image2.setImageDrawable(getResources().getDrawable(prune));
                                btnChoice2.setText("");
                                userGuessList.add(1, new Fruit(enumFruits.PRUNE));
                                break;
                            case "Raisin":
                                btnChoice2.setBackgroundResource(raisin);
                                Image2.setImageDrawable(getResources().getDrawable(raisin));
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
                                Image3.setImageDrawable(getResources().getDrawable(banane));
                                btnChoice3.setText("");
                                userGuessList.add(2, new Fruit(enumFruits.BANANE));
                                break;
                            case "Citron":
                                btnChoice3.setBackgroundResource(citron);
                                Image3.setImageDrawable(getResources().getDrawable(citron));
                                btnChoice3.setText("");
                                userGuessList.add(2, new Fruit(enumFruits.CITRON));
                                break;
                            case "Fraise":
                                btnChoice3.setBackgroundResource(fraise);
                                Image3.setImageDrawable(getResources().getDrawable(fraise));
                                btnChoice3.setText("");
                                userGuessList.add(2, new Fruit(enumFruits.FRAISE));
                                break;
                            case "Framboise":
                                btnChoice3.setBackgroundResource(framboise);
                                Image3.setImageDrawable(getResources().getDrawable(framboise));
                                btnChoice3.setText("");
                                userGuessList.add(2, new Fruit(enumFruits.FRAMBOISE));
                                break;
                            case "Kiwi":
                                btnChoice3.setBackgroundResource(kiwi);
                                Image3.setImageDrawable(getResources().getDrawable(kiwi));
                                btnChoice3.setText("");
                                userGuessList.add(2, new Fruit(enumFruits.KIWI));
                                break;
                            case "Orange":
                                btnChoice3.setBackgroundResource(orange);
                                Image3.setImageDrawable(getResources().getDrawable(orange));
                                btnChoice3.setText("");
                                userGuessList.add(2, new Fruit(enumFruits.ORANGE));
                                break;
                            case "Prune":
                                btnChoice3.setBackgroundResource(prune);
                                Image3.setImageDrawable(getResources().getDrawable(prune));
                                btnChoice3.setText("");
                                userGuessList.add(2, new Fruit(enumFruits.PRUNE));
                                break;
                            case "Raisin":
                                btnChoice3.setBackgroundResource(raisin);
                                Image3.setImageDrawable(getResources().getDrawable(raisin));
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
                                Image4.setImageDrawable(getResources().getDrawable(banane));
                                btnChoice4.setText("");
                                userGuessList.add(3, new Fruit(enumFruits.BANANE));
                                break;
                            case "Citron":
                                btnChoice4.setBackgroundResource(citron);
                                Image4.setImageDrawable(getResources().getDrawable(citron));
                                btnChoice4.setText("");
                                userGuessList.add(3, new Fruit(enumFruits.CITRON));
                                break;
                            case "Fraise":
                                btnChoice4.setBackgroundResource(fraise);
                                Image4.setImageDrawable(getResources().getDrawable(fraise));
                                btnChoice4.setText("");
                                userGuessList.add(3, new Fruit(enumFruits.FRAISE));
                                break;
                            case "Framboise":
                                btnChoice4.setBackgroundResource(framboise);
                                Image4.setImageDrawable(getResources().getDrawable(framboise));
                                btnChoice4.setText("");
                                userGuessList.add(3, new Fruit(enumFruits.FRAMBOISE));
                                break;
                            case "Kiwi":
                                btnChoice4.setBackgroundResource(kiwi);
                                Image4.setImageDrawable(getResources().getDrawable(kiwi));
                                btnChoice4.setText("");
                                userGuessList.add(3, new Fruit(enumFruits.KIWI));
                                break;
                            case "Orange":
                                btnChoice4.setBackgroundResource(orange);
                                Image4.setImageDrawable(getResources().getDrawable(orange));
                                btnChoice4.setText("");
                                userGuessList.add(3, new Fruit(enumFruits.ORANGE));
                                break;
                            case "Prune":
                                btnChoice4.setBackgroundResource(prune);
                                Image4.setImageDrawable(getResources().getDrawable(prune));
                                btnChoice4.setText("");
                                userGuessList.add(3, new Fruit(enumFruits.PRUNE));
                                break;
                            case "Raisin":
                                btnChoice4.setBackgroundResource(raisin);
                                Image4.setImageDrawable(getResources().getDrawable(raisin));
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




                /*String img1 = Image1.getDrawable().toString();
                String img2 = Image1.getDrawable().toString();
                String img3 = Image1.getDrawable().toString();
                String img4 = Image1.getDrawable().toString();

                historic.add(String.valueOf(img1, img2, img3, img4, indice1, indice2, indice3, indice4));
                historicAdapter.notifyDataSetChanged();

                // Add verification if the guess list is full (contains 4 fruits and there is no double items)
                Set<Fruit> freq = new HashSet<>(userGuessList);
                for (Fruit fr : freq) {
                    if(Collections.frequency(userGuessList, fr) > 1) {
                        String frequency = "" + Collections.frequency(userGuessList, fr);
                        String freque = "Test 0 " + frequency;
                        Toast.makeText(MainActivity.this, freque,Toast.LENGTH_SHORT).show();
                    }
                    else {
                        String frequency = "" + Collections.frequency(userGuessList, fr);
                        String freque = "test 1 " + frequency;
                        Toast.makeText(MainActivity.this, freque,Toast.LENGTH_SHORT).show();
                    }
                }*/
                // and then submit the list to verification and then inflate the list of tries

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

    // Vérification de victoire si les deux listes sont égales
    // useless
    private void checkVictoryConditions(List<Fruit> listToGuess, List<Fruit> userGuessList) {
        if (listToGuess.equals(userGuessList)) {
            Toast.makeText(MainActivity.this, "Yay you're the master fruiter",Toast.LENGTH_SHORT).show();
        }
    }

    //
    private void initGame() {
        historic = new ArrayList<>();
        historicAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, historic);
        list = findViewById(R.id.list);
        list.setAdapter(historicAdapter);
    }

   /*private List<ListHistoric> generateList(){
        List<ListHistoric> listHistorics = new ArrayList<ListHistoric>();
        listHistorics.add(new ListHistoric(Image1, Image2, Image3, Image4, "0", "0","0","0"));
        listHistorics.add(new ListHistoric(Image1, Image2, Image3, Image4, "0", "0","0","0"));
        listHistorics.add(new ListHistoric(Image1, Image2, Image3, Image4, "0", "0","0","0"));
        listHistorics.add(new ListHistoric(Image1, Image2, Image3, Image4, "0", "0","0","0"));
        listHistorics.add(new ListHistoric(Image1, Image2, Image3, Image4, "0", "0","0","0"));
        listHistorics.add(new ListHistoric(Image1, Image2, Image3, Image4, "0", "0","0","0"));
        listHistorics.add(new ListHistoric(Image1, Image2, Image3, Image4, "0", "0","0","0"));
        listHistorics.add(new ListHistoric(Image1, Image2, Image3, Image4, "0", "0","0","0"));
        listHistorics.add(new ListHistoric(Image1, Image2, Image3, Image4, "0", "0","0","0"));
        listHistorics.add(new ListHistoric(Image1, Image2, Image3, Image4, "0", "0","0","0"));
        return listHistorics;
   }*/


}