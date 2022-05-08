public interface ISubject {
    public void attach(IObserver update);
    public void detach(IObserver remove);
    public void notify(String bildirim);
}
