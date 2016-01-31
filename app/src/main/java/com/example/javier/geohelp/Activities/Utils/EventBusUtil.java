package com.example.javier.geohelp.Activities.Utils;

import de.greenrobot.event.EventBus;

/**
 * Created by javier on 30/01/2016.
 */
public class EventBusUtil {


    public static final String EVENT_TICKET_CREATE_TAG = "";
    public static final String EVENT_TICKET_SUCCEEDED_DELETING_TAG = "SUCCEEDED_DELETING_TICKET";
    public static final String EVENT_TICKET_FAILED_DELETING_TAG = "FAILED_DELETING_TICKET";
    public static final String EVENT_TICKET_SEARCH_TAG = "SEARCH_TICKETS";
    public static final String EVENT_TICKET_CANCELJOBS_TAG = "TICKET_CANCEL";
    public static final String EVENT_TICKET_UPDATE_TAG = "UPDATE_TICKET";
    public static final String EVENT_GET_LOCAL_TICKET_TAG = "GET_LOCAL_TICKET";

    public static final String EVENT_SUCCESS_UPLOADING_MEDIAFILE_TAG = "SUCCESS_UPLOADING_MEDIAFILE";
    public static final String EVENT_ERROR_UPLOADING_MEDIAFILE_TAG = "ERROR_UPLOADING_MEDIAFILE";
    public static final String EVENT_SUCCESS_MEDIAFILE_TAG = "SUCCESS_MEDIAFILE";
    public static final String EVENT_ERROR_MEDIAFILE_TAG = "ERROR_MEDIAFILE";

    public static void post(Object event) {
        EventBus.getDefault().post(event);
    }

    public static void register(Object object) {
        EventBus.getDefault().register(object);
    }

    public static void unregister(Object object) {
        EventBus.getDefault().unregister(object);
    }

    public static void postSticky(Object object) {
        EventBus.getDefault().postSticky(object);
    }

    public static void isRegistred(Object object) {
        EventBus.getDefault().isRegistered(object);
    }
}
