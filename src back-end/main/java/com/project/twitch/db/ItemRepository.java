package com.project.twitch.db;

import com.project.twitch.db.entity.ItemEntity;
import org.springframework.data.repository.ListCrudRepository;


public interface ItemRepository extends ListCrudRepository <ItemEntity, Long> {
    ItemEntity findByTwitchId(String twitchId);

}
