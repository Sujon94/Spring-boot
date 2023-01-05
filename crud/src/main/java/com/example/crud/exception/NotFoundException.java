package com.example.crud.exception;

class TutorialNotFoundException extends RuntimeException{
    TutorialNotFoundException(long id){
        super("Could not found tutorial "+id);
    }
}
