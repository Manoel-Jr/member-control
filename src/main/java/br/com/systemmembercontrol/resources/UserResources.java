package br.com.systemmembercontrol.resources;

import br.com.systemmembercontrol.model.dto.request.UserRequest;
import br.com.systemmembercontrol.model.dto.response.UserResponse;
import br.com.systemmembercontrol.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserResources {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest request){
        return  new ResponseEntity<>(userService.create(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> consult(@PathVariable Long id){
        return  new ResponseEntity<>(userService.consult(id), HttpStatus.OK);
    }
}
