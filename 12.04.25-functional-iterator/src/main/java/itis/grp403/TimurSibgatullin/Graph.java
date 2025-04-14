package itis.grp403.TimurSibgatullin;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Graph implements Iterable<HashMap>{
    private Map<Character, Set<Character>> graph;

    public Graph() {
        graph = new HashMap<>();

        graph.put('d', null);
        graph.put('a', new HashSet<>(Set.of('d','c')));
        graph.put('f', new HashSet<>(Set.of('d')));
        graph.put('g', new HashSet<>(Set.of('d','c', 'f')));
        graph.put('c', null);
        graph.put('b', new HashSet<>(Set.of('f','g','a','c')));
    }

    public Set<Character> sort() {
        return null;
    }

    @Override
    public Iterator<HashMap> iterator() {
        return new GraphIterator();
    }

    class GraphIterator implements Iterator<HashMap> {
        int currentCount = 0;
        HashMap<Character> result = new HashMap<>();
        @Override
        public boolean hasNext() {
            return !graph.isEmpty();
        };

        @Override
        public HashMap next() {
            for (Character i : graph.keySet()) {
                if (graph.get(i) == null) {
                    result.add(i);
                    for (Character j : graph.keySet()) {
                        graph.get(j).remove(i);
                    }
                }
            }
            return result;
        }
    }
}
