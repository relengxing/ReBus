package com.relenxing.domain;

import java.io.Serializable;

public class Event<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String eventName;

    private T event;


    public Event() {
    }

    public Event(String eventName, T event) {
        this.eventName = eventName;
        this.event = event;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public T getEvent() {
        return event;
    }

    public void setEvent(T event) {
        this.event = event;
    }
}
