package com.webapp.Service;


import com.webapp.dao.ItemDao;
import com.webapp.model.ItemsandPrices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemsandPricesService {

    @Autowired
    ItemDao itemDao;

    public void saveItem(ItemsandPrices item) {
        itemDao.persist(item);
    }

    public List<ItemsandPrices> getListofItemsandPrices() {
        return itemDao.listofItems();
    }


    public void update(Long id, ItemsandPrices st) {
        ItemsandPrices stEntity = itemDao.getItemById(id);
        if (stEntity != null) {
            stEntity.setItem(st.getItem());
            stEntity.setPrice(st.getPrice());
            itemDao.updateItem(stEntity);
        }
    }

    public void delete(Long id) {
        ItemsandPrices stEntity = itemDao.getItemById(id);
        if (stEntity != null) {
            itemDao.delete(stEntity);
        }
    }
    public ItemsandPrices getItemById(Long id){
       return itemDao.getItemById(id);
    }
}

