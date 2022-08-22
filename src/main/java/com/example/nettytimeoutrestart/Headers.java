package com.example.nettytimeoutrestart;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Headers(@JsonProperty("Accept") String accept) {
}
