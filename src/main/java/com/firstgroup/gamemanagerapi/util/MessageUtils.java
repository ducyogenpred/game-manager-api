package com.firstgroup.gamemanagerapi.util;

public class MessageUtils {

    public static final String SAVE_SUCCESS_MESSAGE = "Successfully saved %s.";
    public static final String SAVE_FAILURE_MESSAGE = "Failed to save %s.";

    public static final String RETRIEVE_SUCCESS_MESSAGE = "Successfully retrieved %s.";
    public static final String RETRIEVE_FAILURE_MESSAGE = "Failed to retrieve %s.";
    public static final String RETRIEVE_EMPTY_MESSAGE = "No %s found.";

    public static final String UPDATE_SUCCESS_MESSAGE = "Successfully updated %s.";
    public static final String UPDATE_FAILURE_MESSAGE = "Failed to update %s.";

    public static final String DELETE_SUCCESS_MESSAGE = "Successfully deleted %s.";
    public static final String DELETE_FAILURE_MESSAGE = "Failed to delete %s.";

    public static final String VALIDATION_ERROR_MESSAGE = "Validation error occurred.";

    public static final String DUPLICATE_ERROR_MESSAGE = "Duplicate error occurred.";

    public static String saveSuccess(String resource) {
        return String.format(SAVE_SUCCESS_MESSAGE, resource);
    }

    public static String saveFailure(String resource) {
        return String.format(SAVE_FAILURE_MESSAGE, resource);
    }

    public static String retrieveSuccess(String resource) {
        return String.format(RETRIEVE_SUCCESS_MESSAGE, resource);
    }

    public static String retrieveFailure(String resource) {
        return String.format(RETRIEVE_FAILURE_MESSAGE, resource);
    }

    public static String retrieveEmpty(String resource) {
        return String.format(RETRIEVE_EMPTY_MESSAGE, resource);
    }

    public static String updateSuccess(String resource) {
        return String.format(UPDATE_SUCCESS_MESSAGE, resource);
    }

    public static String updateFailure(String resource) {
        return String.format(UPDATE_FAILURE_MESSAGE, resource);
    }

    public static String deleteSuccess(String resource) {
        return String.format(DELETE_SUCCESS_MESSAGE, resource);
    }

    public static String deleteFailure(String resource) {
        return String.format(DELETE_FAILURE_MESSAGE, resource);
    }
}
