package ros.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
	
	@Lob
	@Column(nullable = false)
	private String qrCode;
	

	private String store;
	
	@OneToMany(mappedBy = "desk")
	private List<Errand> errands;


}
