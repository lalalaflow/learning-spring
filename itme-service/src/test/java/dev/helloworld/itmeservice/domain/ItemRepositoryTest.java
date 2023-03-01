package dev.helloworld.itmeservice.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Item item = new Item("itemA", 10000, 10);
        //when
        Item savedItem = itemRepository.save(item);
        //then
        Item findItem = itemRepository.findById(savedItem.getId());
        Assertions.assertEquals(savedItem, findItem);
    }


    @Test
    void findAll() {

        //given
        Item item1 = new Item("itemA", 10000, 10);
        Item item2 = new Item("itemB", 20000, 10);

        itemRepository.save(item1);
        itemRepository.save(item2);

        //when
        List<Item> items = itemRepository.findAll();

        //then
        assertEquals(2, items.size());

    }

    @Test
    void update() {
        //given
        Item item = new Item("item1", 10000, 10);

        Item savedItem = itemRepository.save(item);
        Long itemId = savedItem.getId();

        //when
        Item updatedParam = new Item("item2", 20000, 30);
        itemRepository.update(itemId, updatedParam);

        //then
        Item findItem = itemRepository.findById(itemId);
        assertEquals(updatedParam.getItemName(), findItem.getItemName());
        assertEquals(updatedParam.getPrice(), findItem.getPrice());
        assertEquals(updatedParam.getQuantity(), findItem.getQuantity());


    }

    @Test
    void clearStore() {
    }
}