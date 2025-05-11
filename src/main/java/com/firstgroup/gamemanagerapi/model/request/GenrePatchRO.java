package com.firstgroup.gamemanagerapi.model.request;

import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

public record GenrePatchRO (
    String name,
    String email,
    String description
)  {
    public boolean isEmpty() {
        return Stream.of(name,description).allMatch(StringUtils::isEmpty);
    }
}



