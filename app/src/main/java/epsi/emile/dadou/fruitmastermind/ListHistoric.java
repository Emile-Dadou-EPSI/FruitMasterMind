package epsi.emile.dadou.fruitmastermind;


import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable;

import java.util.List;
//Creation d'une ligne pour l'historique des essais
class ListHistoric {
    Drawable[] images;

    public ListHistoric(Resources res, Integer[] fruitsInput) {
        for (int i = 0; i < 4; i++) {
            images[i] = res.getDrawable(fruitsInput[i]);
        }
    }

    public Drawable getImageFruit(int index) {
        if (index < 0 || index >= 4) {
            return null;
        }
        return images[index];
    }

}