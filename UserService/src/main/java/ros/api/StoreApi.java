package ros.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ros.dtos.StoreDto;
import ros.services.StoreService;

import java.util.List;

@RequestMapping("/Store")
@RestController
@RequiredArgsConstructor
public class StoreApi {

    @Autowired
    private StoreService storeService;

    @PostMapping("/Get/{id}")
    public ResponseEntity<StoreDto> Get(@PathVariable Long id){
        StoreDto storeDto = null;
        try {
            storeDto = storeService.findById(id);
            return ResponseEntity.ok(storeDto);
        } catch (Exception e) {
            e.printStackTrace();
            return (ResponseEntity<StoreDto>) ResponseEntity.badRequest();
        }
    }

    @PostMapping("/Add")
    public ResponseEntity<Boolean> Add(@RequestBody StoreDto storeDto){
        try {
            storeDto = storeService.Add(storeDto);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            e.printStackTrace();
            return (ResponseEntity<Boolean>) ResponseEntity.badRequest();
        }
    }

    @PostMapping("/Delete/{id}")
    public ResponseEntity<Boolean> Delete(@PathVariable Long id){
        try {
            storeService.findById(id);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            e.printStackTrace();
            return (ResponseEntity<Boolean>) ResponseEntity.badRequest();
        }
    }

    @PostMapping("/Update")
    public ResponseEntity<Boolean> Update(@RequestBody StoreDto storeDto){
        try {
            storeService.Update(storeDto);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            e.printStackTrace();
            return (ResponseEntity<Boolean>) ResponseEntity.badRequest();
        }
    }

    @PostMapping("/GetList/{id}")
    public ResponseEntity<List<StoreDto>> GetList(@PathVariable Long id){
        List<StoreDto> storeDto = null;
        try {
            storeDto = storeService.findAll(id);
            return ResponseEntity.ok(storeDto);
        } catch (Exception e) {
            e.printStackTrace();
            return (ResponseEntity<List<StoreDto>>) ResponseEntity.badRequest();
        }
    }

}
