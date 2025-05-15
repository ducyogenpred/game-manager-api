package com.firstgroup.gamemanagerapi.service;

import com.firstgroup.gamemanagerapi.exception.AlreadyExistsException;
import com.firstgroup.gamemanagerapi.exception.ResourceNotFoundException;
import com.firstgroup.gamemanagerapi.model.dto.ReviewDTO;
import com.firstgroup.gamemanagerapi.model.entity.Game;
import com.firstgroup.gamemanagerapi.model.entity.Review;
import com.firstgroup.gamemanagerapi.model.entity.User;
import com.firstgroup.gamemanagerapi.model.mapper.ReviewMapper;
import com.firstgroup.gamemanagerapi.model.request.ReviewRO;
import com.firstgroup.gamemanagerapi.model.request.ReviewPatchRO;
import com.firstgroup.gamemanagerapi.model.response.ErrorResponse;
import com.firstgroup.gamemanagerapi.repository.GameRepository;
import com.firstgroup.gamemanagerapi.repository.ReviewRepository;
import com.firstgroup.gamemanagerapi.repository.UserRepository;
import com.firstgroup.gamemanagerapi.util.MessageUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewService {

    public static final String REVIEWS = "Reviews";
    public static final String REVIEW = "Review";

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final GameRepository gameRepository;

    private final ReviewMapper reviewMapper;

    @Transactional
    public ReviewDTO save(ReviewRO ro) {
        if (reviewRepository.existsByUserIdAndGameId(ro.userId(), ro.gameId())) {
            List<ErrorResponse.FieldError> errors = List.of(
                    new ErrorResponse.FieldError("review", "User already reviewed this game.", ro.userId() + ":" + ro.gameId())
            );
            throw new AlreadyExistsException(REVIEW, errors);
        }

        User user = userRepository.findById(ro.userId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Game game = gameRepository.findById(ro.gameId())
                .orElseThrow(() -> new ResourceNotFoundException("Game not found"));

        Review entity = reviewMapper.toEntity(ro, user, game);
        Review saved = reviewRepository.save(entity);
        log.info(MessageUtils.saveSuccess(REVIEW));
        return reviewMapper.toDto(saved);
    }

    public List<ReviewDTO> getAll() {
        log.info(MessageUtils.retrieveSuccess(REVIEWS));
        return reviewRepository.findAll().stream()
                .map(reviewMapper::toDto)
                .collect(toList());
    }

    public ReviewDTO getById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with ID: " + id));

        log.info(MessageUtils.retrieveSuccess(REVIEW));
        return reviewMapper.toDto(review);
    }

    @Transactional
    public ReviewDTO update(Long id, ReviewRO ro) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with ID: " + id));

        reviewMapper.updateFromPutRo(ro, review);
        Review updated = reviewRepository.save(review);
        log.info(MessageUtils.updateSuccess(REVIEW));
        return reviewMapper.toDto(updated);
    }

    @Transactional
    public ReviewDTO patch(Long id, ReviewPatchRO ro) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with ID: " + id));

        reviewMapper.updateFromPatchRo(ro, review);
        Review updated = reviewRepository.save(review);
        log.info(MessageUtils.updateSuccess(REVIEW));
        return reviewMapper.toDto(updated);
    }

    @Transactional
    public void delete(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with ID: " + id));

        reviewRepository.delete(review);
        log.info(MessageUtils.deleteSuccess(REVIEW));
    }
}
