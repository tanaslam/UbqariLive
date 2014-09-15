package org.ubqari.android.ubqarilive.ui.fragments;

import android.support.v4.view.ViewPager;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.ubqari.android.ubqarilive.R;
import org.ubqari.android.ubqarilive.engine.UbqariMediaPlayer;

/**
 * Created by Tanny on 06/07/2014.
 */
@EFragment(R.layout.fragment_section_ubqarilive)
public class UbqariLiveFragment extends SectionFragment {

    @Bean
    UbqariMediaPlayer player;

    @ViewById(R.id.ubqarilive_pager)
    ViewPager pager1;

    @Click(R.id.ubqarilive_btn_play)
    void handlePlayButton() {
        player.play();
    }

    @Click(R.id.ubqarilive_btn_mute)
    void handleMuteButton() {
        player.mute();
    }
}
