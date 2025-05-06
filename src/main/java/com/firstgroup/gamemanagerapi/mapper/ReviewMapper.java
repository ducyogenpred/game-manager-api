package com.firstgroup.gamemanagerapi.mapper;



import com.firstgroup.gamemanagerapi.dto.ReviewDTO;
import com.firstgroup.gamemanagerapi.entity.Review;
import com.firstgroup.gamemanagerapi.request.ReviewRO;
import org.mapstruct.Mapper;

public interface ReviewMapper {
    ReviewDTO toDto (Review review);
    Review toEntity (Review review);
    ReviewRO toRo (Review review);

}
