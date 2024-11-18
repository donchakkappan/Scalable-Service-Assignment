package ss.bits.assignment.service;

import ss.bits.assignment.dto.CartItemDTO;

public interface CartService {
    public void addItemToCard(CartItemDTO cartItem);
    public void removeItemFromCard(Integer itemCode, String username);
}
