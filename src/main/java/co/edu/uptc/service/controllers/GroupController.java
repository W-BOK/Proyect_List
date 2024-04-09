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

import co.edu.uptc.service.dtos.GroupDto;
import co.edu.uptc.service.exeptions.ProjectExeption;
import co.edu.uptc.service.models.Group;
import co.edu.uptc.service.services.GroupService;



@RestController
@RequestMapping("/${groupMapp}")
public class GroupController {
    GroupService groupService = new GroupService();

    @GetMapping()
    public ResponseEntity<Object> getGroups() {
        return ResponseEntity.status(HttpStatus.OK).body(groupService.getGroups());
    }
    
    @PostMapping()
    public ResponseEntity<Object> addGroup(@RequestBody GroupDto groupDto){
        try {
        GroupDto.validaGroup(groupDto);
        Group group = GroupDto.fromGroup(groupDto);
        groupService.add(group);
        return ResponseEntity.status(HttpStatus.OK).body(group);
        } catch (ProjectExeption e) {
            return ResponseEntity.status(e.getMenssage().getCodeHttp()).body(e.getMenssage());
        }
    }
    
    @DeleteMapping("/${deleteMapp}")
    public ResponseEntity<Object> deleteGroup(@PathVariable String subjectId) {
            groupService.removeGroup(subjectId);
            return ResponseEntity.status(HttpStatus.OK).body(groupService.getGroups());
    }

    @PutMapping("/${modifyMapp}")
    public ResponseEntity<Object> modifyGroup(@RequestBody GroupDto groupDto){
        Group group = GroupDto.fromGroup(groupDto);
        groupService.refactorizedGruoup(group);
        return ResponseEntity.status(HttpStatus.OK).body(group);
    }

    
    
}
