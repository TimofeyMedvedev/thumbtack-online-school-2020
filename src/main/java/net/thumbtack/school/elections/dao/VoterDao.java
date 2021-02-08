package net.thumbtack.school.elections.dao;

import net.thumbtack.school.elections.database.DatabaseException;
import net.thumbtack.school.elections.model.Voter;

public interface VoterDao {
    void insert(Voter voter) throws DatabaseException;
}
