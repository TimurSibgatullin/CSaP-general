package itis.grp403.TimurSibgatullin;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class test implements Iterable<String> {
    String[] flowers = new String[3];
    GardenerType gardenWorker;

    public test(GardenerType gardenWorker, String flower1, String flower2, String flower3) {
        this.gardenWorker = gardenWorker;
        flowers[0] = flower1;
        flowers[1] = flower2;
        flowers[2] = flower3;
    }

    public void setGardenWorker(GardenerType gardenWorker) {
        this.gardenWorker = gardenWorker;
    }

    public Iterator<String> iterator() {
        return new Iterator<String>() {
            int current = 0;
            List<String> order = switch (gardenWorker) {
                case FIRST -> List.of("роза", "астра", "ромашка");
                case SECOND -> List.of("астра", "ромашка", "роза");
            };

            public boolean hasNext() {
                return current < 3;
            }

            public String next() {
                if  (current > 2) throw new NoSuchElementException();
                if (gardenWorker == GardenerType.FIRST) {
                    if (true) {
                        return order.get(current++);
                    } else {
                        return order.get(current++);
                    }
                }
                return "";
            };
        };
    }
}