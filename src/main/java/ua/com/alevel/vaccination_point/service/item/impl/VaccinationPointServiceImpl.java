package ua.com.alevel.vaccination_point.service.item.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.vaccination_point.dao.crud.CrudRepositoryHelper;
import ua.com.alevel.vaccination_point.dao.repository.item.NoteRepository;
import ua.com.alevel.vaccination_point.dao.repository.item.VaccinationPointRepository;
import ua.com.alevel.vaccination_point.dao.repository.user.DoctorRepository;
import ua.com.alevel.vaccination_point.model.entity.item.Note;
import ua.com.alevel.vaccination_point.model.entity.item.VaccinationPoint;
import ua.com.alevel.vaccination_point.model.entity.user.Doctor;
import ua.com.alevel.vaccination_point.service.item.VaccinationPointService;
import ua.com.alevel.vaccination_point.service.util.CascadeDelete;

import java.util.List;
import java.util.Optional;

@Service
public class VaccinationPointServiceImpl implements VaccinationPointService {

    private final VaccinationPointRepository vaccinationPointRepository;
    private final CrudRepositoryHelper<VaccinationPoint, VaccinationPointRepository> crudRepositoryHelperVaccinationPoint;
    private final NoteRepository noteRepository;
    private final CrudRepositoryHelper<Note, NoteRepository> crudRepositoryHelperNote;
    private final DoctorRepository doctorRepository;
    private final CrudRepositoryHelper<Doctor, DoctorRepository> crudRepositoryHelperDoctor;

    public VaccinationPointServiceImpl(VaccinationPointRepository vaccinationPointRepository,
                                       CrudRepositoryHelper<VaccinationPoint, VaccinationPointRepository> crudRepositoryHelperVaccinationPoint,
                                       NoteRepository noteRepository, CrudRepositoryHelper<Note, NoteRepository> crudRepositoryHelperNote, DoctorRepository doctorRepository, CrudRepositoryHelper<Doctor, DoctorRepository> crudRepositoryHelperDoctor) {
        this.vaccinationPointRepository = vaccinationPointRepository;
        this.crudRepositoryHelperVaccinationPoint = crudRepositoryHelperVaccinationPoint;
        this.noteRepository = noteRepository;
        this.crudRepositoryHelperNote = crudRepositoryHelperNote;
        this.doctorRepository = doctorRepository;
        this.crudRepositoryHelperDoctor = crudRepositoryHelperDoctor;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void create(VaccinationPoint entity) {
        crudRepositoryHelperVaccinationPoint.create(vaccinationPointRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void update(VaccinationPoint entity) {
        crudRepositoryHelperVaccinationPoint.update(vaccinationPointRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(Long id) {
        Optional<VaccinationPoint> vaccinationPoint = crudRepositoryHelperVaccinationPoint.findById(vaccinationPointRepository, id);
        if (vaccinationPoint.isPresent()) {
            CascadeDelete.deleteAllDoctorsAndNotesByVaccinationPoint(vaccinationPoint.get(),
                    crudRepositoryHelperNote,
                    noteRepository,
                    crudRepositoryHelperDoctor,
                    doctorRepository);
//            Set<Doctor> doctors = vaccinationPoint.get().getDoctors();
//            for (Doctor doctor : doctors) {
//                if (doctor.getRoleType().name().equals("ROLE_DOCTOR")) {
//                    doctorService.delete(doctor.getId());
//                }
//            }
            crudRepositoryHelperVaccinationPoint.delete(vaccinationPointRepository, id);
        } else {
            throw new RuntimeException("Запис для видалення відсутній");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<VaccinationPoint> findById(Long id) {
        return crudRepositoryHelperVaccinationPoint.findById(vaccinationPointRepository, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VaccinationPoint> findAll() {
        return crudRepositoryHelperVaccinationPoint.findAll(vaccinationPointRepository);
    }

    @Override
    public Optional<VaccinationPoint> findByIdAndVisible(Long id, boolean isVisible) {
        if (vaccinationPointRepository.existsById(id)) {
            return vaccinationPointRepository.findByIdAndVisible(id, isVisible);
        } else {
            throw new RuntimeException("Дана сутність не знайдена");
        }
    }

    @Override
    public List<VaccinationPoint> findAllByVisible(boolean isVisible) {
        return vaccinationPointRepository.findAllByVisible(isVisible);
    }
}
