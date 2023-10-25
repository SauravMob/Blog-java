package com.blog.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IdNotFoundException extends Exception {

    public IdNotFoundException(String message) {
        super(message);
    }
}
