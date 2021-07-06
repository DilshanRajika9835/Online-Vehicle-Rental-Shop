package lk.car.rental.service.impl;

import lk.car.rental.dto.BookingDTO;
import lk.car.rental.dto.BookingDetailDTO;
import lk.car.rental.entity.Booking;
import lk.car.rental.entity.BookingDetail;
import lk.car.rental.entity.Car;
import lk.car.rental.entity.Employee;
import lk.car.rental.repo.BookingDetailRepo;
import lk.car.rental.repo.BookingRepo;
import lk.car.rental.service.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    BookingDetailRepo bookingDetailRepo;
    @Override
    public boolean addBooking(BookingDTO BK, BookingDetailDTO BKD) {
        final Booking booking = modelMapper.map(BK, Booking.class);
        final Booking save = bookingRepo.save(booking);
        if(save!=null){
            final Booking booking1 = modelMapper.map(BKD.getBooking(), Booking.class);
            final Employee employee = modelMapper.map(BKD.getEmployee(), Employee.class);
            final Car car = modelMapper.map(BKD.getCar(), Car.class);
            final BookingDetail saveAll = bookingDetailRepo.save(new BookingDetail( BKD.getPickLocate(),
                    BKD.getPickTime(), BKD.getPickDate(),
                    BKD.getDropLocate(), BKD.getDropTime(), BKD.getDropDate(), booking1, employee, car));
            if(saveAll!=null){
              return true;
            }
        }
        return false;
    }

    @Override
    public String getBookingID() {
        String orderid = "ORD0001";
        final String bookingID = bookingRepo.getOrderID();
        if(bookingID!=null){
            String[] split = bookingID.split("ORD");
            int id=Integer.parseInt(split[1])+1;
            if(id<10){
                orderid="ORD000"+id;
            }else if(id<100){
                orderid="ORD00"+id;
            }else if(id<1000) {
                orderid="ORD0"+id;
            }else {
                orderid="ORD"+id;
            }

        }
        return orderid;

    }

    @Override
    public List<Object[]> getCustomerBookingList(String CustomerNIC) {
        final List<Object[]> list = bookingDetailRepo.getCustomerBookingDetails(CustomerNIC);

        if(list.size()!=0){
            return list;
        }

        return null;

    }
}
