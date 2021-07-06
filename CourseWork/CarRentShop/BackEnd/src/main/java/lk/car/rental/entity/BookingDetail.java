package lk.car.rental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class BookingDetail {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "no")
    private int no;
    private String pickLocate;
    private String pickTime;
    private String pickDate;
    private String dropLocate;
    private String dropTime;
    private String dropDate;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "bookingID", referencedColumnName = "bookingID")
    private Booking booking;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "empNIC", referencedColumnName = "empNIC")
    private Employee employee;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "carID", referencedColumnName = "carID")
    private Car car;

 public BookingDetail(String pickLocate, String pickTime, String pickDate, String dropLocate, String dropTime, String dropDate, Booking booking, Employee employee, Car car) {
  this.pickLocate = pickLocate;
  this.pickTime = pickTime;
  this.pickDate = pickDate;
  this.dropLocate = dropLocate;
  this.dropTime = dropTime;
  this.dropDate = dropDate;
  this.booking = booking;
  this.employee = employee;
  this.car = car;
 }

    /*
     @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reg_id",referencedColumnName = "reg_id",insertable = false,updatable = false)
    private Car reg_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_nic",referencedColumnName = "emp_nic",insertable = false,updatable = false)
    private Employee emp_nic;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id",referencedColumnName = "order_id",insertable = false,updatable = false)
    private Booking order_id;
*/


}
