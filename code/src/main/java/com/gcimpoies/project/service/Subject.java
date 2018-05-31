package com.gcimpoies.project.service;

import com.gcimpoies.project.controller.Observer;

public interface Subject {
    public void registerObserver(Observer o);

    public void unregisterObserver(Observer o);

    public void notifyObservers();
}