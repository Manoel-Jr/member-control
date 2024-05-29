package br.com.systemmembercontrol.resources;

import br.com.systemmembercontrol.model.dto.request.ChristianRequest;
import br.com.systemmembercontrol.model.dto.request.ChristianUpdateRequest;
import br.com.systemmembercontrol.model.dto.response.ChristianResponse;
import br.com.systemmembercontrol.service.ChristianService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/christian")
@RestController
@RequiredArgsConstructor
public class ChristianResources {

    private final ChristianService service;

    @PostMapping
    public ResponseEntity<ChristianResponse> create(@RequestBody ChristianRequest request){
        return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
    }


    @GetMapping("/consult/{email}")
    public ResponseEntity<ChristianResponse> consultByEmail(@PathVariable String email){
        return new ResponseEntity<>(service.consultUsingEmail(email), HttpStatus.OK);
    }

    @PutMapping("/consult/{id}")
    public ResponseEntity<ChristianResponse> update(@PathVariable Long id, @RequestBody ChristianUpdateRequest request){
        return new ResponseEntity<>(service.update(id,request), HttpStatus.OK);
    }


    @GetMapping()
    public ResponseEntity<List<ChristianResponse>> listAll(){
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }


    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void changeStatus(@PathVariable Long id){
        service.changeStatus(id);
    }
}
