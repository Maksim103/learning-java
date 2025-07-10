package org.example.Tasks.MessageService;

public interface Sendable<T> {
    String getFrom();
    String getTo();
    T getContent();
}

