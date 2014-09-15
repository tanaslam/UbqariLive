package org.ubqari.android.ubqarilive.ui.fragments;

import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.ubqari.android.ubqarilive.R;
import org.ubqari.android.ubqarilive.model.ArchivedAudio;
import org.ubqari.android.ubqarilive.model.Model;
import org.ubqari.android.ubqarilive.ui.adapters.AudioListAdapter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tanny on 06/07/2014.
 */
@EFragment(R.layout.fragment_section_archivedaudios)
public class ArchivedAudiosFragment extends SectionFragment {

    @Bean
    Model model;

    @ViewById(R.id.archivedAudios_list_audios)
    ExpandableListView  audioList;

    @Bean(AudioListAdapter.class)
    BaseExpandableListAdapter adapter;

    private Map children = new HashMap<String, List<ArchivedAudio>>();

    @AfterViews
    void setupView() {
        updateModel();
    }

    @UiThread
    void setupListView() {
        children.put("Jan", model.getAllAudios());

        ((AudioListAdapter)adapter).init(
                Arrays.asList("Jan"), children);

        audioList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Background
    void updateModel() {
        model.fetchAudios();
        setupListView();
    }


}
