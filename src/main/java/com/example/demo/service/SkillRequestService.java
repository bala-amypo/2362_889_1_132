public interface SkillRequestService {

    SkillRequest createRequest(SkillRequest request);

    SkillRequest getRequestById(long id);

    List<SkillRequest> getAllRequests();

    SkillRequest updateRequest(long id, SkillRequest request);

    void deleteRequest(long id);
}
