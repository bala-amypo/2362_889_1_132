@Entity
public class SkillCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "skillCategory", cascade = CascadeType.ALL)
    private List<SkillRequest> skillRequests;
}
