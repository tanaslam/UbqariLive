package org.ubqari.android.ubqarilive.rest;

import org.androidannotations.annotations.rest.Accept;
import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.MediaType;
import org.ubqari.android.ubqarilive.model.ArchivedAudio;

import java.util.List;

/**
 * Created by Tanny on 06/07/2014.
 */
@Rest(rootUrl = "http://www.ubqari.org/index.php?r=audio", converters = UbqariGsonConverter.class)
@Accept(MediaType.APPLICATION_JSON)
public interface UbqariRestApi {

    /**
     * Get list of archived audio lists
     */
    @Get("/audios")
    List<ArchivedAudio> getAllArchivedAudioList();

    @Accept(MediaType.TEXT_HTML)
    @Get("/GroupJson&id={groupId}")
    List<ArchivedAudio> getArchivedAudios(int groupId);
}
