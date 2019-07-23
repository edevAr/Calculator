package com.gogenesiss.calculator.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.gogenesiss.calculator.MainActivity;
import com.gogenesiss.calculator.R;
import com.gogenesiss.calculator.models.Key;

import java.util.ArrayList;

public class ButtonAdapter extends ArrayAdapter<Key> {
    private ArrayList<Key> keys;
    private Activity context;

    static class ViewHolder {
        TextView text_number;
    }

    public ButtonAdapter(Activity context, int resource, ArrayList<Key> objects) {
        super(context,resource,objects);
        this.context = context;
        keys = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v==null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.button, null);
            ViewHolder stuff = new ViewHolder();
            stuff.text_number = (TextView) v.findViewById(R.id.id_number);
            v.setTag(stuff);
        }
        if (keys == null)
            return v;
        final Key key = keys.get(position);
        if (key != null) {
            ViewHolder stuff = (ViewHolder)v.getTag();

            TextView textNumber = stuff.text_number;
            textNumber.setText(key.getValue());
            textNumber.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pressButton(key);
                }
            });
        }
        return v;
    }
    private void pressButton(Key key){
        MainActivity mainActivity = (MainActivity)context;
        mainActivity.displayButtonPressed(key);
    }
}
