package com.bozzaccio.twitterclone.utils;

public final class ErrorUtils {

    // initial error messages
    public static final String BASE_INITIALIZATION_ERROR = "Initialization Error: %s %s";
    public static final String BASE_PARAMETER_ERROR = "Invalid param: %s %s";
    public static final String BASE_DB_ERROR = "Persistence Error: %s %s";

    // subjects
    public static final String SERVICE = "Service";
    public static final String DAO = "Repository";
    public static final String DTO = "Data Object";
    public static final String ENTITY = "Entity";
    public static final String ID_PARAM = "Id";
    public static final String CONVERTER = "Converter";

    // causal messages
    public static final String NULL_MESSAGE_ERROR = "cannot be null!";
    public static final String ENTITY_NOT_FOUND_FOR_ID_ERROR = "entity not found for Id";

    public static String buildErrorMessage(String initial, String subject, String causal) {
        return String.format(initial, subject, causal);
    }

    public static String buildErrorMessageWithValue(String initial, String causal, Object value) {
        return String.format(initial, causal, value);
    }
}
