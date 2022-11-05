package com.example.miniproject.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Token {
 @JsonProperty("access_token")
 private String  accessToken;
 @JsonProperty("expires_in")
 private String  expiresIn;
 @JsonProperty("scope")
 private String  scope;
 @JsonProperty("token_type")
 private String  tokenType;
}
