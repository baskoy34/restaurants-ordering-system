package ros.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeskDto {

	private long id;

	private Integer deskNo;

	private String qrCode;

	private StoreDto store;

	private List<ErrandDto> errands;
}
