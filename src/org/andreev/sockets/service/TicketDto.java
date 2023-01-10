package org.andreev.sockets.service;

import java.util.Objects;

public final class TicketDto {
    private final Long id;
    private final Long flightId;
    private final String seatNo;

    TicketDto(Long id, Long flightId, String seatNo) {
        this.id = id;
        this.flightId = flightId;
        this.seatNo = seatNo;
    }

    public static TicketDtoBuilder builder() {
        return new TicketDtoBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public Long getFlightId() {
        return this.flightId;
    }

    public String getSeatNo() {
        return this.seatNo;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TicketDto)) return false;
        final TicketDto other = (TicketDto) o;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (!Objects.equals(this$id, other$id)) return false;
        final Object this$flightId = this.getFlightId();
        final Object other$flightId = other.getFlightId();
        if (!Objects.equals(this$flightId, other$flightId)) return false;
        final Object this$seatNo = this.getSeatNo();
        final Object other$seatNo = other.getSeatNo();
        if (!Objects.equals(this$seatNo, other$seatNo)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $flightId = this.getFlightId();
        result = result * PRIME + ($flightId == null ? 43 : $flightId.hashCode());
        final Object $seatNo = this.getSeatNo();
        result = result * PRIME + ($seatNo == null ? 43 : $seatNo.hashCode());
        return result;
    }

    public String toString() {
        return "TicketDto(id=" + this.getId() + ", flightId=" + this.getFlightId() + ", seatNo=" + this.getSeatNo() + ")";
    }

    public static class TicketDtoBuilder {
        private Long id;
        private Long flightId;
        private String seatNo;

        TicketDtoBuilder() {
        }

        public TicketDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public TicketDtoBuilder flightId(Long flightId) {
            this.flightId = flightId;
            return this;
        }

        public TicketDtoBuilder seatNo(String seatNo) {
            this.seatNo = seatNo;
            return this;
        }

        public TicketDto build() {
            return new TicketDto(id, flightId, seatNo);
        }

        public String toString() {
            return "TicketDto.TicketDtoBuilder(id=" + this.id + ", flightId=" + this.flightId + ", seatNo=" + this.seatNo + ")";
        }
    }
}
