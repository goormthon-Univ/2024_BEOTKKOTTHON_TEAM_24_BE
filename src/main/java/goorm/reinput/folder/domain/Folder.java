package goorm.reinput.folder.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import goorm.reinput.global.domain.BaseTimeEntity;
import goorm.reinput.insight.domain.Insight;
import goorm.reinput.user.domain.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Entity
@Setter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class Folder extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long folderId;
    private String folderName;
    @Enumerated(EnumType.STRING)
    private FolderColor folderColor;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    @JsonManagedReference
    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Insight> insightList;
    @Builder
    public Folder(String folderName, FolderColor folderColor, User user) {
        this.folderName = folderName;
        this.folderColor = folderColor;
        this.user = user;
    }

}
