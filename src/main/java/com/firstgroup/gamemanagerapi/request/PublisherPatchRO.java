package com.firstgroup.gamemanagerapi.request;

import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

public record PublisherPatchRO (
       String name,
       String email,
       String description
) {
    public boolean isEmpty() {
        return Stream.of(name, email, description).allMatch(StringUtils::isEmpty);
    }
}
