package ros.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Desk {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private Integer deskNo;

	@Column(nullable = false)
	private boolean active;
	
	@Lob
	@Column(nullable = false)
	private String qrCode;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Store store;
	
	@OneToMany(mappedBy = "desk")
	private List<Errand> errands;
}
