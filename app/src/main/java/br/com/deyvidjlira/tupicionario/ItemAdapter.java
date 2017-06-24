package br.com.deyvidjlira.tupicionario;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Deyvid on 09/05/2017.
 */

public class ItemAdapter extends ArrayAdapter<Item> {

    private int backgroundColor;

    public ItemAdapter(Context context, ArrayList<Item> listItem, int backgroundColor) {
        super(context, 0, listItem);
        this.backgroundColor = backgroundColor;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemView = convertView;
        if(itemView == null) {
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Item item = getItem(position);

        TextView textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
        TextView textViewDescription = (TextView) itemView.findViewById(R.id.textViewDescription);
        ImageView imageViewIcon = (ImageView) itemView.findViewById(R.id.imageViewIcon);

        textViewTitle.setText(item.getTitle());
        textViewDescription.setText(item.getDescription());
        imageViewIcon.setImageResource(item.getImage());

        LinearLayout linearLayoutTexts = (LinearLayout) itemView.findViewById(R.id.linearLayoutTexts);
        int color = ContextCompat.getColor(getContext(), backgroundColor);
        linearLayoutTexts.setBackgroundColor(color);

        return  itemView;
    }
}
