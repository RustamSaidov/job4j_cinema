//package ru.job4j.dreamjob.repository;
//
//
//import net.jcip.annotations.ThreadSafe;
//import org.springframework.stereotype.Repository;
//import ru.job4j.dreamjob.model.Candidate;
//
//import java.time.LocalDateTime;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;
//
//@ThreadSafe
//@Repository
//public class MemoryCandidateRepository implements CandidateRepository {
//
//    private int nextId = 1;
//
//    private final Map<Integer, Candidate> candidates = new HashMap<>();
//
//    public MemoryCandidateRepository() {
//        save(new Candidate(0, "John", "junior java developer", LocalDateTime.now(), true, 1, 0));
//        save(new Candidate(0, "Phil", "middle java developer", LocalDateTime.now(), true, 1, 0));
//        save(new Candidate(0, "Tony", "junior java developer", LocalDateTime.now(), true, 1, 0));
//        save(new Candidate(0, "Mike", "middle java developer", LocalDateTime.now(), true, 1, 0));
//        save(new Candidate(0, "Chris", "junior java developer", LocalDateTime.now(), true, 1, 0));
//        save(new Candidate(0, "John", "middle java developer", LocalDateTime.now(), true, 1, 0));
//    }
//
//    @Override
//    public Candidate save(Candidate candidate) {
//        candidate.setId(nextId++);
//        candidates.put(candidate.getId(), candidate);
//        return candidate;
//    }
//
//    @Override
//    public boolean deleteById(int id) {
//        return candidates.remove(id) != null;
//    }
//
//    @Override
//    public boolean update(Candidate candidate) {
//        return candidates.computeIfPresent(candidate.getId(), (id, oldCandidate) -> {
//            return new Candidate(oldCandidate.getId(), candidate.getName(), candidate.getDescription(),
//                    candidate.getCreationDate(), candidate.getVisible(), candidate.getCityId(), candidate.getFileId());
//        }) != null;
//    }
//
//    @Override
//    public Optional<Candidate> findById(int id) {
//        return Optional.ofNullable(candidates.get(id));
//    }
//
//    @Override
//    public Collection<Candidate> findAll() {
//        return candidates.values();
//    }
//}
