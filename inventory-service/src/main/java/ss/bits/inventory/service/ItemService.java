package ss.bits.inventory.service;

import ss.bits.inventory.dto.ItemDTO;

public interface ItemService {
    public ItemDTO addNewItem(ItemDTO item);

    ItemDTO getItem(Integer code);
}
