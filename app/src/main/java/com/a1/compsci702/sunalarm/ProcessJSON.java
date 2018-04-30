package com.a1.compsci702.sunalarm;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by st970 on 28/03/2018.
 */

public class ProcessJSON {

    public JSONObject stringToJSON(String rawJSON) {
        JSONObject response = null;
        try {
            response = new JSONObject(rawJSON);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return response;
    }

}
