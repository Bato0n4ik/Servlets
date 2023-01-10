package org.andreev.sockets.service;

import java.util.Objects;

public final class FlightDto {
    private final Long id;
    private final String description;

    FlightDto(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public static FlightDtoBuilder builder() {
        return new FlightDtoBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof FlightDto)) return false;
        final FlightDto other = (FlightDto) o;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (!Objects.equals(this$id, other$id)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (!Objects.equals(this$description, other$description))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        return result;
    }

    public String toString() {
        return "FlightDto(id=" + this.getId() + ", description=" + this.getDescription() + ")";
    }

    public static class FlightDtoBuilder {
        private Long id;
        private String description;

        FlightDtoBuilder() {
        }

        public FlightDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public FlightDtoBuilder description(String description) {
            this.description = description;
            return this;
        }

        public FlightDto build() {
            return new FlightDto(id, description);
        }

        public String toString() {
            return "FlightDto.FlightDtoBuilder(id=" + this.id + ", description=" + this.description + ")";
        }
    }
}
