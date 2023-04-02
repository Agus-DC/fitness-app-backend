package com.appconsultorio.appconsultorio.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "Turns")
public class Turn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turn")
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "status")
    private String status;

    @Column(name = "id_to_reprog_turn")
    private Integer idToReprogTurn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name = "turns_professionals",
            joinColumns = @JoinColumn(name = "id_turn"),
            inverseJoinColumns = @JoinColumn(name = "id_professional")
            
    )
    private Set<Professional> professionalset;

    /*
    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id_client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id_client")
    private Professional professional;
*/
}
