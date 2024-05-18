package br.com.systemmembercontrol.resources;

import br.com.systemmembercontrol.model.dto.request.CongregatedRequest;
import br.com.systemmembercontrol.model.dto.request.CongregatedUpdateRequest;
import br.com.systemmembercontrol.model.dto.response.CongregatedResponse;
import br.com.systemmembercontrol.service.CongregatedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/congregated")
@RequiredArgsConstructor
public class CongregatedResources {

    private final CongregatedService service;

    @PostMapping("/create")
    public ResponseEntity<CongregatedResponse> create(@RequestBody CongregatedRequest request){
        return  new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
    }

    @GetMapping("/consult")
    public ResponseEntity<CongregatedResponse> consultByEmail(@PathVariable String email){
        return new ResponseEntity<>(service.consultForEmail(email),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CongregatedResponse> update(@PathVariable Long id, @RequestBody CongregatedUpdateRequest request){
        return new ResponseEntity<>(service.update(id,request),HttpStatus.OK);
    }
}
