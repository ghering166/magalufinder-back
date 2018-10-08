

package com.magalufinder.util;


import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ProductStoreTO implements Serializable {

	private static final long serialVersionUID = 7063413446774490274L;

	public ProductStoreTO() {
	}

	@Getter
	@Setter
	private Long idStore;

	@Getter
	@Setter
	private Long idProduct;

	@Getter
	@Setter
	private Long codeProduct;

	@Getter
	@Setter
	private Long codeStore;

	@Getter
	@Setter
	private String descriptionStore;

	@Getter
	@Setter
	private String descriptionProduct;

	@Getter
	@Setter
	private BigDecimal value;

	@Getter
	@Setter
	private Long distance;

}
