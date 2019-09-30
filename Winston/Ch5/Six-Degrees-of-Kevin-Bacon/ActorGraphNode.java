import java.util.HashSet;
import java.util.Set;

public class ActorGraphNode {
    public String getName() {
        return name;
    }

    private String name;

    public Set<ActorGraphNode> getLinkedActors() {
        return linkedActors;
    }

    private Set<ActorGraphNode> linkedActors;

    public int getbN() {
        return bN;
    }

    public void setbN(int bN) {
        this.bN = bN;
    }

    private int bN = -1;

    public ActorGraphNode(String name) {
        this.name = name;
        linkedActors = new HashSet<>();
    }

    public void linkCostar(ActorGraphNode costar) {
        linkedActors.add(costar);
        costar.linkedActors.add(this);
    }
}
