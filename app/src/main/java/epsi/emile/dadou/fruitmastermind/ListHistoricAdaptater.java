package epsi.emile.dadou.fruitmastermind;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListHistoricAdaptater extends ArrayAdapter<ListHistoric> {

    public ListHistoricAdaptater(Context context, List<ListHistoric> tweets) {
        super(context, 0, tweets);
    }

    public class ListHistoricHolder {
        public ImageView image1;
        public ImageView image2;
        public ImageView image3;
        public ImageView image4;

        public TextView indice1;
        public TextView indice2;
        public TextView indice3;
        public TextView indice4;
    }

}
