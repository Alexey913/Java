package controller;

import java.util.List;

import data.GroupStream;
import service.GroupStreamServiceImpl;

public class GroupStreamController implements Controller<GroupStream, Integer> {

    private final GroupStreamServiceImpl groupStreamServiceImpl;

    public GroupStreamController(GroupStreamServiceImpl groupStreamServiceImpl) {
        this.groupStreamServiceImpl = groupStreamServiceImpl;
    }

    @Override
    public GroupStream save(GroupStream entity) {
        return this.groupStreamServiceImpl.saveGroupStream(entity);
    }

    @Override
    public GroupStream findById(Integer id) {
        return this.groupStreamServiceImpl.findByIdGroupStream(id);
    }

    public List<GroupStream> sortGroupStream(List<GroupStream> groupStream) {
        this.groupStreamServiceImpl.sortGroupStream(groupStream);
        return groupStream;
    }
}