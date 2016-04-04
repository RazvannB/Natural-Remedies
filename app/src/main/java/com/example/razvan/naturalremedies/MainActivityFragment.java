package com.example.razvan.naturalremedies;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.*;

import Models.Plant;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private CustomAdapter mRemediesAdapter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        List<Plant> plantsList = new ArrayList<Plant>();

        Plant aPlant = new Plant();
        Map<String, String> map1 = new HashMap<String, String>();

        map1.put("name", "Crusan");
        map1.put("scientificName", "Rhamnus frangula");
        map1.put("description", "Organ folosit: scoarta");
        map1.put("contraindications", "-");
        map1.put("disease", "Actiune laxativ-purgativă pentru constipaţii acute.");
        map1.put("preparation", "Decoct obţinut din jumătate linguriţă produs vegetal pulverizat la 150 mL apă, timp de contact 10-15 min., urmat de repaus 2 ore înainte de filtrare. Se recomandă să se administreze o cană decoct/zi, de preferabil seara.");

        aPlant.initWithDictionary(map1);
        plantsList.add(aPlant);

        map1.put("name", "Sunatoare");
        map1.put("scientificName", "Hypericum perforatum");
        map1.put("description", "Organ folosit: partea aeriană (tulpini, frunze, flori)");
        map1.put("contraindications", "-");
        map1.put("disease", "Acţiune: colagog-coleretică, cicatrizantă, antipruriginoasă, antidepresivă, fotosensibilizatoare, antibacteriană, capilaroprotectoare, diuretică.\n" +
                "Întrebuinţări: intern în tratamentul colitei, colecistitei, ulcerului gastro-duodenal, stări depresive (la vârsta a III-a); extern în arsuri.");
        map1.put("preparation", "Infuzie obţinută din 2-4 g produs vegetal la 150 mL apă, se administrează 1-2 căni de infuzie proaspăt preparată/zi, de preferabil dimineaţa şi seara");

        aPlant = new Plant();
        aPlant.initWithDictionary(map1);
        plantsList.add(aPlant);

        map1.put("name", "Lemn dulce");
        map1.put("scientificName", "Glycyrrhiza glabra");
        map1.put("description", "Descriere planta");
        map1.put("contraindications", "Contraindicatii planta");
        map1.put("disease", "Adectiuni tratate");
        map1.put("preparation", "Prepararea plantei");

        aPlant = new Plant();
        aPlant.initWithDictionary(map1);
        plantsList.add(aPlant);

        map1.put("name", "Afin");
        map1.put("scientificName", "Vaccinium myrtillus");

        aPlant = new Plant();
        aPlant.initWithDictionary(map1);
        plantsList.add(aPlant);

        map1.put("name", "Paducel");
        map1.put("scientificName", "Crataegus sp");

        aPlant = new Plant();
        aPlant.initWithDictionary(map1);
        plantsList.add(aPlant);

        map1.put("name", "Castan salbatic");
        map1.put("scientificName", "Aesculus hippocastanum");

        aPlant = new Plant();
        aPlant.initWithDictionary(map1);
        plantsList.add(aPlant);

        map1.put("name", "Ginseng");
        map1.put("scientificName", "Panax ginseng");

        aPlant = new Plant();
        aPlant.initWithDictionary(map1);
        plantsList.add(aPlant);

        mRemediesAdapter = new CustomAdapter(getActivity(), 0, plantsList);

        // Get a reference to the ListView and attach the adapter to it
        ListView listView = (ListView) rootView.findViewById(
                R.id.listview_remedies);
        listView.setAdapter(mRemediesAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Plant selectedPlant = mRemediesAdapter.getItem(position);
                Intent intent = new Intent(getActivity(), DetailsActivity.class).putExtra("name", selectedPlant.getName());
                intent.putExtra("scientificName", selectedPlant.getScientificName());
                intent.putExtra("description", selectedPlant.getDescription());
                intent.putExtra("disease", selectedPlant.getDisease());
                intent.putExtra("contraindications", selectedPlant.getContraindications());
                intent.putExtra("preparation", selectedPlant.getPreparation());
                startActivity(intent);
            }
        });

        return rootView;
    }
}

class CustomAdapter extends ArrayAdapter<Plant> {

    private Context mContext;
    private List<Plant> mObjects;

    public CustomAdapter(Context context, int resource, List<Plant> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mObjects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View currentView = convertView;
        Plant plant = mObjects.get(position);

        if (plant != null) {
            if (currentView == null) {
                currentView = LayoutInflater.from(mContext).inflate(R.layout.list_item_remedy, null);
            }
            TextView nameTextView = (TextView) currentView.findViewById(R.id.list_item_remedy_title);
            TextView scientificTextView = (TextView) currentView.findViewById(R.id.list_item_remedy_subtitle);
            if (nameTextView != null) {
                nameTextView.setText(plant.getName());
            }
            if (scientificTextView != null) {
                scientificTextView.setText(plant.getScientificName());
            }
        }

        return currentView;
    }
}
