package com.NoChu.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConstructorBinding;

@RequiredArgsConstructor
@Getter
@ConstructorBinding
public class ManiaDbProperties {

    private final String url;
    private final String display;
    private final String method;
    private final String apiKey;
    private final String version;

}
