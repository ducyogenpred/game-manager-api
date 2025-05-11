package com.firstgroup.gamemanagerapi.request;

import org.apache.catalina.util.StringUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.Optional;
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



