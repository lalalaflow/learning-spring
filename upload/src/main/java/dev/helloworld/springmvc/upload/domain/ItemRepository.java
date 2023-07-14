package dev.helloworld.springmvc.upload.domain;

import com.fasterxml.jackson.core.ObjectCodec;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ItemRepository {

    private final Map<Long, Item> store = new HashMap<>();
    private long sequence = 0L;


    public Item saveItem(Item item) {
        item.setId(++sequence);
        store.put(sequence,item);
        return item;
    }

    public Item findItem(Long id) {
        return store.get(id);
    }

}
