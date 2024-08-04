package br.com.ekan.avaliacao.ekan.entity.beneficiary;

import br.com.ekan.avaliacao.ekan.entity.document.Document;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "BENEFICIARIO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Beneficiary {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotBlank
  @Pattern(regexp = "\\S+", message = "O campo [username] nao deve conter espaco")
  @Column(unique = true, nullable = false)
  private String username;

  @Column(name = "SENHA", nullable = false)
  private String password;

  @Column(name = "NOME")
  private String name;

  @Column(name = "TELEFONE")
  private String telephone;

  @Column(name = "DATA_NASCIMENTO")
  private LocalDateTime dateBirth;

  @Column(name = "DATA_INCLUSAO")
  @CreationTimestamp
  private LocalDateTime dateInclusion;

  @Column(name = "DATA_ATUALIZACAO")
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @JoinColumn(name = "DOCUMENTO")
  @OneToMany
  private List<Document> documents;

}
