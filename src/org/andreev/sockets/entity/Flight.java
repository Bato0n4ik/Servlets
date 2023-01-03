package org.andreev.sockets.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Flight {
    private Long id;
    private String flightNo;
    private LocalDateTime departureDate;
    private String departureAirportCode;
    private LocalDateTime arrival_date;
    private String arrivalAirportCode;
    private Integer aircraftId;

    public Flight(Long id, String flightNo, LocalDateTime departureDate, String departureAirportCode,
                  LocalDateTime arrival_date, String arrivalAirportCode, Integer aircraftId, FlightStatus status) {
        this.id = id;
        this.flightNo = flightNo;
        this.departureDate = departureDate;
        this.departureAirportCode = departureAirportCode;
        this.arrival_date = arrival_date;
        this.arrivalAirportCode = arrivalAirportCode;
        this.aircraftId = aircraftId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public LocalDateTime getArrival_date() {
        return arrival_date;
    }

    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public Integer getAircraftId() {
        return aircraftId;
    }

    public FlightStatus getStatus() {
        return status;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public void setArrival_date(LocalDateTime arrival_date) {
        this.arrival_date = arrival_date;
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id.equals(flight.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightNo='" + flightNo + '\'' +
                ", departureDate=" + departureDate +
                ", departureAirportCode='" + departureAirportCode + '\'' +
                ", arrival_date=" + arrival_date +
                ", arrivalAirportCode='" + arrivalAirportCode + '\'' +
                ", aircraftId=" + aircraftId +
                ", status=" + status +
                '}';
    }

    public void setAircraftId(Integer aircraftId) {
        this.aircraftId = aircraftId;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    private FlightStatus status;
}
