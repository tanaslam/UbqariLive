package org.ubqari.android.ubqarilive.ui.adapters;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.SystemService;
import org.ubqari.android.ubqarilive.R;
import org.ubqari.android.ubqarilive.engine.UbqariMediaPlayer;
import org.ubqari.android.ubqarilive.model.ArchivedAudio;

import java.util.List;
import java.util.Map;

/**
 * Created by Tanny on 06/07/2014.
 */
@EBean
public class AudioListAdapter extends BaseExpandableListAdapter {

    @RootContext
    Activity context;

    @SystemService
    LayoutInflater inflater;

    @Bean
    UbqariMediaPlayer mediaPlayer;

    private List<String> listGroup;
    private Map<String, List<ArchivedAudio>> listChildren;

    public void init(List<String> listGroups,
                            Map<String, List<ArchivedAudio>> listChildren) {
        this.listGroup = listGroups;
        this.listChildren = listChildren;

        int checkItem;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listChildren.get(this.listGroup.get(groupPosition))
                .get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final ArchivedAudio child = (ArchivedAudio)
                getChild(groupPosition, childPosition);

        if (convertView == null) {

            final HolderView holderView = new HolderView();

            convertView = inflater.inflate(R.layout.list_item_audios, null);

            TextView title = (TextView) convertView
                    .findViewById(R.id.list_item_audio_detail);
            title.setText(child.getStrTitleEng());
            holderView.title = title;

            ToggleButton status = (ToggleButton) convertView
                    .findViewById(R.id.list_item_audio_status);
            status.setTag(child);
            status.setChecked(child.isPlaying());
            status.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    ArchivedAudio checkedChild = ((ArchivedAudio) buttonView.getTag());
                    mediaPlayer.reset();
                    if (isChecked) {
                        mediaPlayer.setOnDemandDataSource("http://www.ubqari.org/data/speaches/"
                                + checkedChild.getStrFileName());
                        mediaPlayer.play();
                    }
                    holderView.isPlaying = isChecked;

                }
            });

            holderView.statusButton = status;

            convertView.setTag(holderView);

        } else {
            HolderView view = (HolderView) convertView.getTag();
            view.title.setText(child.getStrTitleEng());
            view.statusButton.setChecked(view.isPlaying);
        }
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listChildren.get(this.listGroup.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listGroup.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.listGroup.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_group_audios, null);
            convertView.setBackgroundColor(
                    context.getResources().getColor(R.color.list_background_dark));
        }

        TextView groupTitle = (TextView) convertView
                .findViewById(R.id.list_group_detail_audios);
        groupTitle.setTypeface(null, Typeface.BOLD);
        groupTitle.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private static class HolderView {
        TextView title;
        ToggleButton statusButton;
        int position;
        boolean isPlaying;
    }

}
