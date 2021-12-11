package au.edu.jcu.cp3406.medreminder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MedAdapter extends ArrayAdapter<Medicine> {

    private final int resource;

    public MedAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Medicine> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(resource, parent, false);

        // link to template display
        TextView medInfo = convertView.findViewById(R.id.medInfo);
        String medType = getItem(position).getType();

        // formatted string display
        medInfo.setText(getItem(position).getString(medType));

        return convertView;
    }
}
