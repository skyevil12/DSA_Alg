import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MyKBN {
    private static Map<String, ActorGraphNode> bNActorMap = new HashMap<>();

    public static void main(String... args) {
        try {
            //Why no scanner but file reader?
            BufferedReader fileReader = new BufferedReader(new FileReader(new File("action06.txt")));
            String line;
            while (null != (line = fileReader.readLine())) {
                buildGraph(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //bfs(bNActorMap.get("Gilbert, Lewis (I)"), "Bacon, Kevin");

        bfs_preCount(bNActorMap.get("Bacon, Kevin"));
        //insertNew("Winston/Gilbert, Lewis (I)/Bacon, Kevin");

        System.out.println("new Answer is " + getBN("Gilbert, Lewis (I)"));
    }

    //Count the distance on the fly
    private static void bfs(ActorGraphNode start, String targetActorName) {
        Queue<ActorGraphNode> queue = new LinkedList<>();
        queue.offer(start);
        start.setbN(0);

        while (!queue.isEmpty()) {
            ActorGraphNode actorGraphNode = queue.poll();
            if (actorGraphNode == bNActorMap.get(targetActorName)) {
                System.out.println("Answer is " + actorGraphNode.getbN());
                return;
            }
            for (ActorGraphNode sibling : actorGraphNode.getLinkedActors()) {
                if (-1 != sibling.getbN()) {
                    continue;
                }

                sibling.setbN(actorGraphNode.getbN() + 1);
                queue.offer(sibling);
            }
        }
    }

    //Precompute the Bacon Number
    private static void bfs_preCount(ActorGraphNode targetNode) {
        Queue<ActorGraphNode> queue = new LinkedList<>();
        queue.offer(targetNode);
        targetNode.setbN(0);

        while (!queue.isEmpty()) {
            ActorGraphNode actorGraphNode = queue.poll();
            for (ActorGraphNode sibling : actorGraphNode.getLinkedActors()) {
                if (-1 != sibling.getbN()) {
                    continue;
                }

                sibling.setbN(actorGraphNode.getbN() + 1);
                queue.offer(sibling);
            }
        }
    }

    private static int getBN(String startNodeStr) {
        return bNActorMap.get(startNodeStr).getbN();
    }

    //Add new movie and update BN only affected items
    private static void insertNew(String mvCastStr) {
        String[] castStrArray = mvCastStr.split("/");
        Set<String> newActorsInMovie = new HashSet<>();
        for(int i = 1; i< castStrArray.length; i++) {
            newActorsInMovie.add(castStrArray[i]);
        }

        String[] newActorsInMovieArray = new String[newActorsInMovie.size()];
        int q = 0;
        for (String str : newActorsInMovie) {
            newActorsInMovieArray[q++] = str;
        }

        //Insert to global map
        for (int i = 0; i < newActorsInMovieArray.length; i++) {
            String newActor = newActorsInMovieArray[i];
            if (!bNActorMap.containsKey(newActor)) {
                bNActorMap.put(newActor, new ActorGraphNode(newActor));
            }

            for (int j = i + 1; j < newActorsInMovieArray.length; j++) {
                bNActorMap.get(newActor).linkCostar(bNActorMap.get(newActorsInMovieArray[j]));
            }
        }

        //Reset affected node to unvisited
        resetBfs_preCount(newActorsInMovie, bNActorMap.get("Bacon, Kevin"));
    }

    private static void resetBfs_preCount(Set<String> newActorsStr, ActorGraphNode targetNode) {
        Queue<ActorGraphNode> queue = new LinkedList<>();
        targetNode.setbN(0);
        queue.offer(targetNode);

        while (!queue.isEmpty()) {
            ActorGraphNode actor = queue.poll();
            for (ActorGraphNode sibling : actor.getLinkedActors()) {
                resetBN(newActorsStr, sibling);
                if (-1 != sibling.getbN()) {
                    continue;
                }
                sibling.setbN(actor.getbN() + 1);
                queue.offer(sibling);
            }
        }
    }

    private static void resetBN(Set<String> newActorsStr, ActorGraphNode actor) {
        if (!newActorsStr.contains(actor.getName()) || newActorsStr.isEmpty()) {
            return;
        }
        actor.setbN(-1);
        newActorsStr.remove(actor.getName());
    }


    private static void buildGraph(String mvCastStr) {
        String[] castStrArray = mvCastStr.split("/");
        for (int i = 1; i < castStrArray.length; i++) {
            String castName = castStrArray[i];
            if (!bNActorMap.containsKey(castName)) {
                bNActorMap.put(castName, new ActorGraphNode(castName));
            }
        }

        for (int i = 1; i < castStrArray.length; i++) {
            for (int j = i + 1; j < castStrArray.length; j++) {
                bNActorMap.get(castStrArray[i]).linkCostar(bNActorMap.get(castStrArray[j]));
            }
        }
    }
}
