package co.edu.uptc.service.dtos;

import co.edu.uptc.service.exeptions.ProjectExeption;
import co.edu.uptc.service.exeptions.TypeMessage;
import co.edu.uptc.service.models.Subject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter 
public class SubjectDto {
    private String name;
    private String code;

    public static Subject fromSubject(SubjectDto subject){
        Subject dto = new Subject();
        dto.setCode(subject.getCode());
        dto.setName(subject.getName());
        return dto;
    }

    public static void validaSubject(SubjectDto subjectDto) throws ProjectExeption { 
        if (subjectDto.getName() == null || 
        subjectDto.getCode() == null) {
            throw new ProjectExeption(TypeMessage.INFORMATION_INCOMPLETE);
        } 
    }
}
