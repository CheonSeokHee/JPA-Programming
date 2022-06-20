package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
//중요 --> 그래야 JPA 관리하겠다고 인식하는 구조
public class Member {

    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String username;

    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team team;
    //멤버입장에선 Many team은 하나

//    @Column(name="TEAM_ID")
//    private Long teamId;


    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public Long getTeamId() {
//        return teamId;
//    }
//
//    public void setTeamId(Long teamId) {
//        this.teamId = teamId;
//    }

}

