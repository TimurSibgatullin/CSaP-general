package itis.grp403.TimurSibgatullin;

import java.util.*;
import java.util.Set;

public class Graph implements Iterable<Character>{
    private Map<Character, Set<Character>> graph;


    public Graph() {
        graph = new HashMap<>();


        graph.put('d', new HashSet<>());
        graph.put('a', new HashSet<>(Set.of('d','c')));
        graph.put('f', new HashSet<>(Set.of('d')));
        graph.put('g', new HashSet<>(Set.of('d','c', 'f')));
        graph.put('c', new HashSet<>());
        graph.put('b', new HashSet<>(Set.of('f','g','a','c')));
    }

    public Set<Character> sort() {
        Set<Character> result = new LinkedHashSet<>();
        while (!graph.isEmpty()) {
            // ищем вершины без зависимостей
            Character nodeToAdd = null;
            for (Map.Entry<Character, Set<Character>> entry : graph.entrySet()) {
                if (entry.getValue().isEmpty()) {
                    nodeToAdd = entry.getKey();
                    break;
                }
            }
            // если нет вершин с нулевыми зависимостями
            if (nodeToAdd == null) {
                throw new RuntimeException("Цикл в графе — сортировка невозможна");
            }

            // добавляем в результат вершину с нулевыми зависимостями
            result.add(nodeToAdd);
            // удаляем из графа вершину с нулевыми зависимостями
            graph.remove(nodeToAdd);

            // удаляем зависимости
            for (Set<Character> deps : graph.values()) {
                deps.remove(nodeToAdd);
            }
        }
        return result;
    }

    @Override
    public Iterator<Character> iterator() {
        return new GraphIterator();
    }

    class GraphIterator implements Iterator<Character> {
        int currentCount = 0;
        Character[] result = sort().toArray(Character[]::new);
        @Override
        public boolean hasNext() {
            return (currentCount < result.length);
        };

        @Override
        public Character next() {
            return result[currentCount++];
        }
    }
}
