package com.webapp.dao;

import com.webapp.model.ItemsandPrices;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDao extends AbstractDao<Long, ItemsandPrices>{


    public Long saveStudent(ItemsandPrices st) {
        persist(st);
        return st.getId();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<ItemsandPrices> listofItems() {
        Criteria criteria = createEntityCriteria();
        return (List) criteria.list();
    }


    public void updateItem(ItemsandPrices st) {
        update(st);
    }


    public void deleteItem(ItemsandPrices st) {
        delete(st);
    }
    public ItemsandPrices getItemById(Long id) {
        return getByKey(id);
    }
}
