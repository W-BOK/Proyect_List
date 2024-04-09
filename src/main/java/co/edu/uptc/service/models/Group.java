package co.edu.uptc.service.models;


import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class Group {
    private String SubjectId;
    private String IdPlace;
    private Schedule[] schedules;

    public Group(){
        schedules = new Schedule[3];
    }
}
