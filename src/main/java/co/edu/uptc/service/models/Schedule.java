package co.edu.uptc.service.models;

import co.edu.uptc.service.utils.Days;
import co.edu.uptc.service.utils.Hours;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Schedule {
    private Days day;
    private Hours hour;
}
