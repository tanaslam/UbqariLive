package org.ubqari.android.ubqarilive.model;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.UiThread;
import org.ubqari.android.ubqarilive.rest.UbqariRestClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanny on 07/07/2014.
 */
@EBean (scope = EBean.Scope.Singleton)
public class Model {

    @Bean
    UbqariRestClient restCLient;

    List<ArchivedAudio> allAudios = new ArrayList<ArchivedAudio>();

    @Background
    public void fetchAudios() {

        List<ArchivedAudio> audios = restCLient.getGroupAudios(1);
        updateAudios(audios);
    }

    @UiThread
    protected void updateAudios(List<ArchivedAudio> audios) {
        setAllAudios(audios);
    }


    public List<ArchivedAudio> getAllAudios() {
        return allAudios;
    }

    public void setAllAudios(List<ArchivedAudio> allAudios) {
        this.allAudios = allAudios;
    }
}
