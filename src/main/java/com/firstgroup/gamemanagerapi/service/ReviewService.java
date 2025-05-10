package com.firstgroup.gamemanagerapi.service;

import com.firstgroup.gamemanagerapi.dto.ReviewDTO;
import com.firstgroup.gamemanagerapi.dto.UserDTO;
import com.firstgroup.gamemanagerapi.entity.Publisher;
import com.firstgroup.gamemanagerapi.entity.Review;
import com.firstgroup.gamemanagerapi.mapper.UserMapper;
import com.firstgroup.gamemanagerapi.request.ReviewRO;
import com.firstgroup.gamemanagerapi.mapper.ReviewMapper;
import com.firstgroup.gamemanagerapi.repository.ReviewRepository;
import com.firstgroup.gamemanagerapi.request.UserPatchRO;
import com.firstgroup.gamemanagerapi.request.UserRO;
import com.firstgroup.gamemanagerapi.service.UserService;
import com.firstgroup.gamemanagerapi.entity.User;
import com.firstgroup.gamemanagerapi.mapper.userMapper;
import com.firstgroup.gamemanagerapi.repository.userRepository;
import com.firstgroup.gamemanagerapi.service.GameService;
import com.firstgroup.gamemanagerapi.dto.GameDTO;
import com.firstgroup.gamemanagerapi.mapper.GameMapper;
import com.firstgroup.gamemanagerapi.repository.GameRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
@RequiredArgsConstructor()
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserService userService;
    private final UserMapper userMapper;
    private final ReviewMapper reviewMapper;

    public ReviewDTO createReview(@Valid ReviewRO ro) {
        Review review = reviewMapper.toEntity(ro);

        return reviewMapper.toDto(reviewRepository.save(review));
    }

    public ReviewDTO getReviewById(long id) {
        return reviewMapper.toDto(reviewRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "This review does not exist")));
    }

    @Transactional
    public ReviewDTO patchReview(Long id, @Valid UserPatchRO ro) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "This review does not exist`"));

        if (ro.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No fields provided for update.");
        }

        reviewMapper.updateReviewFromPatchRo(ro, review);
        return reviewMapper.toDto(reviewRepository.save(review));
    }

    @Transactional
    public void deleteReview(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "This review does not exist."));
        reviewRepository.delete(review);
    }
}

}
