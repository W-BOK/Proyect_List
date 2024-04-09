package co.edu.uptc.service.services;

import java.util.List;

import co.edu.uptc.SimpleList;
import co.edu.uptc.service.models.Group;
import co.edu.uptc.service.models.Schedule;
import co.edu.uptc.service.utils.Days;
import co.edu.uptc.service.utils.Hours;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupService {
    private static List<Group> groups;
    
    public GroupService(){
        groups = initValues();
    }

    public List<Group> initValues(){
        List<Group> auxList = new SimpleList<>();
        Group auxGroup = new Group();
        auxGroup.setSubjectId("P1");
        auxGroup.setSchedules(
            new Schedule[]{
                new Schedule(Days.MONDAY, Hours.EIGHT_TEN),
                new Schedule(Days.TUESDAY, Hours.TEN_TWELVE),
                new Schedule(Days.WEDNESDAY, Hours.SIX_EIGHT)
            }
        );
        auxGroup.setIdPlace("C");
        auxList.add(auxGroup);
        auxGroup = new Group();
        auxGroup.setSubjectId("P2");
        auxGroup.setSchedules(
            new Schedule[]{
                new Schedule(Days.THURSDAY, Hours.FOUR_SIX),
                new Schedule(Days.WEDNESDAY, Hours.FOUR_SIX),
                new Schedule(Days.FRIDAY, Hours.TEN_TWELVE)
            }
        );
        auxGroup.setIdPlace("V");
        auxList.add(auxGroup);
        auxGroup = new Group();
        auxGroup.setSubjectId("P3");
        auxGroup.setSchedules(
            new Schedule[]{
                new Schedule(Days.MONDAY, Hours.SIX_EIGHT),
                new Schedule(Days.TUESDAY, Hours.TWELVE_TWO),
                new Schedule(Days.WEDNESDAY, Hours.EIGHT_TEN)
            }
        );
        auxGroup.setIdPlace("C");
        auxList.add(auxGroup);
        auxGroup = new Group();
        auxGroup.setSubjectId("P3");
        auxGroup.setSchedules(
            new Schedule[]{
                new Schedule(Days.MONDAY, Hours.SIX_EIGHT),
                new Schedule(Days.TUESDAY, Hours.TWELVE_TWO),
                new Schedule(Days.WEDNESDAY, Hours.EIGHT_TEN)
            }
        );
        auxGroup.setIdPlace("C");
        auxList.add(auxGroup);

        auxGroup = new Group();
        auxGroup.setSubjectId("P2");
        auxGroup.setSchedules(
            new Schedule[]{
                new Schedule(Days.THURSDAY, Hours.FOUR_SIX),
                new Schedule(Days.WEDNESDAY, Hours.FOUR_SIX),
                new Schedule(Days.FRIDAY, Hours.TEN_TWELVE)
            }
        );
        auxGroup.setIdPlace("V");
        auxList.add(auxGroup);
        
        return auxList;
    }

    public void add (Group group){
        groups.add(group);
    }

    public void removeGroup(String id){
        for(Group group : groups){
            if(group.getSubjectId().equals(id)){
                groups.remove(group);
                return;
            }
        }
    }

    public void refactorizedGruoup(Group refactorizedGroup){
        for(Group group : groups){
            if(group.getIdPlace() == (refactorizedGroup.getIdPlace())){
                group.setSubjectId(refactorizedGroup.getSubjectId());
                group.setSchedules(refactorizedGroup.getSchedules());
                return;
            }
        }
    }

    public static List<String> SubjectsWithMoreThanOneGroup(){
        List<String> auxList = new SimpleList<String>();
        for(Group group : groups){
            auxList.add(group.getSubjectId());
        }
        return Repeted(auxList);
    }

    public static List<String> Repeted(List<String> auxList){
        List<String> list = new SimpleList<String>();
        for(String first: auxList){
            int counter = 0;
            for(String second: auxList){    
                if(first.equals(second)){
                    counter++;
                }
            }
            if(counter>1){
                if(!list.contains(first)){
                    list.add(first);
                }
            }
        }
        return list;
    }

    public static List<String> SubjectWithPlace(){
        List<String> auxList = new SimpleList<>();
        for(Group group : groups){
            auxList.add(group.getIdPlace()+","+group.getSubjectId());
        }
        auxList = Repeted(auxList);
        List<String> auxiliaryList = new SimpleList<>();
        for(String aux : auxList){
            String[] parts = aux.split(",");
            auxiliaryList.add(parts[1]);
        }
        return auxiliaryList;
    }

    public static List<String> SubjectsWithSchedule(){
        List<String> auxList = new SimpleList<String>();
        for(Group group : groups){
            auxList.add(group.getSubjectId() + 
            "," + group.getSchedules()[0].getDay() + 
            "," + group.getSchedules()[0].getHour() +
            "," + group.getSchedules()[1].getDay() +
            "," + group.getSchedules()[1].getHour() +
            "," + group.getSchedules()[2].getDay() +
            "," + group.getSchedules()[2].getHour());
        }
        auxList = Repeted(auxList);    
        List<String> auxiliaryList = new SimpleList<>();
        for(String aux : auxList){
            String[] parts = aux.split(",");
            auxiliaryList.add(parts[0]);
        }

        return auxiliaryList;
    }
    public List<Group> getGroups(){
        return groups;
    }
}

