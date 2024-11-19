package ss.bits.inventory.service.impl;

import ss.bits.inventory.dto.ItemDTO;
import ss.bits.inventory.entity.Item;
import ss.bits.inventory.repository.ItemRepository;
import ss.bits.inventory.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ItemDTO addNewItem(ItemDTO item) {
        Item entity = this.itemRepository.save(new Item( item.getDescription(), item.getQty()));
        return new ItemDTO(entity.getCode(), entity.getDescription(), entity.getQty());
    }

    @Override
    public ItemDTO getItem(Integer code) {
        return this.itemRepository.findById(code).map(entity -> new ItemDTO(entity.getCode(), entity.getDescription(), entity.getQty()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
