package org.ubqari.android.ubqarilive.ui.fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.ubqari.android.ubqarilive.R;
import org.ubqari.android.ubqarilive.ui.activities.DashboardActivity;

/**
 * A dashboard fragment that manages section fragment when drawer menu item is selected.
 * Created by Tanny on 06/07/2014.
 */
@EFragment(R.layout.fragment_dashboard)
public class DashboardFragment extends Fragment {

    private FragmentManager fm;

    enum Sections {UBQARI_LIVE, ARCHIVED_AUDIODS};

    @FragmentArg
    int position = -1;

    @AfterViews
    void setupView() {
        showDashboardFragment();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((DashboardActivity) activity).onSectionAttached(position);
    }

    public void showDashboardFragment() {
        SectionFragment sf =  getSectionFragment();
        fm = getChildFragmentManager();
        fm.beginTransaction().replace(R.id.section, sf).commit();
    }

    private SectionFragment getSectionFragment() {

        switch (position) {
            case 0:
                return UbqariLiveFragment_.builder().build();
            case 1:
                return ArchivedAudiosFragment_.builder().build();
            default:
                return SectionPlaceholderFragment_.builder().build();
        }
    }
}
