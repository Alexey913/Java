package service;

import java.util.Collections;
import java.util.List;

import data.GroupStream;
import data.comparator.GroupStreamComparator;
import repository.Repository;

public class GroupStreamServiceImpl implements GroupStreamService<GroupStream, Integer> {

    private final Repository<GroupStream, Integer> groupStreamRepository;

    public GroupStreamServiceImpl(Repository<GroupStream, Integer> groupStreamRepository) {
        this.groupStreamRepository = groupStreamRepository;
    }

    @Override
    public void sortGroupStream(List<GroupStream> groupStream) {
        Collections.sort(groupStream, new GroupStreamComparator());
    }

    @Override
    public GroupStream saveGroupStream(GroupStream entity) {
        return this.groupStreamRepository.save(entity);
    }

    @Override
    public GroupStream findByIdGroupStream(Integer id) {
        return this.groupStreamRepository.findById(id);
    }
}