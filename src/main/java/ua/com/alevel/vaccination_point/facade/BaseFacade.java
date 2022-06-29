package ua.com.alevel.vaccination_point.facade;

import ua.com.alevel.vaccination_point.model.dto.request.RequestDto;
import ua.com.alevel.vaccination_point.model.dto.response.ResponseDto;

import java.util.List;

public interface BaseFacade<REQ extends RequestDto, RES extends ResponseDto> {

    void create(REQ req);

    void update(REQ req, Long id);

    void delete(Long id);

    RES findById(Long id);

    List<RES> findAll();

//    PageData<RES> findAll(WebRequest request);
}
