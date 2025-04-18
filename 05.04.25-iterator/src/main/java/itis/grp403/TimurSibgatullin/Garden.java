package itis.grp403.TimurSibgatullin;

import java.util.*;


public class Garden implements Iterable<String> {
    private final List<String> flowers;

    public Garden(List<String> flowers) {
        this.flowers = new ArrayList<>(flowers);
    }

    public Iterator<String> iterator(GardenerType type) {
        List<String> order = switch (type) {
            case FIRST -> List.of("роза", "астра", "ромашка");
            case SECOND -> List.of("астра", "ромашка", "роза");
        };

        // Фильтруем по наличию в саду (если вдруг какого-то цветка нет)
        List<String> result = new ArrayList<>();
        for (String flower : order) {
            if (flowers.contains(flower)) {
                result.add(flower);
            }
        }
        return result.iterator();
    }

    @Override
    public Iterator<String> iterator() {
        return flowers.iterator(); // обычный итератор, если ничего не указано
    }
}