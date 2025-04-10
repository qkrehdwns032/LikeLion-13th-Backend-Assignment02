package com.likelion.springprac.user.api;

import lombok.Builder;

@Builder
public record UserDto (
    Long id,
    String name,
    String email
){

}
