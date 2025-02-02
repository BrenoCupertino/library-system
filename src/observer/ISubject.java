package observer;

public interface ISubject{
    void addObserver(IObserver user);
    void notifyObservers();
}
