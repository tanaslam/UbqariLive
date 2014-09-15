package org.ubqari.android.ubqarilive.rest;

import android.util.Log;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.rest.RestService;
import org.ubqari.android.ubqarilive.model.ArchivedAudio;

import java.util.List;

/**
 * Created by Tanny on 06/07/2014.
 */
@EBean(scope = EBean.Scope.Singleton)
public class UbqariRestClient {

    private static final String TAG = UbqariRestClient.class.getSimpleName();

    @RestService
    UbqariRestApi restApi;

    public List<ArchivedAudio> getAllArchivedAudios() {

        try {
            return restApi.getAllArchivedAudioList();
        } catch (Exception e) {
            Log.e(TAG, "Failed to fetch data from end-point" + e.getLocalizedMessage());
        }

        return null;
    }

    public List<ArchivedAudio> getGroupAudios(int groupId) {

        try {
            return restApi.getArchivedAudios(groupId);
        } catch (Exception e) {
            Log.e(TAG, "Failed to fetch data from end-point" + e.getLocalizedMessage());
        }

        return null;
    }

}
