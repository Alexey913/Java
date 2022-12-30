package data;

import java.util.Iterator;
import java.util.List;

import data.iterator.GroupStreamIterator;

public class GroupStream implements Iterable<StudentGroup> {

    private List<StudentGroup> groupStream;
    private int id;

    public GroupStream(List<StudentGroup> groupStream, int id) {
        this.groupStream = groupStream;
        this.id = id;
    }

    public List<StudentGroup> getgroupStream() {
        return groupStream;
    }

    public void setgroupStream(List<StudentGroup> groupStream) {
        this.groupStream = groupStream;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Iterator<StudentGroup> iterator() {
        return new GroupStreamIterator(this.groupStream);
    }
}