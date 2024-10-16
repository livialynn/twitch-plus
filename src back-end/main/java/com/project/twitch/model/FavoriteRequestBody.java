package com.project.twitch.model;

import com.project.twitch.db.entity.ItemEntity;

public record FavoriteRequestBody(
        //Create the model class for the favorite item request
        ItemEntity favorite
) {}
