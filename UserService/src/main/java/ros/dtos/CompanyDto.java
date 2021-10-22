package ros.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {

	private long id;

	private String name;

	private String address;

	private String phone;

	private Integer storeNumber;

    private Date registerDAte;

    private Date memberEndDate;

	private Boolean active;

	private List<StoreDto> stores;

	private CompanyCustomizeDto companyCustomize;
	
}
