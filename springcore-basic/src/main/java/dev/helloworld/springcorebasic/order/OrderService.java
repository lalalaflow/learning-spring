package dev.helloworld.springcorebasic.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
