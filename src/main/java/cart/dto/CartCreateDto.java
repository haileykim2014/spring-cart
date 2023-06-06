package cart.dto;

import cart.domain.Cart;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Builder
public class CartCreateDto {

  private final Long productId;
  private final int count;

  public Cart toEntity(Long memberId) {
    return Cart.builder()
        .productId(getProductId())
        .memberId(memberId)
        .count(getCount())
        .build();
  }
}
