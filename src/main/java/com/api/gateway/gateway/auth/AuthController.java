package com.api.gateway.gateway.auth;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {
  private static final String USER = "demo";
  private static final String PASS = "demo123";

  public static final String TOKEN = "my-demo-token-123";

  @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Map<String, String>> login(@RequestBody Map<String, String> body) {
    String u = body.getOrDefault("username", "");
    String p = body.getOrDefault("password", "");

    if (!USER.equals(u) || !PASS.equals(p)) {
      return Mono.error(new UnauthorizedException());
    }

    return Mono.just(Map.of(
        "token_type", "Bearer",
        "access_token", TOKEN
    ));
  }
}
