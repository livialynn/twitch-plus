package com.project.twitch.recommendation;

import com.project.twitch.db.entity.UserEntity;
import com.project.twitch.model.TypeGroupedItemList;
import com.project.twitch.user.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RecommendationController {

    private final RecommendationService recommendationService;
    private final UserService userService;
  

    public RecommendationController(
            RecommendationService recommendationService,
            UserService userService
    ) {
        this.recommendationService = recommendationService;
        this.userService = userService;
    }
  

    @GetMapping("/recommendation")
    public TypeGroupedItemList getRecommendation(@AuthenticationPrincipal User user) {
        UserEntity userEntity = null; 
        if (user != null) { 
            userEntity = userService.findByUsername(user.getUsername());
        }
        return recommendationService.recommendItems(userEntity);
        
    }
}
