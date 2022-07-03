package ua.com.alevel.vaccination_point.service.item;

import ua.com.alevel.vaccination_point.model.entity.item.Note;
import ua.com.alevel.vaccination_point.model.entity.item.Vaccine;
import ua.com.alevel.vaccination_point.service.BaseService;

import java.util.List;
import java.util.Optional;

public interface NoteService extends BaseService<Note> {

    List<Note> findAllByVaccine (Vaccine vaccine);

    Optional<Note> findByIdAndVisible(Long id, boolean isVisible);

    List<Note> findAllByVisible (boolean isVisible);

//    DataTableResponse<Record> findAllByVaccinationPoint(DataTableRequest request, VaccinationPoint vaccinationPoint);
//
//    DataTableResponse<Record> findAllByDoctor(DataTableRequest request, Doctor doctor);
//
//    DataTableResponse<RecordDeleted> findAllDeleted(DataTableRequest request);

}
