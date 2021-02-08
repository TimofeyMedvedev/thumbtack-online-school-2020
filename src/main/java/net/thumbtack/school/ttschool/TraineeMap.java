package net.thumbtack.school.ttschool;

import java.util.*;

public class TraineeMap {
    private Map<Trainee, String> map;

    public TraineeMap() {
        map = new HashMap<>();
    }

    public void addTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        if(map.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
        }
        map.put(trainee, institute);
    }

    public void replaceTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        if(!map.replace(trainee, map.get(trainee), institute)) {
            throw  new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public void removeTraineeInfo(Trainee trainee) throws TrainingException {
        if(!map.remove(trainee, map.get(trainee))) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public int getTraineesCount() {
        return map.size();
    }

    public String getInstituteByTrainee(Trainee trainee) throws TrainingException {
        String institute = map.get(trainee);
        if(institute == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        return institute;
    }

    public Set<Trainee> getAllTrainees() {
        return map.keySet();
    }

    public Set<String> getAllInstitutes() {
        return new HashSet<>(map.values());
    }

    public boolean isAnyFromInstitute(String institute) {
        return map.containsValue(institute);
    }
}
