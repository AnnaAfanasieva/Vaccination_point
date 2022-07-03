package ua.com.alevel.vaccination_point.facade.item;

import ua.com.alevel.vaccination_point.facade.BaseFacade;
import ua.com.alevel.vaccination_point.model.dto.request.NoteRequestDto;
import ua.com.alevel.vaccination_point.model.dto.response.NoteResponseDto;
import ua.com.alevel.vaccination_point.model.entity.item.Vaccine;

import java.util.List;

public interface NoteFacade extends BaseFacade<NoteRequestDto, NoteResponseDto> {

    List<NoteResponseDto> findAllByVaccine (Vaccine vaccine);

    NoteResponseDto findByIdAndVisible(Long id, boolean isVisible);

    List<NoteResponseDto> findAllByVisible (boolean isVisible);
}
