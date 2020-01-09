package epsi.emile.dadou.fruitmastermind;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListHistoricAdaptater extends ArrayAdapter<ListHistoric> {

    public ListHistoricAdaptater(Context context, List<ListHistoric> ListHistorics) {
        super(context, 0, ListHistorics);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_historic_list,parent, false);
        }

        ListHistoricHolder viewHolder = (ListHistoricHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new ListHistoricHolder();
            viewHolder.image1 = (ImageView) convertView.findViewById(R.id.image1);
            viewHolder.image2 = (ImageView) convertView.findViewById(R.id.image2);
            viewHolder.image3 = (ImageView) convertView.findViewById(R.id.image3);
            viewHolder.image4 = (ImageView) convertView.findViewById(R.id.image4);

            viewHolder.indice1 = (TextView) convertView.findViewById(R.id.indice1);
            viewHolder.indice2 = (TextView) convertView.findViewById(R.id.indice2);
            viewHolder.indice3 = (TextView) convertView.findViewById(R.id.indice3);
            viewHolder.indice4 = (TextView) convertView.findViewById(R.id.indice4);

            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<ListHistoric> ListHistorics
        ListHistoric listHistoric = getItem(position);

        /*viewHolder.image1.s(listHistoric.getImage1());
        viewHolder.image2.setImageDrawable(listHistoric.getImage2());
        viewHolder.image3.setImageDrawable(listHistoric.getImage3());
        viewHolder.image4.setImageDrawable(listHistoric.getImage4()));

        viewHolder.indice1.setText(listHistoric.getIndice1());
        viewHolder.indice2.setText(listHistoric.getIndice2());
        viewHolder.indice3.setText(listHistoric.getIndice3());
        viewHolder.indice4.setText(listHistoric.getIndice4());*/

        return convertView;
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
