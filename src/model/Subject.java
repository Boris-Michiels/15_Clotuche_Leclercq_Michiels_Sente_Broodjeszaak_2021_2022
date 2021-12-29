package model;

public interface Subject {

        void addObserver(BestellingEvents e,Observer o);
        void removeObserver(Observer o);
        void notifyObservers(BestellingEvents e);
    }

