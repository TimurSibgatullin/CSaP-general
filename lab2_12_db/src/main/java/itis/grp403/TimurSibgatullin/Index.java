package itis.grp403.TimurSibgatullin;

import java.io.Serializable;

public class Index implements Serializable, Comparable<Index> {
    private int id;
    private long position;

    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Index o) {
        return Integer.compare(this.id, o.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Index index = (Index) o;
        return id == index.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return "Index{" +
                "id=" + id +
                ", position=" + position +
                '}';
    }
}
