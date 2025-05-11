package com.firstgroup.gamemanagerapi.model.mapper;

import com.firstgroup.gamemanagerapi.model.dto.ReviewDTO;
import com.firstgroup.gamemanagerapi.model.entity.Review;
import com.firstgroup.gamemanagerapi.model.request.ReviewPatchRO;
import com.firstgroup.gamemanagerapi.model.request.ReviewRO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewDTO toDto (Review entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Review toEntity (ReviewRO ro);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateFromReviewPatchRO(ReviewPatchRO ro, @MappingTarget Review entity);
}
