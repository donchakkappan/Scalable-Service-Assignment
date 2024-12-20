package ss.bits.inventory.api;

import ss.bits.inventory.dto.ItemDTO;
import ss.bits.inventory.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public ItemDTO saveItem(@RequestBody ItemDTO item){
        return this.itemService.addNewItem(item);
    }

    @GetMapping("/{code:\\d+}")
    public ItemDTO getItem(@PathVariable Integer code){
        return this.itemService.getItem(code);
    }
}
