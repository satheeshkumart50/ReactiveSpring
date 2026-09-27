package com.appsdeveloperblog.reactive.ws.users.presentation;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public Mono<ResponseEntity<UserRest>> createUser(@RequestBody @Valid Mono<CreateUserRequest> createUserRequest) {
        return createUserRequest.map(
                (request) ->
                        new UserRest(UUID.randomUUID(),
                                request.getFirstName(),
                                request.getLastName(),
                                request.getEmail())
        ).map(userRest -> ResponseEntity.status(HttpStatus.CREATED).
                location(URI.create("/users/" + userRest.getUuid())).body(userRest)
        );
    }

    @GetMapping("/{userId}")
    public Mono<UserRest> getUser(@PathVariable UUID userId) {
        return Mono.just(new UserRest(userId,
                "S1",
                "s2",
                "s3@hh.com"));
    }

    @GetMapping
    public Flux<UserRest> getUsers(@RequestParam(value = "offset", defaultValue = "0") int offset,
                                   @RequestParam(value = "limit", defaultValue = "50") int limit) {
        return Flux.just(new UserRest(UUID.randomUUID(),
                        "S1",
                        "s2",
                        "s3@hh.com"),
                new UserRest(UUID.randomUUID(),
                        "S4",
                        "s4",
                        "s6@hh.com"));
    }

}
