package ro.remro.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;


@Entity
@Table
public class Remorca {
    @Id
    private String carNumber;
    private String masa_Utila;
    private String masa_Maxima;
    private String model;
    private String nr_Identificare;
    private Date data_Verificare;


    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getMasa_Utila() {
        return masa_Utila;
    }

    public void setMasa_Utila(String masa_Utila) {
        this.masa_Utila = masa_Utila;
    }

    public String getMasa_Maxima() {
        return masa_Maxima;
    }

    public void setMasa_Maxima(String masa_Maxima) {
        this.masa_Maxima = masa_Maxima;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNr_Identificare() {
        return nr_Identificare;
    }

    public void setNr_Identificare(String nr_Identificare) {
        this.nr_Identificare = nr_Identificare;
    }

    public Date getData_Verificare() {
        return data_Verificare;
    }

    public void setData_Verificare(Date data_Verificare) {
        this.data_Verificare = data_Verificare;
    }

    @Override
    public String toString() {
       /*return "Remorca{" +
                "nr_Inmatriculare='" + nr_Inmatriculare + '\'' +
  //            ", masa_Utila=" + masa_Utila +
//                ", masa_Maxima=" + masa_Maxima +
               ", ro.model='" + ro.model + '\'' +
//                ", nr_Identificare='" + nr_Identificare + '\'' +
//                ", data_Verificare=" + data_Verificare +
                '}';*/
        return carNumber;
    }
}
