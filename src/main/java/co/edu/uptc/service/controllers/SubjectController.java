package co.edu.uptc.service.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.service.dtos.SubjectDto;
import co.edu.uptc.service.exeptions.ProjectExeption;
import co.edu.uptc.service.models.Subject;
import co.edu.uptc.service.services.GroupService;
import co.edu.uptc.service.services.SubjectService;



@RestController
@RequestMapping("/${subjectMapp}")
public class SubjectController {
    SubjectService subjectService = new SubjectService();

    @GetMapping()
    public ResponseEntity<Object> getSubjects() {
        return ResponseEntity.status(HttpStatus.OK).body(subjectService.getSubjects());
    }

    @PostMapping()
    public ResponseEntity<Object> addSubject(@RequestBody SubjectDto subjectDto) {
        try {
        SubjectDto.validaSubject(subjectDto);
        subjectService.add(SubjectDto.fromSubject(subjectDto));
        return ResponseEntity.status(HttpStatus.OK).body(subjectService.getSubjects());
        } catch (ProjectExeption e) {
            return ResponseEntity.status(e.getMenssage().getCodeHttp()).body(e.getMenssage());
        }
    }
    
    @DeleteMapping("/${deleteSubjectMapp}")
    public ResponseEntity<Object> deleteSubject(@PathVariable String code) {
        subjectService.removeSubject(code);
        return ResponseEntity.status(HttpStatus.OK).body(subjectService.getSubjects());
    }
    
    
    @PutMapping("/${modifyMapp}")
    public ResponseEntity<Object> modifyGroup(@RequestBody SubjectDto subjectDto){
        Subject subject = SubjectDto.fromSubject(subjectDto);
        subjectService.refactorSubject(subject);
        return ResponseEntity.status(HttpStatus.OK).body(subject);
    }

    @GetMapping("/${repetMapp}")
    public ResponseEntity<Object> getRepted() {
        return ResponseEntity.status(HttpStatus.OK).body(subjectService.usedSubjects(GroupService.SubjectsWithMoreThanOneGroup()));
    }

    @GetMapping("/${placeSubjectMapp}")
    public ResponseEntity<Object> getSubjectPlaces() {
        return ResponseEntity.status(HttpStatus.OK).body(subjectService.usedSubjects(GroupService.SubjectWithPlace()));
    }

    @GetMapping("/${scheduleMapp}")
    public ResponseEntity<Object> getSubjectShoulser() {
        return ResponseEntity.status(HttpStatus.OK).body(subjectService.usedSubjects(GroupService.SubjectsWithSchedule()));
    }
}
