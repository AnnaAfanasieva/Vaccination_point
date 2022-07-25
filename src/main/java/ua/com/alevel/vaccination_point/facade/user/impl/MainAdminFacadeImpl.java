package ua.com.alevel.vaccination_point.facade.user.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.vaccination_point.facade.user.MainAdminFacade;
import ua.com.alevel.vaccination_point.facade.util.ConvertRequestDtoToEntity;
import ua.com.alevel.vaccination_point.model.dto.request.MainAdminRequestDto;
import ua.com.alevel.vaccination_point.model.dto.response.MainAdminResponseDto;
import ua.com.alevel.vaccination_point.model.entity.user.MainAdmin;
import ua.com.alevel.vaccination_point.service.user.MainAdminService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MainAdminFacadeImpl implements MainAdminFacade {

    private final MainAdminService mainAdminService;

    public MainAdminFacadeImpl(MainAdminService mainAdminService) {
        this.mainAdminService = mainAdminService;
    }

    @Override
    public void create(MainAdminRequestDto mainAdminRequestDto) {
        MainAdmin mainAdmin = ConvertRequestDtoToEntity.createMainAdminEntity(mainAdminRequestDto, new MainAdmin());
        mainAdminService.create(mainAdmin);
    }

    @Override
    public void update(MainAdminRequestDto mainAdminRequestDto, Long id) {
        Optional<MainAdmin> optionalMainAdmin = mainAdminService.findById(id);
        if (optionalMainAdmin.isPresent()) {
            MainAdmin mainAdmin = optionalMainAdmin.get();
            mainAdmin.setUpdated(new Timestamp(System.currentTimeMillis()));
            ConvertRequestDtoToEntity.createMainAdminEntity(mainAdminRequestDto, mainAdmin);
            mainAdminService.update(mainAdmin);
        } else {
            throw new RuntimeException("Запис відсутній");
        }
    }

    @Override
    public void delete(Long id) {
        mainAdminService.delete(id);
    }

    @Override
    public MainAdminResponseDto findById(Long id) {
        return new MainAdminResponseDto(mainAdminService.findById(id).get());
    }

    @Override
    public List<MainAdminResponseDto> findAll() {
        List<MainAdminResponseDto> dtoList = new ArrayList<>();
        for (MainAdmin mainAdmin : mainAdminService.findAll()) {
            dtoList.add(new MainAdminResponseDto(mainAdmin));
        }
        return dtoList;
    }
}
