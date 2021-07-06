package lk.car.rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingList {
  private BookingDTO bookingDTO;
  private BookingDetailDTO bookingDetailDTO;

}
