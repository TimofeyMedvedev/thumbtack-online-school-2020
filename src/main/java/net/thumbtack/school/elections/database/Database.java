package net.thumbtack.school.elections.database;

import net.thumbtack.school.elections.model.Voter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public final class Database implements Serializable {
    private static Database database;
    // REVU: в текущей реализации использовать Set можно, но на будущее учтите, что полных переборов в базе данных нужно
    // избегать и полностью возвращать какую-либо коллекцию тоже не нужно.
    private Set<Voter> voterSet = new HashSet<>();
    private Set<String> loginSet = new HashSet<>();

    private Database() {
    }

    public static Database getDatabase() {
        if(database == null) {
            database = new Database();
        }
        return database;
    }

    public void insert(Voter voter) throws DatabaseException {
        if(voterSet.contains(voter)) {
            throw new DatabaseException(DatabaseErrorCode.VOTER_WRONG);
        }
        if(loginSet.contains(voter.getLogin())) {
            throw new DatabaseException(DatabaseErrorCode.VOTER_WRONG_LOGIN);
        }
        loginSet.add(voter.getLogin());
        voterSet.add(voter);
    }
}
