package br.com.systemmembercontrol.resources;

import br.com.systemmembercontrol.model.dto.request.MemberRequest;
import br.com.systemmembercontrol.model.dto.request.MemberUpdateRequest;
import br.com.systemmembercontrol.model.dto.response.MemberResponse;
import br.com.systemmembercontrol.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberResources {

    private final MemberService memberService;

    @PostMapping(value = "/create")
    public ResponseEntity<MemberResponse> create(@RequestBody MemberRequest request){
        return new ResponseEntity<>(memberService.create(request), HttpStatus.CREATED);
    }

    @GetMapping("/consult/{id}")
    public ResponseEntity<MemberResponse> consult(@PathVariable Long id){
        return new ResponseEntity<>(memberService.consult(id),HttpStatus.OK);
    }

    @GetMapping("/consult-for-email/{email}")
    public ResponseEntity<MemberResponse> consultByEmail(@PathVariable String email){
        return new ResponseEntity<>(memberService.consultForEmail(email),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MemberResponse>> listAll(){
        return new ResponseEntity<>(memberService.listAll(),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MemberResponse> update(@RequestBody MemberUpdateRequest request, @PathVariable Long id){
        return new ResponseEntity<>(memberService.update(id,request),HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        memberService.delete(id);
    }
}
