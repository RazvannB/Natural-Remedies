package com.example.razvan.naturalremedies;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.*;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ArrayAdapter<String> mRemediesAdapter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        String[] remediesArray = {
                "Today - Sunny - 88/63",
                "Tomorrow - Foggy - 70/40",
                "Weds - Cloudy - 72/63",
                "Thurs - Asteroids - 75/65",
                "Fri - Heavy Rain - 65/56",
                "Sat - HELP TRAPPED IN WEATHERSTATION - 60/51",
                "Sun - Sunny - 80/68"
        };

        List<String> remediesData = new ArrayList<String>(Arrays.asList(remediesArray));

        // Create the adapter
        mRemediesAdapter =
                new ArrayAdapter<String>(
                        // The current context (this fragment's parent activity)
                        getActivity(),
                        // ID of list item layout
                        R.layout.list_item_remedy,
                        // ID of the textview to populate
                        R.id.list_item_remedy_textview,
                        // Remedies data
                        remediesData
                );

        // Get a reference to the ListView and attach the adapter to it
        ListView listView = (ListView) rootView.findViewById(
                R.id.listview_remedies);
        listView.setAdapter(mRemediesAdapter);

        return rootView;
    }
}
