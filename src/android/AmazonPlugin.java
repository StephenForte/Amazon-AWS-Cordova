package com.amazon.aws;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class AmazonPlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getCredentials")) {
            this.getCredentials(callbackContext);
            return true;
        }
        return false;
    }

    private void getCredentials(CallbackContext callbackContext) throws JSONException {

        int appResId = cordova.getActivity().getResources().getIdentifier("aws_access_key", "string", cordova.getActivity().getPackageName());
        String accessKey = cordova.getActivity().getString(appResId);

        appResId = cordova.getActivity().getResources().getIdentifier("aws_secret_key", "string", cordova.getActivity().getPackageName());
        
        String secretKey = cordova.getActivity().getString(appResId);

        JSONObject data = new JSONObject();

        data.put("accessKey", accessKey);
        data.put("secretKey", secretKey);
        
        callbackContext.success(data);
    }
}
