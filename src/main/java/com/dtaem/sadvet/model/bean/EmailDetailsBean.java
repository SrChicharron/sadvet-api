package com.dtaem.sadvet.model.bean;

import com.dtaem.sadvet.model.entity.Receta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetailsBean {
    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;

    private Float total;

    private List<Receta> productos;
}
