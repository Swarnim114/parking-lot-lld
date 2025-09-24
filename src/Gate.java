public abstract class Gate {
    protected int gateId;
    protected Guard guard;

    public Gate(int gateId, Guard guard) {
        this.gateId = gateId;
        this.guard = guard;
    }

    // Getters
    public int getGateId() {
        return gateId;
    }

    public Guard getGuard() {
        return guard;
    }

    // Setters
    public void setGateId(int gateId) {
        this.gateId = gateId;
    }

    public void setGuard(Guard guard) {
        this.guard = guard;
    }

    @Override
    public String toString() {
        return "Gate{" +
                "gateId=" + gateId +
                ", guard=" + guard +
                '}';
    }
}