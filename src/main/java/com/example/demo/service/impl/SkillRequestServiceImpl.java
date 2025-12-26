@Service
public class SkillRequestServiceImpl implements SkillRequestService {

    private final Map<Long, SkillRequest> store = new HashMap<>();
    private long counter = 1;

    @Override
    public SkillRequest create(SkillRequest request) {
        request.setId(counter++);
        store.put(request.getId(), request);
        return request;
    }

    @Override
    public SkillRequest getRequestById(long id) {
        return store.get(id);
    }
}
