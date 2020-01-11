package epsi.emile.dadou.fruitmastermind;


import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;
//Creation d'une ligne pour l'historique des essais
class ListHistoric {
    Drawable[] images = new Drawable[4];
    Character[] insertChar = new Character[4];

    public ListHistoric(Resources res, Integer[] fruitsInput, List<Character> charToInsert) {
        for (int i = 0; i < 4; i++) {
            images[i] = res.getDrawable(fruitsInput[i]);
            insertChar[i] = charToInsert.get(i);
        }
    }

    public Drawable getImageFruit(int index) {
        if (index < 0 || index >= 4) {
            return null;
        }
        return images[index];
    }

    public Character getInsertedChar(int index) {
        if (index < 0 ||index >= 4) {
            return null;
        }
        return insertChar[index];
    }

}