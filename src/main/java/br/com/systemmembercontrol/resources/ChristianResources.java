package br.com.systemmembercontrol.resources;

import br.com.systemmembercontrol.model.dto.request.ChristianRequest;
import br.com.systemmembercontrol.model.dto.response.ChristianResponse;
import br.com.systemmembercontrol.service.ChristianService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ChristianResponse> consult(@PathVariable String email){
        return new ResponseEntity<>(service.consultUsingEmail(email), HttpStatus.OK);
    }
}
