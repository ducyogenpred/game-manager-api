package com.firstgroup.gamemanagerapi.service;

import com.firstgroup.gamemanagerapi.exception.AlreadyExistsException;
import com.firstgroup.gamemanagerapi.exception.ResourceNotFoundException;
import com.firstgroup.gamemanagerapi.model.dto.UserGameDTO;
import com.firstgroup.gamemanagerapi.model.entity.UserGame;
import com.firstgroup.gamemanagerapi.model.mapper.UserGameMapper;
import com.firstgroup.gamemanagerapi.model.request.UserGameRO;
import com.firstgroup.gamemanagerapi.model.request.UserGamePatchRO;
import com.firstgroup.gamemanagerapi.model.response.ErrorResponse;
import com.firstgroup.gamemanagerapi.repository.UserGameRepository;
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
public class UserGameService {

    public static final String USER_GAMES = "UserGames";
    public static final String USER_GAME = "UserGame";

    private final UserGameRepository userGameRepository;
    private final UserGameMapper userGameMapper;

    @Transactional
    public UserGameDTO save(UserGameRO ro) {
        if (userGameRepository.existsByUserIdAndGameId(ro.userId(), ro.gameId())) {
            List<ErrorResponse.FieldError> errors = List.of(
                    new ErrorResponse.FieldError("userGame", "User already has this game.", ro.userId() + ":" + ro.gameId())
            );
            throw new AlreadyExistsException(USER_GAME, errors);
        }

        UserGame entity = userGameMapper.toEntity(ro);
        UserGame saved = userGameRepository.save(entity);
        log.info(MessageUtils.saveSuccess(USER_GAME));
        return userGameMapper.toDto(saved);
    }

    public List<UserGameDTO> getAll() {
        log.info(MessageUtils.retrieveSuccess(USER_GAMES));
        return userGameRepository.findAll().stream()
                .map(userGameMapper::toDto)
                .collect(toList());
    }

    public UserGameDTO getById(Long id) {
        UserGame userGame = userGameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserGame not found with ID: " + id));

        log.info(MessageUtils.retrieveSuccess(USER_GAME));
        return userGameMapper.toDto(userGame);
    }

    @Transactional
    public UserGameDTO update(Long id, UserGameRO ro) {
        UserGame userGame = userGameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserGame not found with ID: " + id));

        userGameMapper.updateFromPutRo(ro, userGame);
        UserGame updated = userGameRepository.save(userGame);
        log.info(MessageUtils.updateSuccess(USER_GAME));
        return userGameMapper.toDto(updated);
    }

    @Transactional
    public UserGameDTO patch(Long id, UserGamePatchRO ro) {
        UserGame userGame = userGameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserGame not found with ID: " + id));

        userGameMapper.updateFromPatchRo(ro, userGame);
        UserGame updated = userGameRepository.save(userGame);
        log.info(MessageUtils.updateSuccess(USER_GAME));
        return userGameMapper.toDto(updated);
    }

    @Transactional
    public void delete(Long id) {
        UserGame userGame = userGameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserGame not found with ID: " + id));

        userGameRepository.delete(userGame);
        log.info(MessageUtils.deleteSuccess(USER_GAME));
    }
}
