package locations;

public interface Visitor {
    /**
     *
     * @param room Pomieszczenie, które będzie przekazane do wizytora.
     */
    public void visitRoom(Room room);
}
