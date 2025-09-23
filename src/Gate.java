
public abstract class Gate {
    private int gateNo;
    private Guard guard;

    public Gate(int gateNo, Guard guard) {
        this.gateNo = gateNo;
        this.guard = guard;
    }

    public int getGateNo() {
        return gateNo;
    }

    public Guard getGuard() {
        return guard;
    }
}
