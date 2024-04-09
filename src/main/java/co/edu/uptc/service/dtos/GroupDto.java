package co.edu.uptc.service.dtos;

import co.edu.uptc.service.exeptions.ProjectExeption;
import co.edu.uptc.service.exeptions.TypeMessage;
import co.edu.uptc.service.models.Group;
import co.edu.uptc.service.models.Schedule;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class GroupDto {
    private String SubjectId;
    private String IdPlace;
    private Schedule[] schedules;

    public static Group fromGroup(GroupDto group){
        Group auxGroup = new Group();
        auxGroup.setIdPlace(group.getIdPlace());
        auxGroup.setSubjectId(group.getSubjectId());
        auxGroup.setSchedules(group.getSchedules());
        return auxGroup;
    }

    public static void validaGroup(GroupDto groupDto) throws ProjectExeption { 
        if (groupDto.getSubjectId() == null || 
        groupDto.getIdPlace() == null ||
        groupDto.getSchedules() == null) {
            throw new ProjectExeption(TypeMessage.INFORMATION_INCOMPLETE);
        } 
    }
    
}
