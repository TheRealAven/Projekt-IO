package locations;

public interface Visitable {
    /**
     *
     * @param visitor Wystąpienie klasy Visitor przyjmowane poprzez tę metodę w wystąpieniu innej klasy.
     */
    public void accept(Visitor visitor);
}
