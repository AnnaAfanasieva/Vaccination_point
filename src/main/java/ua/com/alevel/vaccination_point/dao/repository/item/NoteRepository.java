package ua.com.alevel.vaccination_point.dao.repository.item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.com.alevel.vaccination_point.dao.repository.BaseRepository;
import ua.com.alevel.vaccination_point.model.entity.item.Note;
import ua.com.alevel.vaccination_point.model.entity.item.Vaccine;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends BaseRepository<Note> {

    List<Note> findAllByVaccine (Vaccine vaccine);

    Optional<Note> findByIdAndVisible(Long id, boolean isVisible);

    List<Note> findAllByVisible (boolean isVisible);

//    @Query("select r from Record r join Doctor d on r.doctor = d where d.vaccinationPoint = :vaccinationPoint")
//    Page<Record> findAllByVaccinationPoint(@Param("vaccinationPoint") VaccinationPoint vaccinationPoint, Pageable pageable);
//
//    Page<Record> findAllByDoctor(Doctor doctor, Pageable pageable);
//
//    @Query("select rt from RecordTime rt where rt not in (select r.recordTime from Record r where r.doctor = :doctor and r.vaccineDate = :vaccineDate)")
//    List<RecordTime> findAllRecordTimesByDoctorAndVaccineDate(@Param("doctor") Doctor doctor, @Param("vaccineDate") Date vaccineDate);
//
//    void deleteAllByDoctorId(Long doctorId);
//
//    @Query("select r from Record r order by r.id desc")
//    List<Record> findAllRecordsBeforeInsert();
}
