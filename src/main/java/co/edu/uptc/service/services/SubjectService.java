package co.edu.uptc.service.services;

import java.util.List;

import co.edu.uptc.SimpleList;
import co.edu.uptc.service.models.Subject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectService {
    private  static List<Subject>  subjects;
    
    public SubjectService(){
       subjects =  initValues();
    }

    public void add(Subject subject){
        subjects.add(subject);
    }
    
    public void removeSubject(String code){
        for(Subject subject : subjects){
            if(subject.getCode().equals(code)){
                subjects.remove(subject);
                return;
            }
        }
    }

    public void refactorSubject(Subject refactorizedSubject) {
        for(Subject subject : subjects){
            if(subject.getCode().equals(refactorizedSubject.getCode())){
                subject.setName(refactorizedSubject.getName());
                subject.setCode(refactorizedSubject.getCode());
                return;
            }
        }
    }

    public List<Subject> usedSubjects(List<String> subjectUsed){
        List<Subject> usedSubjects = new SimpleList<>();
        for(Subject subject : subjects){
            for(String id : subjectUsed){
                if(subject.getCode().equals(id)){
                    usedSubjects.add(subject);
                }
            }
        }
        return usedSubjects;
    }

    public List<Subject> initValues(){
        List<Subject> auxList = new SimpleList<>();
        Subject auxSubject = new Subject();
        auxSubject.setName("Programacion 1");
        auxSubject.setCode("P1");
        auxList.add(auxSubject);
        auxSubject = new Subject();
        auxSubject.setName("Programacion 2");
        auxSubject.setCode("P2");
        auxList.add(auxSubject);
        auxSubject = new Subject();
        auxSubject.setName("Programacion 3");
        auxSubject.setCode("P3");
        auxList.add(auxSubject);
        auxSubject = new Subject();
        auxSubject.setName("Calculo 1");
        auxSubject.setCode("C1");
        auxList.add(auxSubject);
        auxSubject = new Subject();
        auxSubject.setName("Calculo 2");
        auxSubject.setCode("C2");
        auxList.add(auxSubject);
        return auxList;
    }

    public List<Subject> getSubjects(){
        return subjects;
    }

}
