package lk.car.rental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Booking {
    @Id
    private String bookingID;
    private String date;
    private String time;
   @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn( name = "customerNIC", referencedColumnName = "customerNIC")
    private Customer customer;




/*   @OneToMany(mappedBy = "order_id",cascade = CascadeType.ALL)
    private List<BookingDetail> bookingDetail;*/


}
