package com.example.razvan.naturalremedies;

import android.content.Intent;
import android.media.Image;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Helpers.PlantAdapter;
import Models.Plant;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailsActivityFragment extends Fragment {

    private PlantAdapter mPlantAdapter;

    public DetailsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Intent intent = getActivity().getIntent();
        View rootView = inflater.inflate(R.layout.fragment_details, container, false);

        Map<String, String> dictionary = new HashMap<String, String>();
        if (intent != null && intent.hasExtra("name")) {
            dictionary.put("name", intent.getStringExtra("name"));
        }
        if (intent != null && intent.hasExtra("scientificName")) {
            dictionary.put("scientificName", intent.getStringExtra("scientificName"));
        }
        if (intent != null && intent.hasExtra("description")) {
            dictionary.put("description", intent.getStringExtra("description"));
        }
        if (intent != null && intent.hasExtra("contraindications")) {
            dictionary.put("contraindications", intent.getStringExtra("contraindications"));
        }
        if (intent != null && intent.hasExtra("disease")) {
            dictionary.put("disease", intent.getStringExtra("disease"));
        }
        if (intent != null && intent.hasExtra("preparation")) {
            dictionary.put("preparation", intent.getStringExtra("preparation"));
        }

        List<Plant> plantsList = new ArrayList<Plant>();
        for (int i = 0; i < 5; i++) {
            Plant planta = new Plant();
            planta.initWithDictionary(dictionary);
            plantsList.add(planta);
        }

        mPlantAdapter = new PlantAdapter(getActivity(), 0, plantsList);

        ListView listView = (ListView) rootView.findViewById(
                R.id.detail_text);
        listView.setAdapter(mPlantAdapter);


        return rootView;
    }
}
