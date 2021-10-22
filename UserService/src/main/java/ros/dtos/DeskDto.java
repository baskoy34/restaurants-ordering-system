package ros.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeskDto {

	private long id;

	private Integer deskNo;

	@Column(nullable = false)
	private boolean active;

	private String qrCode;

	private StoreDto store;

	private List<ErrandDto> errands;
}
