package ss.bits.inventory.repository;

import ss.bits.inventory.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> {
}
