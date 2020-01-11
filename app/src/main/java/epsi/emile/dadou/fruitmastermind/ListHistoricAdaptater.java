package epsi.emile.dadou.fruitmastermind;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
//Attempt to use the Recycler view Unused / Dead code
public class ListHistoricAdaptater extends RecyclerView.Adapter<ListHistoricAdaptater.ItemView> {

    private List<ListHistoric> m_Histo;

    // Constructeur
    public ListHistoricAdaptater(final LinearLayoutManager L) {

        m_Histo = new ArrayList<ListHistoric>();

        registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeChanged(int positionStart, int itemCount) {
                super.onItemRangeChanged(positionStart, itemCount);
                L.scrollToPosition(m_Histo.size() - 1);
            }
        });
    }

    // Ajoute un item a la list
    public void addListHisto(ListHistoric lh) {
        m_Histo.add(lh);
        notifyDataSetChanged();
        //notifyItemChanged(getItemCount());
    }

    // Efface la list
    public void clearList() {
        m_Histo.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListHistoricAdaptater.ItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater infl = LayoutInflater.from(parent.getContext());
        View view = infl.inflate(R.layout.activity_historic_list, parent, false);
        return new ItemView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHistoricAdaptater.ItemView holder, int position) {
        holder.fruit1.setImageDrawable(m_Histo.get(position).getImageFruit(0));
        holder.fruit2.setImageDrawable(m_Histo.get(position).getImageFruit(1));
        holder.fruit3.setImageDrawable(m_Histo.get(position).getImageFruit(2));
        holder.fruit4.setImageDrawable(m_Histo.get(position).getImageFruit(3));
        holder.indice1.setText(m_Histo.get(position).getInsertedChar(0));
        holder.indice2.setText(m_Histo.get(position).getInsertedChar(1));
        holder.indice3.setText(m_Histo.get(position).getInsertedChar(2));
        holder.indice4.setText(m_Histo.get(position).getInsertedChar(3));
    }

    @Override
    public int getItemCount() {
        return m_Histo.size();
    }

    public class ItemView extends RecyclerView.ViewHolder{

        public ImageView fruit1;
        public ImageView fruit2;
        public ImageView fruit3;
        public ImageView fruit4;
        public TextView indice1;
        public TextView indice2;
        public TextView indice3;
        public TextView indice4;

        public ItemView(@NonNull View view) {
            super(view);
            fruit1 = view.findViewById(R.id.image1);
            fruit2 = view.findViewById(R.id.image2);
            fruit3 = view.findViewById(R.id.image3);
            fruit4 = view.findViewById(R.id.image4);
            indice1 = view.findViewById(R.id.indice1);
            indice2 = view.findViewById(R.id.indice2);
            indice3 = view.findViewById(R.id.indice3);
            indice4 = view.findViewById(R.id.indice4);
        }
    }
}
