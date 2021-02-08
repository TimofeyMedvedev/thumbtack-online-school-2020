package net.thumbtack.school.elections.daoimpl;

import net.thumbtack.school.elections.dao.VoterDao;
import net.thumbtack.school.elections.database.Database;
import net.thumbtack.school.elections.database.DatabaseException;
import net.thumbtack.school.elections.model.Voter;

public class VoterDaoImpl implements VoterDao {
    @Override
    public void insert(Voter voter) throws DatabaseException {
        Database.getDatabase().insert(voter);
    }
}
