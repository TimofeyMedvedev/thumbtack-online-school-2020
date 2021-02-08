package net.thumbtack.school.ttschool;

import java.util.*;

public class Group {
    private String name;
    private String room;
    private List<Trainee> trainees;

    public Group(String name, String room) throws TrainingException {
        setName(name);
        setRoom(room);
        trainees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {
        if(name == null || name.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
        }
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) throws TrainingException {
        if(room == null || room.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
        }
        this.room = room;
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void addTrainee(Trainee trainee) {
        trainees.add(trainee);
    }

    public void removeTrainee(Trainee trainee) throws TrainingException {
        if(!trainees.remove(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public void removeTrainee(int index) throws TrainingException {
        try {
            trainees.remove(index);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public Trainee getTraineeByFirstName(String firstName) throws TrainingException {
        for(Trainee trainee : trainees) {
            if(trainee.getFirstName().equals(firstName)) {
                return trainee;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public Trainee getTraineeByFullName(String fullName) throws TrainingException {
        for(Trainee trainee : trainees) {
            if(trainee.getFullName().equals(fullName)) {
                return trainee;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public void sortTraineeListByFirstNameAscendant() {
        trainees.sort(Comparator.comparing(Trainee::getFirstName));
    }

    public void sortTraineeListByRatingDescendant() {
        trainees.sort((train1, train2) -> -(train1.getRating() - train2.getRating()));
    }

    public void reverseTraineeList() {
        Collections.reverse(trainees);
    }

    public void rotateTraineeList(int positions) {
        Collections.rotate(trainees, positions);
    }

    public List<Trainee> getTraineesWithMaxRating() throws TrainingException {
        if(trainees.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        List<Trainee> result = new ArrayList<>();
        for(int i = 5; i > 0; i--) {
            for(Trainee trainee : trainees) {
                if(trainee.getRating() == i) {
                    result.add(trainee);
                }
            }
            if(result.size() > 0) {
                return result;
            }
        }
        return null;
    }

    public boolean hasDuplicates() {
        return trainees.size() != new HashSet<>(trainees).size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return name.equals(group.name) &&
                room.equals(group.room) &&
                trainees.equals(group.trainees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, room, trainees);
    }
}
