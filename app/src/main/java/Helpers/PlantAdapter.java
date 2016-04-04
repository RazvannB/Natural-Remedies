package Helpers;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.razvan.naturalremedies.R;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import Models.Plant;

/**
 * Created by Razvan on 3/17/2016.
 */
public class PlantAdapter extends ArrayAdapter<Plant> {

    private static final int TYPE_IMAGE = 0;
    private static final int TYPE_NAME = 1;
    private static final int TYPE_DESCRIPTION = 2;
    private static final int TYPE_DISEASE = 3;
    private static final int TYPE_PREPARATION = 4;
    private static final int TYPE_CONTRAINDICATIONS = 5;
    private static final int TYPE_MAX_COUNT = TYPE_CONTRAINDICATIONS + 1;

    Context mContext;
    List<Plant> mObjects;

    public PlantAdapter(Context context, int resource, List<Plant>items) {
        super(context, resource, items);
        this.mContext = context;
        this.mObjects = items;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_MAX_COUNT;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View currentView = convertView;
        Plant plant = mObjects.get(position);
        int viewType = getItemViewType(position);

        if (plant != null) {
            switch (viewType) {
                case TYPE_IMAGE:
                    if (currentView == null || currentView.getTag() != position) {
                        currentView = LayoutInflater.from(mContext).inflate(R.layout.plant_item_image, null);
                        currentView.setTag(position);
                    }
                    ImageView imageView = (ImageView) currentView.findViewById(R.id.plant_image);
                    if (imageView != null) {
                        //  Get image from plant model
                    }
                    break;
                case TYPE_NAME:
                    if (currentView == null || currentView.getTag() != position) {
                        currentView = LayoutInflater.from(mContext).inflate(R.layout.plant_item_name, null);
                        currentView.setTag(position);
                    }
                    TextView nameTextView = (TextView) currentView.findViewById(R.id.plant_item_name);
                    TextView scientificTextView = (TextView) currentView.findViewById(R.id.plant_item_scientificName);
                    if (nameTextView != null) {
                        nameTextView.setText("Nume comun: " + plant.getName());
                    }
                    if (scientificTextView != null) {
                        scientificTextView.setText("Denumire stiintifica: " + plant.getScientificName());
                    }
                    break;
                case TYPE_DESCRIPTION:
                    if (currentView == null || currentView.getTag() != position) {
                        currentView = LayoutInflater.from(mContext).inflate(R.layout.plant_item_description, null);
                        currentView.setTag(position);
                    }
                    TextView descriptionTextView = (TextView) currentView.findViewById(R.id.plant_description);
                    if (descriptionTextView != null) {
                        descriptionTextView.setText("\nDescriere\n\n" + plant.getDescription());
                    }
                    break;
                case TYPE_DISEASE:
                    if (currentView == null || currentView.getTag() != position) {
                        currentView = LayoutInflater.from(mContext).inflate(R.layout.plant_item_description, null);
                        currentView.setTag(position);
                    }
                    TextView diseaseTextView = (TextView) currentView.findViewById(R.id.plant_description);
                    if (diseaseTextView != null) {
                        diseaseTextView.setText("\nActiuni\n\n" + plant.getDisease());
                    }
                    break;
                case TYPE_PREPARATION:
                    if (currentView == null || currentView.getTag() != position) {
                        currentView = LayoutInflater.from(mContext).inflate(R.layout.plant_item_description, null);
                        currentView.setTag(position);
                    }
                    TextView preparationTextView = (TextView) currentView.findViewById(R.id.plant_description);
                    if (preparationTextView != null) {
                        preparationTextView.setText("\nMod de administrare\n\n" + plant.getPreparation());
                    }
                    break;
                case TYPE_CONTRAINDICATIONS:
                    if (currentView == null || currentView.getTag() != position) {
                        currentView = LayoutInflater.from(mContext).inflate(R.layout.plant_item_description, null);
                        currentView.setTag(position);
                    }
                    TextView contraindicationsTextView = (TextView) currentView.findViewById(R.id.plant_description);
                    if (contraindicationsTextView != null) {
                        contraindicationsTextView.setText("\nContraindicatii\n\n" + plant.getContraindications());
                    }
                    break;
            }
        }

        return currentView;
    }
}
